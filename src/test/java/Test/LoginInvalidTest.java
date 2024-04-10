package Test;



	import org.testng.annotations.Test;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebDriverException;
	import org.openqa.selenium.remote.Augmenter;
	import org.testng.Assert;
	import org.testng.ITestResult;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Listeners;
	import org.testng.annotations.Test;

import Base.DriveIntiation;
import page.LoginPage;
import util.RetryAnalyzer;
import util.ScreenShotUtil;


	@Listeners(util.TestListener.class)
	public class LoginInvalidTest extends DriveIntiation {

	   LoginPage loginpage;

	    
	    @Test(retryAnalyzer = RetryAnalyzer.class)
	    public void testLoginWithInvalidCredentials() {
	    	loginpage=new LoginPage (driver);
	        String invalidUsername = "invaliduser";
	        String invalidPassword = "invalidpassword";

	        loginpage.setUsername(invalidUsername);
	        loginpage.setPassword(invalidPassword);
	        loginpage.clickLoginButton();
	        loginpage.waitForWarningToAppear();
            loginpage.invalidLoginVerify();
	    }
	    

	    
	}

