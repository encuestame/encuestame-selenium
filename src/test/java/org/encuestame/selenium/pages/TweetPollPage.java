package org.encuestame.selenium.pages;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Tweetpoll Page.
 * @author Morales, Diana Paola paolaATencuestame.org
 * @since May 26, 2015
 */
public class TweetPollPage extends AbstractEnmePages {

    /**
     * Home Popular Hashtags
     */
    public void testHomePopularHashtags(){
        clickElementById("signin-home");
        // Input
        setInputFieldValue("j_username", "dmorales");
        setInputFieldValue("j_password", "XSLFLD");

        clickElementById("signin-button");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/encuestame/user/dashboard");
        verifyElementByIdOnPage("add_gadget_button");
        // Click on TweetPoll tab
        clickByLinkText("TweetPolls");
        this.createTweetPoll();
    }

    /**
     * Create Tweetpoll.
     */
    public void createTweetPoll() {
        clickElementById("create_tweetpoll_button");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement element31=  driver.findElement(By.id("question"));
        element31.sendKeys("selenium Test");
        element31.sendKeys(Keys.TAB);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        setInputFieldValue("answerAddText", "Y");
        clickElementById("answerAddButton_label");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.findElement(By.id("answerAddText")).sendKeys("N");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        setInputFieldValue("dijit_form_TextBox_1","hashtag");
        clickElementById("suggestButton_dijit__WidgetsInTemplateMixin_6_label");

        clickElementById("schedule");

       /* WebElement myDynamicElement = (new WebDriverWait(driver, 20))
                 .until(ExpectedConditions.presenceOfElementLocated(By.id("scheduleTime")));*/

       /* WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("scheduledTime")));
*/
        verifyElementByIdOnPage("scheduledTime");
       // new Select(driver.findElement(By.id("scheduledTime"))).selectByIndex(2);

        Select oSelection = new Select(driver.findElement(By.id("scheduledTime")));
        List<WebElement> oSize = oSelection.getOptions();
    }
}
