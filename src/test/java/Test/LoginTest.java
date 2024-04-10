package Test;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.DriveIntiation;
import page.LoginPage;
	public class LoginTest extends DriveIntiation {

	   LoginPage loginPage;

	       

	        @Test
	        public void testLoginWithValidCredentials() {
	        	
	            String username = "adminrealit";
	            String password = "admin@realit";

	            loginPage.setUsername(username);
	            loginPage.setPassword(password);
	            loginPage.clickLoginButton();
                loginPage.waitForDashboardElementToAppear();
                loginPage.verifyLoginSuccess();
	     
	        }
	        }
	    