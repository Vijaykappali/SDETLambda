package com.udemy.java.test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;
import com.udemy.java.pages.TableDemoPage_11;
import com.udemy.java.supplier.DriverFactory;

public class CheckboxSelectionTest_12 {

	private WebDriver driver;
	private TableDemoPage_11 tableDemoPage;

	@BeforeTest
	@Parameters("browser")
	public void setDriver(@Optional("chrome") String browser) {
		this.driver = DriverFactory.getDriver(browser);
		this.tableDemoPage = new TableDemoPage_11(driver);
	}

	@Test(dataProvider = "criteriaProvider")
	public void tableRowTest(Predicate<List<WebElement>> searchCriteria) {
		tableDemoPage.goTo();
		tableDemoPage.selectRows(searchCriteria);
		Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
	}

	@DataProvider(name = "criteriaProvider")
	public Object[] testdata() {
		return new Object[] { SearchCriteriaFactory.getCriteria("allMale"),
				SearchCriteriaFactory.getCriteria("allFemale"), SearchCriteriaFactory.getCriteria("allGender"),
				SearchCriteriaFactory.getCriteria("allAU"), SearchCriteriaFactory.getCriteria("allFemaleAU") };
	}

	@Test
	public void clickAllCheckBox() {
		this.driver.get(
				"C:\\Users\\Vijay\\Documents\\Practice\\sdetlambdarepo\\java-8-and-beyond-master\\java-8-and-beyond-master\\src\\test\\resources\\Java-For-SDET.html");
		List<WebElement> elements = this.driver.findElements(By.tagName("input"));

		elements.stream().forEach(WebElement::click);

	}

	@Test
	public void clickFemaleCheckBox() {
		this.driver.get(
				"C:\\Users\\Vijay\\Documents\\Practice\\sdetlambdarepo\\java-8-and-beyond-master\\java-8-and-beyond-master\\src\\test\\resources\\Java-For-SDET.html");
		List<WebElement> elements = this.driver.findElements(By.tagName("tr")); // rows, stream of web elelement

		elements.stream().skip(1).map(tr -> tr.findElements(By.tagName("td"))) // td list in each row , stream of list
																				// of web elemet
				.filter(tdList -> tdList.size() == 4) // to avoid index out of bounds exception if there are no tds in
														// tr
				.filter(tdList -> tdList.get(1).getText().equalsIgnoreCase("male")) // filter male
				.map(tdList -> tdList.get(3)) // get checkbox parent td for filtered male webelements
				.map(td -> td.findElement(By.tagName("input"))) // after getting 4th index td, need to find element for
																// checkbox
				.forEach(WebElement::click);

	}

	@AfterTest
	public void quitDriver() {
		this.driver.quit();
	}
}
