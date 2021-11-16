package rentedbooks.api.rentedbooksapi.model;


public class AdminResponse {
	private final String jwt;
	
	public AdminResponse(String jwt) {
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}
}
