package org.encuestame.selenium;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.nio.charset.MalformedInputException;
import java.util.concurrent.TimeUnit;

/**
 * Created by dmorales on 15.05.15.
 */
public abstract class AbstractSelenium extends TestCase{

    protected WebDriver driver;

    @Before
    public void setUp() throws Exception {

        final URL url = new URL("http://127.0.0.1:4444/wd/hub/");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName("chrome");
        cap.setJavascriptEnabled(true);
        this.driver = new RemoteWebDriver(url, cap);
        driver.get("http://localhost:8080/encuestame/home");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /**
     * Helper to Login Encuestame.
     */
    public void loginEnme() {
        //driver.get("http://localhost:8080/encuestame/home");
        WebElement signin_home = driver.findElement(By.id("signin-home"));
        assertNotNull(signin_home);
        signin_home.click();
        // Input
        WebElement username = driver.findElement(By.id("j_username"));
        assertNotNull(username);
        WebElement password = driver.findElement(By.id("j_password"));
        assertNotNull(password);
        // Write input
        username.sendKeys("dianmorales");
        password.sendKeys("12345");
        WebElement signInbutton = driver.findElement(By.id("signin-button"));
        assertNotNull(signInbutton);
        signInbutton.click();
    }

    /**
     *
     * @throws Exception

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
     */
}
