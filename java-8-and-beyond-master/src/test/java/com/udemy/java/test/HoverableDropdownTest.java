package com.udemy.java.test;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;
import com.udemy.java.supplier.DriverFactory;

public class HoverableDropdownTest {

	private WebDriver driver;
	private Actions actions;

	@BeforeTest
	@Parameters("browser")
	public void setDriver(@Optional("chrome") String browser) {
		this.driver = DriverFactory.getDriver(browser);
		this.actions = new Actions(driver);
	}

	@Test(dataProvider = "linkProvider")
	public void dropdownTest(String path) {
		this.driver.get(
				"C:\\Users\\Vijay\\Documents\\Practice\\sdetlambdarepo\\java-8-and-beyond-master\\java-8-and-beyond-master\\src\\main\\java\\com\\udemy\\java\\assignment\\Codeply simple HTML_CSS_JS preview.html");
		String[] split = path.split("=>");

		Arrays.stream(split).map(s -> s.trim()).map(s -> By.linkText(s)).map(by -> driver.findElement(by))
				.map(ele -> actions.moveToElement(ele)).forEach(a -> a.perform());

		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

	}

	@DataProvider(name = "linkProvider")
	public Object[] testdata() {
		return new Object[] { "Dropdown => Dropdown Link 2", "Dropdown => Dropdown Link 5 => Dropdown Submenu Link 5.1",
				"Dropdown => Dropdown Link 5 => Dropdown Submenu Link 5.4 => Dropdown Submenu Link 5.4.2", };
	}

	@AfterTest
	public void quitDriver() {
		this.driver.quit();
	}

}
