package com.udemy.java.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.base.Predicate;
import com.udemy.java.predicate.Rules;
import com.udemy.java.supplier.DriverFactory;

public class DriverTest_9 {

	private WebDriver driver;

	@BeforeTest
	@Parameters("browser")
	public void setDriver(@Optional("chrome") String browser) {
		this.driver = DriverFactory.getDriver(browser);
	}

	// https://the-internet.herokuapp.com/broken_images

	@Test
	public void googleTest() {
		this.driver.get("https://google.com/");
		this.driver.findElements(By.tagName("a")).stream().map(WebElement::getText).map(String::trim)
				.filter(e -> e.length() > 0).filter(e -> !e.toLowerCase().contains("s")).map(String::toUpperCase)
				.forEach(System.out::println);
	}

	@Test
	public void googleTest2() {
		this.driver.get("https://google.com/");
		List<WebElement> elements = this.driver.findElements(By.tagName("a"));
		// elements.forEach(e -> System.out.println(e.getText()));

		System.out.println("Before size = " + elements.size());
		Predicate<WebElement> isBlank = e -> e.getText().trim().length() == 0;
		Predicate<WebElement> hasS = e -> e.getText().toLowerCase().contains("s");

		elements.removeIf(isBlank.or(hasS));

		System.out.println("after size = " + elements.size());

		elements.forEach(e -> System.out.println(e.getText()));
	}

	@Test
	public void googleTest3() {
		this.driver.get("https://google.com/");
		List<WebElement> elements = this.driver.findElements(By.tagName("a"));
		// elements.forEach(e -> System.out.println(e.getText()));

		System.out.println("Before size = " + elements.size());

		// Rules.get().forEach(rule -> elements.removeIf(rule));

		Rules.get().forEach(elements::removeIf);

		System.out.println("after size = " + elements.size());

		elements.forEach(e -> System.out.println(e.getText()));
	}

	@Test
	public void googleTest4() {
		this.driver.get("https://google.com/");
		List<WebElement> elements = this.driver.findElements(By.tagName("a"));

		elements.stream().filter(e -> e.getText().trim().length() != 0)
				.filter(e -> !e.getText().toLowerCase().contains("S")).map(e -> e.getText().toUpperCase()) // after
																											// calling
																											// map it
																											// becomes
																											// stream of
																											// maps
				.forEach(e -> System.out.println(e));

		// OR
		System.out.println("============================================================================");
		elements.stream().map(e -> e.getText()) // calling map here gives stram of string
				.map(e -> e.trim()).filter(e -> e.trim().length() != 0).filter(e -> !e.toLowerCase().contains("S"))
				.map(e -> e.toUpperCase()).forEach(e -> System.out.println(e));

		// OR
		System.out.println("============================================================================");
		elements.stream().map(WebElement::getText) // calling map here gives stram of string
				.map(String::trim).filter(e -> e.trim().length() != 0).filter(e -> !e.toLowerCase().contains("S"))
				.map(String::toUpperCase).forEach(System.out::println);

	}

	@AfterTest
	public void quitDriver() {
		this.driver.quit();
	}

}
