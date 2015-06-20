package org.encuestame.selenium.pages;

import org.encuestame.selenium.AbstractSelenium;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by dmorales on 6/16/15.
 */
public class Profile extends AbstractPages {

    /**
     * Test Settings Configuration
     * @throws Exception
     */
    @Test
    public void testSettingsAccountConfiguration() throws Exception {
        //accessSettingsConfiguration();
        loginEnme();
        //2- Find element-
        WebElement newuserbutton = driver.findElement(By.className("web-profile-menu"));
        Assert.assertNotNull(newuserbutton);
        newuserbutton.click();
        WebElement settings = driver.findElement(By.linkText("Settings"));
        settings.click();
        //TODO: Define a specific id
        WebElement account = driver.findElement(By.id("profile_settings_button"));
        account.click();
        WebElement email = driver.findElement(By.id("email"));
        WebElement username = driver.findElement(By.id("username"));
        WebElement fullname = driver.findElement(By.id("completeName"));
        //WebElement language = driver.findElement(By.id("email"));
        //Write inputs
        email.clear();
        email.sendKeys("dmorales@gmail.com");
        username.clear();
        username.sendKeys("dmorales");
        fullname.clear();
        fullname.sendKeys("Diana Morales");
        Select droplist = new Select(driver.findElement(By.id("language-profile")));
        droplist.selectByVisibleText("English");
        //TODO: Define specific button id
        //WebElement button = driver.findElement(By.className("update_label"));
        //button.click();
    }

   @Test
    public void testUploadGravatarImage() throws Exception {
        accessSettingsImage();
        // - Select  uploaded picture.
        WebElement gravatar = driver.findElement(By.id("dijit_form_RadioButton_1"));
        Assert.assertNotNull(gravatar);
        gravatar.click();

    }

    @Test
    public void testUploadImage() throws Exception {
        driver.get("http://localhost:8080/encuestame/home");
        accessSettingsImage();

        // - Select  uploaded picture.
        WebElement uploaded = driver.findElement(By.id("dijit_form_RadioButton_1"));
        Assert.assertNotNull(uploaded);
        uploaded.click();
       // WebElement file = driver.findElement(By.id("file"));

        driver.findElement(By.id("file")).sendKeys("/Users/dmorales/tarta.jpg");
        // - Click on upload button btn
        //WebElement uploadbutton = driver.findElement(By.className("btn"));
       // uploadbutton.click();

    }

    @Test
    public void testLogout() throws Exception {
        accessSettingsConfiguration();
        WebElement settings = driver.findElement(By.id("profile-menu-Log out"));
        Assert.assertNotNull(settings);

    }

    /**
     *
     */
    private void accessSettingsImage(){
        accessSettings();
        WebElement image = driver.findElement(By.id("dijit__WidgetsInTemplateMixin_6"));
        image.click();
    }

    /**
     *
     */
    private void accessSettings(){
        accessSettingsConfiguration();
        WebElement settings = driver.findElement(By.linkText("Settings"));
        settings.click();
    }

    /**
     *
     */
    private void accessSettingsConfiguration() {
        //1- Login Enme
        loginEnme();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //2- Find element-
        WebElement newuserbutton = driver.findElement(By.className("web-profile-menu"));
        Assert.assertNotNull(newuserbutton);
        newuserbutton.click();
    }

}