package com.udemy.java.supplier;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.base.Supplier;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	private static final Supplier<WebDriver> chromeSupplier = () -> {
		// System.setProperty("webdriver.chrome.driver",
		// "/home/qa/.arquillian/drone/chrome/2.38/chromedriver");
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver();
	};

	private static final Supplier<WebDriver> firefoxSupplier = () -> {
		System.setProperty("webdriver.gecko.driver", "/home/qa/.arquillian/drone/firefox/geckodriver");
		return new FirefoxDriver();
	};

	private static final Map<String, Supplier<WebDriver>> MAP = new HashMap<>();

	static {
		MAP.put("chrome", chromeSupplier);
		MAP.put("firefox", firefoxSupplier);
	}

	public static WebDriver getDriver(String browser) {
		return MAP.get(browser).get();
	}

}
