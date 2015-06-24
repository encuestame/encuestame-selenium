package org.encuestame.selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


/**
 * Homepage Test.
 * @author Morales, Diana Paola paolaATencuestame.org
 * @since May 01, 2015
 */
public class HomePage extends AbstractEnmePages {

    /**
     * Homepage Constructor.
     * @param webDriver
     */
    public HomePage(final WebDriver webDriver){
        this.driver = webDriver;

    }

    /**
     * Navigation Home Links.
     */
    public void navHomeMenuLinks() {
        // Tweetpoll Link Menu
        clickElementById("tp-home-nav");
        // Poll Link Menu
        clickElementById("poll-home-nav");
        // Hot Link Menu
        clickElementById("hot-home-nav");
        //
        clickElementById("week-home-nav");
        // Weekly Link Menu
        clickElementById("month-home-nav");
        // All items Link Menu
        clickElementById("all-home-nav");
    }

    /**
     *  Link Encuestame Logo.
     */
    public void verifyEnmeLogoLink()  {
         clickElementById("enme-logo");
    }
    /**
     * Home item elements.
     */
    public void VerifiyElementsOnHomeItems()  {
        verifyElementByClassNameOnPage("item");
        verifyElementByClassNameOnPage("submited");
        WebElement hashtag = driver.findElement(By.className("tags"));
        Assert.assertNotNull(hashtag);
        List<WebElement> listHashtag = hashtag.findElements(By.className("enme-hashtag"));
        verifyElementByClassNameOnPage("button_vote");
        verifyElementByIdOnPage("vote-hits-button");
        verifyElementByIdOnPage("vote-comments-button");
    }

    /**
     *  Home Quick Search.
     */
    public void homeQuickSearch()  {
        String currentUrl = driver.getCurrentUrl();
        setInputFieldValue("dijit_form_TextBox_0", "goals");
        submitInputField("dijit_form_TextBox_0");
    }

    /**
     *  Home Popular Hashtag - Hashtag cloud.
     */
    public void verifyElementsOnPopularHashtagsBlock()  {
        WebElement cloudItems = driver.findElement(By.className("cloudItems"));
        List<WebElement> hashtaglist = cloudItems.findElements(By.className("enme-hashtag"));
        if (hashtaglist.size()<=10){
            WebElement hashtag = driver.findElement(By.linkText("business"));
            Assert.assertNotNull(hashtag);
            hashtag.click();
        }  else {
            WebElement viewAll = driver.findElement(By.className("link")).findElement(By.linkText("View All"));
            Assert.assertNotNull(viewAll);
            viewAll.click();
        }
        Assert.assertNotNull(cloudItems);
    }

    /**
     *  Popular rated users block.
     */
    public void verifiyElementsOnRatedUsersBlock()  {
        WebElement ratedUsers = driver.findElement(By.className("web-rated-comments-items"));
        List<WebElement> ratedProfile = ratedUsers.findElements(By.className("web-rated-profile-item"));
      /* if((ratedProfile.size()>0) && (ratedProfile.size()<=100)){
         // WebElement profilePicture = driver.findElement(By.className("web-rated-profile-picture picture"));
            WebElement profileitem = driver.findElement(By.linkText("skcetkarthik"));
            System.out.println("--------ddddd-------dddd-");
          //    Assert.assertNotNull(profileitem);
            // profileitem.click();

       }
         else{
            // WebElement viewMore = driver.findElement(By.className("web-list-more web-stream-more")).findElement(By.className("titleNext"));
                System.out.println("--------ddddd--------");
          //Assert.assertNotNull(viewMore);
           // viewAll.click();
         }
*/
         Assert.assertNotNull(ratedUsers);
    }

    /**
     * Rated-Comments Block.
     */
    public void testHomeRatedComments()  {
        WebElement ratedComments = driver.findElement(By.id("dijit__WidgetsInTemplateMixin_82")); //TODO: Define an ID
        Assert.assertNotNull(ratedComments);
        List<WebElement> commentsList = ratedComments.findElements(By.className("web-rated-comment-item"));

    }

    /**
     * Comment detail.
     */
    public void testHomeRatedCommentDetail()  {
        WebElement ratedComments = driver.findElement(By.id("dijit__WidgetsInTemplateMixin_82")); //TODO: Define an ID
        Assert.assertNotNull(ratedComments);
        //
        WebElement commentsList = ratedComments.findElement(By.id("dijit__WidgetsInTemplateMixin_103"));//TODO: Define an ID
        Assert.assertNotNull(commentsList);
        //
        WebElement picture = commentsList.findElement(By.className("web-rated-comment-picture"));
        Assert.assertNotNull(picture);

        //
        WebElement detail = commentsList.findElement(By.className("web-rated-comment-item-detail"));
        Assert.assertNotNull(detail);
        //
        WebElement sub = commentsList.findElement(By.className("web-rated-comment-item-sub"));
        Assert.assertNotNull(sub);
    }
}