package Server;

import java.security.NoSuchAlgorithmException;

public class accountHandler{
 
	public account loginAccount;

	public accountHandler() {

	}

	public boolean loginAccountHandler(String username, String password) throws NoSuchAlgorithmException {

		if(loginAccount.doesAccountExist(username)) {
			if(attemptLogin(password)) 
				return true;
		}
		return false;
	}

	public boolean createAccountHandler(String username, String password, String email) {
		
		if(!loginAccount.doesAccountExist(username)) {
			loginAccount.createUserAccount(username, password, email);
			return true;
		}
		return false;
	}
	
	public account forgotAccountHandler(String email) {
		
		if(loginAccount.doesAccountExist(email)) {
			loginAccount.fetchAccountInfo(email);
			return loginAccount;
		}
		return null;
		
	}

	public boolean attemptLogin(String password) throws NoSuchAlgorithmException { 

		if (loginAccount.getPassword().equals(loginAccount.hashPassword(password))) 
			return true;
		else
			return false;
	}
}
