package ServidorPassword;

import java.io.Serializable;

public class Password implements Serializable{
	
	String Pass;
	String PassEncrypt;
	
	//constructor
	public Password(String pass, String passEncrypt) {
		
		this.Pass  = pass;
		this.PassEncrypt = passEncrypt;
	}
	
	//GETTERS/SHETTERS

	public String getPass() {
		return Pass;
	}

	public void setPass(String pass) {
		Pass = pass;
	}

	public String getPassEncrypt() {
		return PassEncrypt;
	}

	public void setPassEncrypt(String passEncrypt) {
		PassEncrypt = passEncrypt;
	}

	@Override
	public String toString() {
		return "Password [Pass=" + Pass + ", PassEncrypt=" + PassEncrypt + "]";
	}
	
	
	
	
	
}
