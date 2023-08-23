package newLogin;

public class loginController {
	userInfo user = new userInfo();

	public String[] passUserInfo (String username, char[] password) {
		
		String role[] = user.validateInfo(username, password);
		return role;

	}
}
