package test;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import base.Base;

import pages.MediaLibrary;

public class Search extends Base{
	
	@Test(priority=2)
	public void TC002_ViewAssetGreenCoconut() throws InterruptedException{

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));	
	driver.get("https://demo.frontify.com/d/FkBpT1nT1tqo");
	MediaLibrary.mediaLibraryLink.click();
	wait.until(ExpectedConditions.visibilityOf(MediaLibrary.SearchValue));
	MediaLibrary.SearchValue.sendKeys("green");
	wait.until(ExpectedConditions.visibilityOf(MediaLibrary.SearchButton));
	MediaLibrary.SearchButton.click();
	Thread.sleep(5000);
	wait.until(ExpectedConditions.visibilityOf(MediaLibrary.SelectCollection));
	MediaLibrary.SelectCollection.click();
	wait.until(ExpectedConditions.elementToBeClickable(MediaLibrary.SelectCoconut));
	MediaLibrary.SelectCoconut.click();

}
	
	@Test(priority=1)
	public void TC003_DownloadAssetPalm() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));	
		driver.get("https://demo.frontify.com/d/FkBpT1nT1tqo");
		MediaLibrary.mediaLibraryLink.click();
		wait.until(ExpectedConditions.visibilityOf(MediaLibrary.SearchValue));
		MediaLibrary.SearchValue.sendKeys("palm");
		wait.until(ExpectedConditions.visibilityOf(MediaLibrary.SearchButton));
		MediaLibrary.SearchButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(MediaLibrary.SelectCollectionPalm));
		MediaLibrary.SelectCollectionPalm.click();
		wait.until(ExpectedConditions.elementToBeClickable(MediaLibrary.SelectPalm));
		MediaLibrary.SelectPalm.click();
		wait.until(ExpectedConditions.elementToBeClickable(MediaLibrary.Download));
		MediaLibrary.Download.click();
	}
	
	@Test(priority=3)
	public void TC001_SearchAssetNoResult() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));	
		driver.get("https://demo.frontify.com/d/FkBpT1nT1tqo");
		Assert.assertTrue(MediaLibrary.mediaLibraryLink.isDisplayed());
		MediaLibrary.mediaLibraryLink.click();
		wait.until(ExpectedConditions.visibilityOf(MediaLibrary.SearchValue));
		Assert.assertTrue(MediaLibrary.SearchValue.isDisplayed());
		MediaLibrary.SearchValue.sendKeys("abc");
		wait.until(ExpectedConditions.visibilityOf(MediaLibrary.SearchButton));
		Assert.assertTrue(MediaLibrary.SearchButton.isDisplayed());
		MediaLibrary.SearchButton.click();
		wait.until(ExpectedConditions.visibilityOf(MediaLibrary.WrongSearchMsg));
		boolean actual = MediaLibrary.WrongSearchMsg.isDisplayed();
		Assert.assertTrue(actual);
		String actualresult = MediaLibrary.WrongSearchMsg.getText();
		String expectedresult = "Have you checked the spelling? Try a different search term.";
		Assert.assertEquals(actualresult, expectedresult);
		


	}
	
}


