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

public class HomePageTest extends TestCase   {
   private WebDriver driver;

   @Test
    public void testSetup() throws Exception{
        URL url = new URL("http://127.0.0.1:4444/wd/hub/");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setBrowserName("firefox");
        capabilities.setJavascriptEnabled(true);
        this.driver = new RemoteWebDriver(url, capabilities);
        driver.get("http://encuestame.org/demo/");
        // Test Tweetpoll Menu
        WebElement element = driver.findElement(By.linkText("TweetPoll"));
        assertNotNull(element);
        element.click();
     }

    @After
    public void tearDown() throws Exception {
        this.driver.quit();
    }
}
