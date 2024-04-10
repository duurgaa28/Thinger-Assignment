package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import util.WaitUtil;

public class LoginPage {
	WebDriver driver;
	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement userName;
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement passWord;
	@FindBy(xpath="//button[@class='ant-btn tw-w-full tw-mb-6 ant-btn-primary ant-btn-lg']")
	WebElement loginButton;
	@FindBy(xpath="//div[@id='navigation-toolbar']")
	WebElement dashBoard;
	@FindBy(xpath="//div[@class='ant-alert-content ng-tns-c2522271894-2 ng-star-inserted']")
	WebElement invalidWarning;
	
	public LoginPage(WebDriver driver) {
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	}

	    public void setUsername(String username) {
	       userName.sendKeys(username);
	    }

	    public void setPassword(String password) {
	       passWord.sendKeys(password);
	    }

	    public void clickLoginButton() {
	       loginButton.click();
	    }
	    public void waitForDashboardElementToAppear() {
	    	WaitUtil waitUtil = new WaitUtil(driver);
	    	waitUtil.explicitWait(25,dashBoard );
	    }

	    public void verifyLoginSuccess() {
	        Assert.assertEquals(driver.getTitle(), "Statistics");
	    }
	    public void waitForWarningToAppear() {
	    	WaitUtil waitUtil = new WaitUtil(driver);
	    	waitUtil.explicitWait(25,invalidWarning);
	    }
	    public void invalidLoginVerify() {
	    	Assert.assertEquals(invalidWarning.getText(),"invalid username or password");
	    }
	}

