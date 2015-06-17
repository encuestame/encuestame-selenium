package org.encuestame.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by dmorales on 6/16/15.
 */
public class ProfileIT extends AbstractSelenium {

    /**
     * Test Members-Users Administrator
     * @throws Exception
     */
    @Test
    public void testMembersAdministrator() throws Exception {
        driver.get("http://localhost:8080/encuestame/home");
        //1-Login Encuestame
        loginEnme();
         WebElement team = driver.findElement(By.id("members-menu"));
        assertNotNull(team);
        team.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //2- Find element(user link)
        WebElement user = driver.findElement(By.className("link")); //TODO: Change classname to ID
        assertNotNull(user);
        user.click();

        WebElement editPermissions = driver.findElement(By.id("userEdit"));
        List<WebElement> userPermissions = driver.findElements(By.id("user-permissions")); //TODO: Add classname value to div with user permissions
        System.out.println("User Permissions-->" + userPermissions.size());
        //TODO: Select a permission
        /*  //3- Find element (window-popup)permissions-list
        WebElement newUser = driver.findElement(By.id("newUser"));
        assertNotNull(newUser);
        //4- Find element (Gravatar)
        WebElement box = driver.findElement(By.id("ym-gbox"));
        */
    }



    /**
     * Test New Request Member-Add User directly.
     * @throws Exception
     */

   @Test
    public void testAddUserDirectly() throws Exception {
        //1-
        newRequestMember();
        //2- Window new Request member.- Add User directly

        WebElement username = driver.findElement(By.id("input_newUsername"));
        assertNotNull(username);

        WebElement useremail = driver.findElement(By.id("input_newEmailUser"));
        assertNotNull(useremail);
        //3-Write inputs
        username.sendKeys("dmorales");
        useremail.sendKeys("dmorales@gmail.com");

        //4- Find Element to Send Member request
        WebElement signInbutton = driver.findElement(By.id("send-member-request"));
        assertNotNull(signInbutton);
        signInbutton.click();
        //TODO: Complete the following proccess
        //5- Retrieve Response
        //6-Close window

    }

     /*
      * New Request Member-Invite User.
      */
    @Test
    public void testInviteUser(){
        //1-New Request Member access.
        newRequestMember();
        //2- Window new Request member.- Invite User
        WebElement inviteUser = driver.findElement(By.id("dijit_layout_ContentPane_1_button_title"));
        assertNotNull(inviteUser);
        inviteUser.click();
        //3- Find input elements.
        WebElement invitationEmail = driver.findElement(By.id("input_emailInvitationText"));
        assertNotNull(invitationEmail);
        //4- Write email - input
        invitationEmail.sendKeys("dmorales@gmail.com");

        WebElement sendInvitation = driver.findElement(By.id("send-invitation-request"));
        assertNotNull(sendInvitation);
        sendInvitation.click();

        //5-
    }

    /**
     * Test Settings Configuration
     * @throws Exception
     */
    @Test
    public void testSettingsAccountConfiguration() throws Exception {
        //accessSettingsConfiguration();

        loginEnme();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //2- Find element-
        WebElement newuserbutton = driver.findElement(By.className("web-profile-menu"));
        assertNotNull(newuserbutton);
        newuserbutton.click();
        WebElement settings = driver.findElement(By.linkText("Settings"));
        settings.click();
        //TODO: Define a specific id
        WebElement account = driver.findElement(By.id("dijit__WidgetsInTemplateMixin_5"));
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
        assertNotNull(gravatar);
        gravatar.click();

    }

    @Test
    public void testUploadImage() throws Exception {
        driver.get("http://localhost:8080/encuestame/home");
        accessSettingsImage();

        // - Select  uploaded picture.
        WebElement uploaded = driver.findElement(By.id("dijit_form_RadioButton_1"));
        assertNotNull(uploaded);
        uploaded.click();
       // WebElement file = driver.findElement(By.id("file"));

        driver.findElement(By.id("file")).sendKeys("/Users/dmorales/tarta.jpg");
        // - Click on upload button btn
        //WebElement uploadbutton = driver.findElement(By.className("btn"));
       // uploadbutton.click();

    }

    /**
     *  Test Recover password.
     * @throws Exception
     */
    @Test
    public void testRecoverPassword() throws Exception {
        driver.get("http://localhost:8080/encuestame/user/signin");
        WebElement recoverPass = driver.findElement(By.id("signin-forgot-pass"));
        assertNotNull(recoverPass);
        recoverPass.click();
        WebElement email = driver.findElement(By.id("email"));
        assertNotNull(email);
    }

    /**
     * Test Sign up - Create Account
     * @throws Exception
     */
    @Test
    public void testCreateAccount() throws Exception {
        driver.get("http://localhost:8080/encuestame/user/signin");
        WebElement needAccount = driver.findElement(By.id("user-signup"));
        assertNotNull(needAccount);
        needAccount.click();
        WebElement realname = driver.findElement(By.id("input_real_namedijit__WidgetsInTemplateMixin_0"));
        assertNotNull(realname);

        WebElement password = driver.findElement(By.id("input_passworddijit__WidgetsInTemplateMixin_0"));
        assertNotNull(password);

        WebElement email = driver.findElement(By.id("input_email_userdijit__WidgetsInTemplateMixin_0"));
        assertNotNull(email);

        WebElement username = driver.findElement(By.id("input_username_dijit__WidgetsInTemplateMixin_0"));
        assertNotNull(username);
        // Send Keys
        realname.sendKeys("Diana Morales");
        password.sendKeys("nicanica");
        email.sendKeys("dianprincess2003@yahoo.com");
        username.sendKeys("dmorales");
        WebElement signup = driver.findElement(By.id("submit-signup-data"));
        signup.submit();
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
    private void accessSettingsSocialAccounts(){

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
        assertNotNull(newuserbutton);
        newuserbutton.click();
    }

    /**
     * Access to team configuration menu.
     */
    private void accessTeamConfiguration() {
        //1- Login Encuestame
        loginEnme();
        //2- Find Element (Menu Option: Team)
        WebElement team = driver.findElement(By.id("members-menu"));
        assertNotNull(team);
        //3- Select element Team
        team.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    /**
     * New Request Member access menu.
     */
    private void newRequestMember() {
        // Access Team Configuration
        accessTeamConfiguration();
        //2- Find Element Button New User
        WebElement newuserbutton = driver.findElement(By.id("new_user_button"));
        assertNotNull(newuserbutton);
        newuserbutton.click();
    }
}