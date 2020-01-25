package pers.david.annotation;

import java.util.List;

public class PasswordUtils {

	public PasswordUtils() {
	}

	@UseCase(id=47,description="Password must contains at least on numeric")
	public boolean validatePassword(String password){
		return password.matches("\\w*\\d\\w*");
	}
	
	@UseCase(id=48)
	public String encryptPassword(String password){
		return new StringBuffer(password).reverse().toString();
	}
	
	@UseCase(id=49, description="New password cant not equals previous used ones")
	public boolean checkForNewPassword(List<String> previousPassword,String password){
		return !previousPassword.contains(password);
	}
	
}
