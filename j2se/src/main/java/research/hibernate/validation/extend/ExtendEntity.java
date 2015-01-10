package research.hibernate.validation.extend;


public class ExtendEntity {

	@Password
	private String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
