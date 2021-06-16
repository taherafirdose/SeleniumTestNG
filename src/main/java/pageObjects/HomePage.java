package pageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {

	public WebDriver driver;
	@FindBy(xpath = "//li[@class='koovs-header brand-menu__item']")
	public List<WebElement> menuTab;
	@FindBy(xpath = "//li[@class='koovs-header brand-menu__item']")
	public WebElement singleMenu;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ValidateMenuTabs() {
		String[] menu = { "MEN", "WOMEN", "THE BLOG", "KOOVSXYOU", "IN STYLE OF" };
		List menuList = Arrays.asList(menu);
		List<String> exactList = new ArrayList<String>();
		List<WebElement> menuActual = driver.findElements(By.xpath("//li[@class='koovs-header brand-menu__item']"));
		for (int i = 0; i < menuActual.size(); i++) {

			String ActualList = menuActual.get(i).getText();
			exactList.add(ActualList);
		}

		if (exactList.equals(menuList))

			Assert.assertTrue(true);

		else
			Assert.assertTrue(false);

	}

	public void ValidateWomenMenuisclicable() {
		int menuCount = menuTab.size();
		for (int i = 0; i < menuCount; i++) {
			String menuName = menuTab.get(i).getText();
			if (menuName.equalsIgnoreCase("WOMEN")) {
				menuTab.get(i).click();
				break;
			}
		}
	}

	public void ValidateWomenPageIsDisplayed() {
		String title = driver.getTitle();
		System.out.println(title);
		String Expectedtitle = "Online Shopping for Women - Shop Womens Clothing, Shoes & Accessories in India at Koovs";
		Assert.assertEquals(title, Expectedtitle);
	}

}
