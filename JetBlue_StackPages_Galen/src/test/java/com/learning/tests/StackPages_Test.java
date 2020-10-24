package com.jetblue.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.jetblue.components.GalenTestBase;

public class StackPages_Test extends GalenTestBase {

	/* Stack Page may consists of 
	 * 1) Global Header
	 * 2) Global Footer
	 * 3) BreadCrumbs
	 * 4) Navigation Blocks*/
	
	// 1366*768
	private static final int WAIT_TIME = 5;

	private static final String Environment = "https://www-int2.jetblue.com/";

	// Stack pages URL
	private static final String URL_OVERVIEW_CUSTOMER_ASSURANCE = "customer-assurance";

	// Spec file location for Stack Pages
	private static final String SPEC_OVERVIEW_CUSTOMER_ASSURANCE = "/specs/overviewTemplate_CustomerAssurance.gspec";

	@Test(dataProvider = "devices")
	public void overviewTemplate_CustomerAssurance(TestDevice device) throws IOException, InterruptedException {
		// load("/");
		loadRequiredPage(URL_OVERVIEW_CUSTOMER_ASSURANCE);
		checkLayout(SPEC_OVERVIEW_CUSTOMER_ASSURANCE, device.getTags());
	}

	private void loadRequiredPage(String pageURL_ToLoad) throws InterruptedException {
		getDriver().get(Environment + pageURL_ToLoad);
		getDriver().manage().window().maximize();
		Thread.sleep(WAIT_TIME);
		// handleCookiesBasedModal();

	}

	private void handleCookiesBasedModal() throws InterruptedException {
		String cookiesBasedModal_Button_AcceptAndContinueXPath = "//span[contains(text(),' Accept and continue ')]";
		Thread.sleep(WAIT_TIME);
		WebElement buttonAcceptAndContinue = getDriver()
				.findElement(By.xpath(cookiesBasedModal_Button_AcceptAndContinueXPath));
		if (buttonAcceptAndContinue.isDisplayed()) {
			buttonAcceptAndContinue.click();
		}

	}

}
