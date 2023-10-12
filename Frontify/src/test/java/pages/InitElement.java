package pages;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class InitElement extends Base {

	public InitElement(WebDriver driver) {

		PageFactory.initElements(driver, MediaLibrary.class);
	}
	public static void initializelements(WebDriver driver) {
	}
	
}
