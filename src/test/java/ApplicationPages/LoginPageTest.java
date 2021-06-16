package ApplicationPages;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.base;
import org.testng.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class LoginPageTest extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	LoginPage login;
	LandingPage landingPage;

	@BeforeTest

	public void setup() throws IOException, InterruptedException {
		driver = initializeDriver();
		login = new LoginPage(driver);
		landingPage = new LandingPage(driver);
		driver.get(prop.getProperty("url"));
		landingPage.getLogin();

	}

	@Test
	public void validateLoginPageTitle() {
		String actualTitle = login.validatelogintitle();
		Assert.assertEquals(actualTitle, "Online Shopping - Shop for Clothing, Shoes & Accessories in India at Koovs");
	}

	@Test
	public void validateLogo() {
		boolean Actual = login.validateLogo();
		Assert.assertTrue(Actual);
	}

	@Test(dataProvider = "getData")

	public void validateLogin(String emailid, String pwd) throws InterruptedException {

		login.loginsuccess(emailid, pwd);
	}

	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[1][2];
		// 0th row
		data[0][0] = "tahera.firdose242017@gmail.com";
		data[0][1] = "Test@12345";

		return data;

	}

	@AfterTest

	public void teardown() {
		driver.close();
	}

}
