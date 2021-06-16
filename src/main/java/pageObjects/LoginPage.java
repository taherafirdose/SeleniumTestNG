package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	@FindBy(xpath = "//input[@id='login-email']")
	WebElement emailid;

	@FindBy(xpath = "//input[@id='login-pswd']")
	WebElement password;

	@FindBy(xpath = "//button[contains(text(),'LOG IN')]")
	WebElement Login;

	@FindBy(xpath = "//img[@src='https://images.koovs.com/uploads/koovs/logo.png']")
	WebElement Logo;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String validatelogintitle() {
		return driver.getTitle();
	}

	public boolean validateLogo() {

		return Logo.isDisplayed();
	}

	public void loginsuccess(String un, String pwd) throws InterruptedException {
		emailid.sendKeys(un);
		password.sendKeys(pwd);
		Login.click();
		Thread.sleep(3000);

	}

}
