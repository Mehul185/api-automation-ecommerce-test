package resources;

public enum APIResources {
	
	LoginApi("/api/ecom/auth/login");
	
	private String resource;	

	APIResources(String resource) {
		this.resource = resource;
	}

	public String getResource() {
		return resource;
	}
	
}
