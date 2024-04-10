package util;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import util.ScreenShotUtil;

public class TestListener implements ITestListener {

    public void onTestStart(ITestResult result) {
        System.out.println("Test started: " + result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Test succeeded: " + result.getName());
    }
    
    public static void takeScreenshotOnFailure(ITestResult result, String screenshotFile, WebDriver driver) throws IOException {
        		 System.out.println("Test failed: " + result.getName());
        	    ScreenShotUtil.takeScreenshotOnFailure(result, screenshotFile, driver);
        	}
    

    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped: " + result.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test failed but within success percentage: " + result.getName());
    }

    public void onStart(ITestContext context) {
        System.out.println("Test suite started: " + context.getName());
    }

    public void onFinish(ITestContext context) {
        System.out.println("Test suite finished: " + context.getName());
    }
}