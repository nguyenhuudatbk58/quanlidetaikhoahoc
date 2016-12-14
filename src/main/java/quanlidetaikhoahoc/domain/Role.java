package quanlidetaikhoahoc.domain;

public enum Role {

	USER("USER"), ADMIN("ADMIN");
	
	private String value;

	public String getValue() {
		return value;
	}

	private Role(String value) {
		this.value = value;
	}
	
	


}
