package com.udemy.java.test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.udemy.java.supplier.DriverFactory;
import com.udemy.java.util.LinkUtil;

public class BrokenLinkTest_15 {

	private WebDriver driver;

	@BeforeTest
	@Parameters("browser")
	public void setDriver(@Optional("chrome") String browser) {
		this.driver = DriverFactory.getDriver(browser);
	}

	// https://the-internet.herokuapp.com/broken_images

	@Test
	public void linkTest() {
		this.driver.get("https://www.google.com");

		System.out.println("Before :: " + LocalDateTime.now());

		List<String> list = this.driver.findElements(By.xpath("//*[@href]")).stream().parallel()
				.map(e -> e.getAttribute("href")).filter(src -> LinkUtil.getResponseCode(src) != 200)
				.collect(Collectors.toList());

		System.out.println("After :: " + LocalDateTime.now());
	}

	@AfterTest
	public void quitDriver() {
		this.driver.quit();
	}
}
