package page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchEquipmentPage {
	WebDriver driver;
	@FindBy(xpath="//a[@ui-sref=\"console.devices\"]")
	WebElement deviceButton;
	@FindBy(xpath="//input[@class='th-form-input empty lg:tw-min-w-[240px] ng-untouched ng-pristine ng-valid']")
	WebElement search;
	@FindBy(xpath="//td[@class= 'tw-py-2 tw-px-4 ng-scope tw-whitespace-nowrap']")
	List<WebElement> searchResults;
	public SearchEquipmentPage(WebDriver driver) {
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	public void navigateTo() {
		deviceButton.click();
	}
	public void searchDevice(String device_name) {
		search.sendKeys(device_name);
	}
	public boolean isEquipmentFound(String equipmentName) {
        boolean found = false;
        for (WebElement result : searchResults) {
            if (result.getText().contains(equipmentName)) {
                found = true;
                break;
            }
        }
        return found;
    }
}
