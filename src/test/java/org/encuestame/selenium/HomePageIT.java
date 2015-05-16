package org.encuestame.selenium;

import junit.framework.TestCase;
import org.junit.After;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.internal.FindsById;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


/**
 * Selenium Test Cases.
 * @author Morales, Diana Paola paolaATencuestame.org
 * @since July 15, 2014
 */

public class HomePageIT extends TestCase   {

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        // Choose the browser, version, and platform to test
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("version", "17");
        capabilities.setCapability("platform", Platform.XP);
        // Create the connection to Sauce Labs to run the tests
        this.driver = new RemoteWebDriver(
                new URL("http://jotadeveloper:a7a381a1-06d0-4416-8e89-fe449e663c0f@localhost:4445/wd/hub"),
                capabilities);
    }

    @Test
    public void testwebDriverTest() throws Exception {
        // Make the browser get the page and check its title
        driver.get("http://localhost:8080/encuestame/home");
        // Test Tweetpoll Menu
        WebElement element = driver.findElement(By.linkText("TweetPolls"));
        assertNotNull(element);
        element.click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}
