package org.encuestame.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Login Page Test.
 * @author Morales, Diana Paola paolaATencuestame.org
 * @since June 19, 2015
 */
public class LoginPage extends AbstractEnmePages {

    /**
     * Login Constructor
     * @param webDriver
     */
    public LoginPage(final WebDriver webDriver) {
         this.driver= webDriver;
    }

    /**
     * Login to Encuestame.
     */
    public void loginToEncuestame() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("signin-home")));
        clickElementById("signin-home");
        // Input
        setInputFieldValue("j_username", "dianmorales");
        setInputFieldValue("j_password", "12345");
        clickElementById("signin-button");
    }

    /**
     * Recover password.
     */
    public void recoverPassword() {
        waitUntilToElementBeClickable("signin-home");
        clickElementById("signin-home");
        clickElementById("signin-forgot-pass");
        setInputFieldValue("email", "dmorales@encuestame.org");
    }

    /**
     * Sign up - Create Account
     */
    public void createAccount(){
        waitUntilToElementBeClickable("signin-home");
        clickElementById("signin-home");
        waitUntilToElementBeClickable("user-signup");
        clickElementById("user-signup");
        setInputFieldValue("input_real_name_signup", "Diana Morales"); // Input text-Real name
        setInputFieldValue("input_password_signup", "123456");// Input text-password
        setInputFieldValue("input_email_user_signup", "dmorales@encuestame.org"); // Input text- email
        setInputFieldValue("input_username_signup", "dmorales1236");// Input text- username*/
        submitInputField("submit-signup-data");
    }

    /**
     * Logout of Encuestame
     */
    public void logoutOfEncuestame() {
        clickElementByClassName("web-profile-menu");
        clickElementById("profile-menu-2");
    }
}