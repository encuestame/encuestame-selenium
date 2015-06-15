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

public class HomePageIT extends TestCase   {

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {

        // Choose the browser, version, and platform to test
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setBrowserName("chrome");
        //System.setProperty("webdriver.chrome.driver", "/Users/dmorales/opt/selenium/drivers/chromedriver");
        capabilities.setJavascriptEnabled(true);
        //capabilities.setCapability("version", "17");
       // capabilities.setCapability("platform", Platform.XP);
        this.driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);
       // String sauceKey = System.getProperty("sauceAccessKey");
        //String sauceUser = System.getProperty("sauceUsername");
        // Create the connection to Sauce Labs to run the tests
        //this.driver = new RemoteWebDriver(new URL("http://" + sauceUser + ":" + sauceKey + "@localhost:4445/wd/hub"), capabilities);
    }

    /**
     *
     * @throws Exception
     */
    //@Test
    public void iitestNavHomeMenuLinks() throws Exception {

        String port =System.getProperty("port");
        driver.get("http://localhost:8080/encuestame/home");

        // Test Tweetpoll Menu
        WebElement tpoll_home_link = driver.findElement(By.id("tp-home-nav"));
        assertNotNull(tpoll_home_link);
        tpoll_home_link.click();

        //
        WebElement poll_home_link = driver.findElement(By.id("poll-home-nav"));
        assertNotNull(poll_home_link);
        poll_home_link.click();

        //
        WebElement hot_home_link = driver.findElement(By.id("hot-home-nav"));
        assertNotNull(hot_home_link);
        hot_home_link.click();

        //
        WebElement weekly_home_link = driver.findElement(By.id("week-home-nav"));
        assertNotNull(weekly_home_link);
        weekly_home_link.click();

        //
        WebElement monthly_home_link = driver.findElement(By.id("month-home-nav"));
        assertNotNull(monthly_home_link);
        monthly_home_link.click();

        //
        WebElement allItems_home_link = driver.findElement(By.id("all-home-nav"));
        assertNotNull(allItems_home_link);
        allItems_home_link.click();

    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void iitestEnmeLogo() throws Exception {
        driver.get("http://localhost:8080/encuestame/home");
        WebElement enme_logo = driver.findElement(By.id("enme-logo"));
        assertNotNull(enme_logo);
        enme_logo.click();
    }

    /**
     *
     * @throws Exception
     */
    //@Test
    public void iitestHomeSignIn() throws Exception {
        driver.get("http://localhost:8080/encuestame/home");
        WebElement signin_home = driver.findElement(By.id("signin-home"));
        assertNotNull(signin_home);
        signin_home.click();
        // Input
        WebElement username = driver.findElement(By.id("j_username"));
        assertNotNull(username);
        WebElement password = driver.findElement(By.id("j_password"));
        assertNotNull(password);
        // Write input
        username.sendKeys("dmorales");
        password.sendKeys("NLX900");
        WebElement signInbutton = driver.findElement(By.id("signin-button"));
        assertNotNull(signInbutton);
        signInbutton.click();
    }

    //@Test
    public void iitestHomeItems() throws Exception {
        driver.get("http://encuestame.org/demo/home");
        WebElement item = driver.findElement(By.className("item"));

        WebElement submited = driver.findElement(By.className("submited"));
        assertNotNull(submited);

        WebElement hashtag_button = driver.findElement(By.className("hashtag-button"));
        assertNotNull(hashtag_button);

        WebElement button_vote = driver.findElement(By.className("button_vote"));
        assertNotNull(button_vote);

        WebElement button_item = driver.findElement(By.className("vote-item-button"));
        assertNotNull(button_item);

        WebElement button_hits = driver.findElement(By.className("vote-hits-button"));
        assertNotNull(button_hits);

        WebElement button_comments = driver.findElement(By.className("vote-comments-button"));
        assertNotNull(button_comments);

    }



    //@Test
    public void iitestHomeQuickSearch() throws Exception {
        driver.get("http://encuestame.org/demo/home");
        WebElement quickSearch = driver.findElement(By.id("dijit_form_TextBox_0"));

        quickSearch.sendKeys("goals");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String curre = driver.getCurrentUrl();
        System.out.println("----------------" + curre);
        quickSearch.submit();

        driver.close();


    }




   //@Test
    public void iitestHomePopularHashtags() throws Exception {
        driver.get("http://encuestame.org/demo/home"); // Change to localhost
        WebElement cloudItems = driver.findElement(By.className("cloudItems"));
        List<WebElement> hashtaglist = cloudItems.findElements(By.className("enme-hashtag"));
        if(hashtaglist.size()<=10){
            WebElement hashtag = driver.findElement(By.linkText("sports"));
            assertNotNull(hashtag);
            hashtag.click();
        }
        else{
            WebElement viewAll = driver.findElement(By.className("link")).findElement(By.linkText("View All"));
            assertNotNull(viewAll);
            viewAll.click();
        }

        assertNotNull(cloudItems);
        driver.close();

    }

    //@Test
    public void iitestHomeRatedUsers() throws Exception {
        driver.get("http://encuestame.org/demo/home"); // Change to localhost
        WebElement ratedUsers = driver.findElement(By.className("web-rated-comments-items"));
        List<WebElement> ratedProfile = ratedUsers.findElements(By.className("web-rated-profile-item"));
        System.out.println("------------size--->-" + ratedProfile.size());
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
        driver.close();

    }

    @Test
    public void testHomeRatedComments() throws Exception {
        driver.get("http://encuestame.org/demo/home"); // Change to localhost
        WebElement ratedComments = driver.findElement(By.className("web-rated-comments"));
        assertNotNull(ratedComments); 
        driver.close();

    }

    @Test
    public void testHomeVote() throws Exception {
        driver.get("http://encuestame.org/demo/home"); // Change to localhost
        WebElement ratedComments = driver.findElement(By.className("web-rated-comments"));
        assertNotNull(ratedComments);
        driver.close();

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}
