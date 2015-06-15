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
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * Selenium Test Cases.
 * @author Morales, Diana Paola paolaATencuestame.org
 * @since May 01, 2015
 */

public class HomePageIT extends AbstractSelenium   {

    /**
     * Test Navigation Home Links
     * @throws Exception
     */
    @Test
    public void testNavHomeMenuLinks() throws Exception {

        // Tweetpoll Link Menu
        WebElement tpoll_home_link = driver.findElement(By.id("tp-home-nav"));
        assertNotNull(tpoll_home_link);
        tpoll_home_link.click();

        // Poll Link Menu
        WebElement poll_home_link = driver.findElement(By.id("poll-home-nav"));
        assertNotNull(poll_home_link);
        poll_home_link.click();

        // Hot Link Menu
        WebElement hot_home_link = driver.findElement(By.id("hot-home-nav"));
        assertNotNull(hot_home_link);
        hot_home_link.click();

        //
        WebElement weekly_home_link = driver.findElement(By.id("week-home-nav"));
        assertNotNull(weekly_home_link);
        weekly_home_link.click();

        // Weekly Link Menu
        WebElement monthly_home_link = driver.findElement(By.id("month-home-nav"));
        assertNotNull(monthly_home_link);
        monthly_home_link.click();

        // All items Link Menu
        WebElement allItems_home_link = driver.findElement(By.id("all-home-nav"));
        assertNotNull(allItems_home_link);
        allItems_home_link.click();
    }

    /**
     * Test Link Encuestame Logo
     * @throws Exception
     */
    @Test
    public void testEnmeLogo() throws Exception {
        WebElement enme_logo = driver.findElement(By.id("enme-logo"));
        assertNotNull(enme_logo);
        enme_logo.click();
    }

    /**
     * Test User SignIn
     * @throws Exception
     */
    @Test
    public void testHomeSignIn() throws Exception {
        loginEnme();
    }

    /**
     * Test Home item elements
     * @throws Exception
     */
    @Test
    public void testHomeItems() throws Exception {
        WebElement item = driver.findElement(By.className("item"));

        WebElement submited = driver.findElement(By.className("submited"));
        assertNotNull(submited);

        //WebElement hashtag_button = driver.findElement(By.className("hashtag-button"));
        //assertNotNull(hashtag_button);

        WebElement button_vote = driver.findElement(By.className("button_vote"));
        assertNotNull(button_vote);

        //WebElement button_item = driver.findElement(By.className("vote-item-button"));
        //assertNotNull(button_item);

        WebElement button_hits = driver.findElement(By.id("vote-hits-button"));
        assertNotNull(button_hits);

        WebElement button_comments = driver.findElement(By.id("vote-comments-button"));
        assertNotNull(button_comments);

    }


    /**
     *  Test Home Quick Search
     * @throws Exception
     */
    @Test
    public void testHomeQuickSearch() throws Exception {
        WebElement quickSearch = driver.findElement(By.id("dijit_form_TextBox_0"));
        quickSearch.sendKeys("goals");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String currentUrl = driver.getCurrentUrl();
        quickSearch.submit();
    }

    @Test
    public void testHomePopularHashtags() throws Exception {
        WebElement cloudItems = driver.findElement(By.className("cloudItems"));
        List<WebElement> hashtaglist = cloudItems.findElements(By.className("enme-hashtag"));
        if(hashtaglist.size()<=10){
            WebElement hashtag = driver.findElement(By.linkText("business"));
            assertNotNull(hashtag);
            hashtag.click();
        }
        else{
            WebElement viewAll = driver.findElement(By.className("link")).findElement(By.linkText("View All"));
            assertNotNull(viewAll);
            viewAll.click();
        }

        assertNotNull(cloudItems);
    }

    @Test
    public void testHomeRatedUsers() throws Exception {
        WebElement ratedUsers = driver.findElement(By.className("web-rated-comments-items"));
        List<WebElement> ratedProfile = ratedUsers.findElements(By.className("web-rated-profile-item"));
      /* if((ratedProfile.size()>0) && (ratedProfile.size()<=100)){
         // WebElement profilePicture = driver.findElement(By.className("web-rated-profile-picture picture"));
            WebElement profileitem = driver.findElement(By.linkText("skcetkarthik"));
            System.out.println("--------ddddd-------dddd-");
          //    assertNotNull(profileitem);
            // profileitem.click();

       }
         else{
            // WebElement viewMore = driver.findElement(By.className("web-list-more web-stream-more")).findElement(By.className("titleNext"));
                System.out.println("--------ddddd--------");
          //assertNotNull(viewMore);
           // viewAll.click();
         }
*/
        assertNotNull(ratedUsers);
    }

   @Test
    public void testHomeRatedComments() throws Exception {
        WebElement ratedComments = driver.findElement(By.className("web-rated-comments"));
        assertNotNull(ratedComments);
    }

    @Test
    public void testHomeVote() throws Exception {
        WebElement ratedComments = driver.findElement(By.className("web-rated-comments"));
        assertNotNull(ratedComments);
    }
}