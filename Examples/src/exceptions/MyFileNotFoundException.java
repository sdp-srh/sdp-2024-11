package exceptions;

public class MyFileNotFoundException extends Exception {

	@Override
	public String getMessage() {
		return "We are sorry, but the requested file does not exist";
	}
	
}
