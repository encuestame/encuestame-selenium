package org.encuestame.selenium.pages;

import org.encuestame.selenium.AbstractSelenium;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by dmorales on 6/19/15.
 */
public class LoginPage extends AbstractPages {


    /**
     *  Test Recover password.
     * @throws Exception
     */
    @Test
    public void testRecoverPassword() throws Exception {
        driver.get("http://localhost:8080/encuestame/user/signin");
        WebElement recoverPass = driver.findElement(By.id("signin-forgot-pass"));
        Assert.assertNotNull(recoverPass);
        recoverPass.click();
        WebElement email = driver.findElement(By.id("email"));
        Assert.assertNotNull(email);
    }

    /**
     * Test Sign up - Create Account
     * @throws Exception
     */
    @Test
    public void testCreateAccount() throws Exception {
        driver.get("http://localhost:8080/encuestame/user/signin");
        WebElement needAccount = driver.findElement(By.id("user-signup"));
        Assert.assertNotNull(needAccount);
        needAccount.click();
        WebElement realname = driver.findElement(By.id("input_real_namedijit__WidgetsInTemplateMixin_0"));
        Assert.assertNotNull(realname);

        WebElement password = driver.findElement(By.id("input_passworddijit__WidgetsInTemplateMixin_0"));
        Assert.assertNotNull(password);

        WebElement email = driver.findElement(By.id("input_email_userdijit__WidgetsInTemplateMixin_0"));
        Assert.assertNotNull(email);

        WebElement username = driver.findElement(By.id("input_username_dijit__WidgetsInTemplateMixin_0"));
        Assert.assertNotNull(username);
        // Send Keys
        realname.sendKeys("Diana Morales");
        password.sendKeys("nicanica");
        email.sendKeys("dianprincess2003@yahoo.com");
        username.sendKeys("dmorales");
        WebElement signup = driver.findElement(By.id("submit-signup-data"));
        signup.submit();
    }
}
