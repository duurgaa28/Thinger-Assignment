package Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.DriveIntiation;
import page.LoginPage;
import page.SearchEquipmentPage;
import util.RetryAnalyzer;

public class SearchEquipmentTest extends DriveIntiation {
 SearchEquipmentPage searchEquipmentPage;
 LoginPage loginPage;
 @BeforeMethod
 public void login() {
     String username = "adminrealit";
     String password = "admin@realit";

     LoginPage loginPage = new LoginPage(driver);
     loginPage.setUsername(username);
     loginPage.setPassword(password);
     loginPage.clickLoginButton();
     loginPage.waitForDashboardElementToAppear();
     loginPage.verifyLoginSuccess();
 }

 @Test(retryAnalyzer = RetryAnalyzer.class)
 public void searchEquipmentByName() {
     String equipmentName = "Solar Plant Transformer";

     searchEquipmentPage.navigateTo();
     searchEquipmentPage.searchDevice(equipmentName);
     searchEquipmentPage.isEquipmentFound(equipmentName);

}}
