package rentedbooks.api.rentedbooksapi.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import rentedbooks.api.rentedbooksapi.services.MyUserDetailsService;
import rentedbooks.api.rentedbooksapi.utills.JwtUtill;

@Component
public class JwtFilter extends OncePerRequestFilter {
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtill jwtUtill;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// need to check for the jwt
		final String authorizationHeader = request.getHeader("Authorization");  
		
		String username = null;
		String jwt = null;
		
		if(authorizationHeader !=null && authorizationHeader.startsWith("Bearer ")) {
			jwt = authorizationHeader.substring(7);
			username = jwtUtill.extractUsername(jwt);
			System.out.print(username);
			
		}
		
		if(username !=null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
			if(jwtUtill.validateToken(jwt, userDetails)) {
				UsernamePasswordAuthenticationToken upAuthToken = 
				new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				
				upAuthToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(upAuthToken);			
			
			
			}
		}
		
		filterChain.doFilter(request,response);
		
	}

}
