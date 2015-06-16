package org.encuestame.selenium;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by dmorales on 5/26/15.
 */
public class TweetPollPageIT extends AbstractSelenium {

    /**
     * Test Home Popular Hashtags
     */
    @Test
    public void testHomePopularHashtags(){
        WebElement signin_home = driver.findElement(By.id("signin-home"));
        assertNotNull(signin_home);
        signin_home.click();
        // Input
        WebElement username = driver.findElement(By.id("j_username"));
        assertNotNull(username);
        WebElement password = driver.findElement(By.id("j_password"));
        assertNotNull(password);
        //
        username.sendKeys("dmorales");
        password.sendKeys("XSLFLD");
        WebElement signInbutton = driver.findElement(By.id("signin-button"));
        assertNotNull(signInbutton);
        signInbutton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://localhost:8080/encuestame/user/dashboard");

        WebElement add_gadget_button = driver.findElement(By.id("add_gadget_button"));
        assertNotNull(add_gadget_button);
        // Click on TweetPoll tab
        driver.findElement(By.linkText("TweetPolls")).click();
        this.createTweetPoll();
    }

    /**
     * Test Create Tweetpoll.
     */
    @Test
    public void createTweetPoll() {
        WebElement create = driver.findElement(By.id("create_tweetpoll_button"));
        create.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement element31=  driver.findElement(By.id("question"));
        element31.sendKeys("selenium Test");
        element31.sendKeys(Keys.TAB);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.id("answerAddText")).sendKeys("Y");
        driver.findElement(By.id("answerAddButton_label")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.findElement(By.id("answerAddText")).sendKeys("N");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("dijit_form_TextBox_1")).sendKeys("hashtag");
        driver.findElement(By.id("suggestButton_dijit__WidgetsInTemplateMixin_6_label")).click();

         WebElement schedule =
                driver.findElement(By.id("schedule"));
        assertNotNull(schedule);
        schedule.click();

       /* WebElement myDynamicElement = (new WebDriverWait(driver, 20))
                 .until(ExpectedConditions.presenceOfElementLocated(By.id("scheduleTime")));*/

       /* WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("scheduledTime")));
*/
        WebElement schedule1 = driver.findElement(By.id("scheduledTime"));

        assertNotNull(schedule1);
       // new Select(driver.findElement(By.id("scheduledTime"))).selectByIndex(2);

        Select oSelection = new Select(driver.findElement(By.id("scheduledTime")));
        List<WebElement> oSize = oSelection.getOptions();
    }
}
