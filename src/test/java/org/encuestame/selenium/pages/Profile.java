package org.encuestame.selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

/**
 * Profile Page.
 * @author Morales, Diana Paola paolaATencuestame.org
 * @since June 16, 2015
 */
public class Profile extends AbstractEnmePages {

    /**
     * Profile Constructor
     * @param webDriver
     */
    public Profile(WebDriver webDriver) {
        this.driver=webDriver;
    }

    /**
     * Settings Account Configuration.
     */
    public void settingsAccountConfiguration()  {
        driver.get("http://localhost:8080/encuestame/user/dashboard");
        //2- Find element-
        clickElementByClassName("web-profile-menu");
        clickByLinkText("Settings");
        //TODO: Define a specific id
        clickElementById("profile_settings_button");
        setInputFieldValue("email", "dmorales@gmail.com");
        setInputFieldValue("username", "dmorales");
        setInputFieldValue("completeName", "Diana Morales");

        Select droplist = new Select(driver.findElement(By.id("language-profile")));
        droplist.selectByVisibleText("English");
        //TODO: Define specific button id
        //WebElement button = driver.findElement(By.className("update_label"));
        //button.click();
    }

    /**
     *  Upload a Gravatar image.
     */
    public void uploadGravatarImage() {
        accessSettingsImage();
        // - Select  uploaded picture.
        clickElementById("dijit_form_RadioButton_1");
    }

    /**
     * Upload Profile image.
     */
    public void testUploadImage(){
        accessSettingsImage();
        // - Select  uploaded picture.
        clickElementById("dijit_form_RadioButton_1");
       // WebElement file = driver.findElement(By.id("file"));
        setInputFieldValue("file", "/Users/dmorales/tarta.jpg");
        // - Click on upload button btn
        //WebElement uploadbutton = driver.findElement(By.className("btn"));
       // uploadbutton.click();

    }

    /**
     * Access to Settings image option.
     */
    private void accessSettingsImage(){
        accessSettings();
        WebElement image = driver.findElement(By.id("dijit__WidgetsInTemplateMixin_6"));
        image.click();
    }

    /**
     * Access to Settings option.
     */
    private void accessSettings(){
        accessSettingsConfiguration();
        WebElement settings = driver.findElement(By.linkText("Settings"));
        settings.click();
    }

    /**
     * Access to Account Settings configuration option.
     */
    private void accessSettingsConfiguration() {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //2- Find element-
        WebElement newuserbutton = driver.findElement(By.className("web-profile-menu"));
        Assert.assertNotNull(newuserbutton);
        newuserbutton.click();
    }
}