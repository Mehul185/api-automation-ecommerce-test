package resources;

import payloads.Request.LoginRequest;

public class BuildRequest {
	
	public LoginRequest loginRequestStructure(String userEmail, String userPassword) {
		LoginRequest loginRequest = new LoginRequest();
		loginRequest.setUserEmail(userEmail);
		loginRequest.setUserPassword(userPassword);
		
		return loginRequest;
	}
	

}
