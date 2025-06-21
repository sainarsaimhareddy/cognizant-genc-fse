package DesignPatternsAndPrinciples;

//Logger class following Singleton Pattern and Single Responsibility Principle
class Logger {
    private static Logger logger;

    private Logger() {
        System.out.println("Logger instance created.");
    }

    public static Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    public void log() {
        System.out.println("Created log at XXXX");
    }


    // The following methods are not required as they violate the SRP:
    // private void printLogDetails() {}
    // private void sendLogDetails() {}
    // also should not have login and logout mechanisms 
}
//we need separate authorization service for logins and logouts.
class AuthorizationService{
	public static boolean authorizeLogin(String name,String password) {
		if(name.equals("admin") && password.equals("1234"))
			return true;
		return false;
	}
}
public class SingletonPatternExample {
    public static void main(String[] args) {
        System.out.println("Starting application. Getting Logger instance...");
        Logger logVar1 = Logger.getInstance();
        if (logVar1 != null) {
            System.out.println("Retrieved Logger instance");
        } else {
            System.out.println("Unable to get Logger instance. Please try again.");
        }
       // Logger logVar2 = Logger.getInstance();
        //System.out.println(logVar1 == logVar2 ? "Same reference - Singleton confirmed" : "Singleton pattern failed");
        if(AuthorizationService.authorizeLogin("admin","1234"))logVar1.log();
        else System.out.println("invalid credentials");
    }
}
