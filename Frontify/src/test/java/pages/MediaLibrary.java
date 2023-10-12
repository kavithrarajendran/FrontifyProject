package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.Base;

public class MediaLibrary extends Base{

	static WebDriver driver;

	public MediaLibrary(WebDriver driver) {
		MediaLibrary.driver = driver;
	}

	@FindBy(xpath = "//span[contains(text(),'media library')]")
	public static WebElement mediaLibraryLink ;
	
	@FindBy(xpath = "//input[@placeholder='Search assets']")
	public static WebElement SearchValue;
	
	@FindBy(xpath = "//span[contains(text(),'Search')]")
	public static WebElement SearchButton;
	
	@FindBy(xpath = "//div[contains(text(),'green coconuts')]")
	public static WebElement SelectCollection;
	
	@FindBy(css = "img[alt='coconut 2']")
	public static WebElement SelectCoconut;
	
	@FindBy(xpath = "//div[contains(text(),'palms')]")
	public static WebElement SelectCollectionPalm;
	
	@FindBy(css = "img[alt='coconut 24']")
	public static WebElement SelectPalm;
	
	@FindBy(xpath = "//button[@class='cm-btn cm-btn--secondary js-co-viewer__size-download-button']")
	public static WebElement Download;
	
	@FindBy(xpath = "//p[contains(text(),'Have you checked the spelling? Try a different search term.')]")
	public static WebElement WrongSearchMsg;
	
	
	

}
