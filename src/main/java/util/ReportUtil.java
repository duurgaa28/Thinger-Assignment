package util;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import util.ScreenShotUtil;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportUtil implements ITestListener {
	WebDriver driver;
	private static final ExtentReports extentReports;
    ExtentTest extentTest ;

    static {
        String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportPath);
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Test Automation Results");
        htmlReporter.config().setTheme(Theme.STANDARD);
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
    }
 
    public void onStart(ITestContext context) {
        System.out.println("Extent Report - Test Suite started: " + context.getName());
         extentTest = extentReports.createTest(context.getName());
    }

    public void onFinish(ITestContext context) {
        System.out.println("Extent Report - Test Suite finished: " + context.getName());
        extentReports.flush();
    }
public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, "Test passed");
	}
public void onTestFailure(ITestResult result){
		extentTest.log(Status.FAIL, "Test failed");
		
	try {
		ScreenShotUtil.takeScreenshotOnFailure(result, "Failed.png", driver);
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
public void onTestSkipped(ITestResult result) {
		extentTest.log(Status.SKIP, "Test Skipped");
	}

	public static ExtentReports getExtentReports() {
		return extentReports;
	}

}
