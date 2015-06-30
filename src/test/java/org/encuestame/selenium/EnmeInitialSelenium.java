package org.encuestame.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * Created by dmorales on 29/06/15.
 */
@RunWith(Concurrency.class)
 public class EnmeInitialSelenium extends EnmeLaunchTest{

    /**
     * WebDriver
     */
    private WebDriver driver;

    /**
     * Url Base
     */
    private String baseUrl;

    /**
     *
     */
    private String platform;

    /**
     *
     */
    private String browserName;

    /**
     *
     */
    private String urlNode;

    /**
     *
     */
    private String version;



    public EnmeInitialSelenium(String platform, String browserName, String urlNode) {
        //this.driver = driver;
        this.platform = platform;
        this.browserName = browserName;
        this.urlNode = urlNode;
    }


    /**
     *
     * @return
     */
    @Parameterized.Parameters
    public static LinkedList<String[]> getCapabilities() {
        LinkedList <String[]> env = new LinkedList<String[]>();
        env.add(new String[]{Platform.XP.toString()  , "chrome", "http://192.168.1.117:5542/wd/h/ub"});
        env.add(new String[]{Platform.XP.toString(),"firefox", "http://192.168.1.237:5541/wd/h/ub"});
        //env.add(new String[]{Platform.WIN8_1.toString(),"firefox", "http://192.168.1.117:5542/wd/h/ub"});

        //add more browsers here

        return env;
    }

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception{
        //new URL("http://YOUR_USERNAME:YOUR_ACCESS_KEY@ondemand.saucelabs.com:80/wd/hub"),
        final URL url = new URL(this.urlNode);
        // Choose the browser, version, and platform to test
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, browserName);
        desiredCapabilities.setCapability(CapabilityType.PLATFORM, platform);

        driver = new RemoteWebDriver(url, desiredCapabilities);

        baseUrl = "http://192.168.1.80:8080/encuestame/home";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    /**
     *
     */
    @Test
    public void testInitialEnmePages(){
         this.launchEnme(driver, baseUrl);

    }

    /**
     *
     */
    @After
    public void tearDown() {
        driver.quit();
    }
}
