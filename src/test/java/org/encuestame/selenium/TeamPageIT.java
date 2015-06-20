package org.encuestame.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by dmorales on 6/19/15.
 */
public class TeamPageIT extends  AbstractSelenium {

    /**
     * Test Members-Users Administrator
     * @throws Exception
     */
    @Test
    public void iitestMembersAdministrator() throws Exception {
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
    public void iitestAddUserDirectly() throws Exception {
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
    public void iitestInviteUser(){
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
     * Test Members table pagination.
     */
    @Test
    public void iitestPagination(){
        accessTeamConfiguration();
        WebElement controlsPag = driver.findElement(By.className("controlsTable"));
        assertNotNull(controlsPag);

        WebElement firstPag = controlsPag.findElement(By.id("first-pag-members"));
        assertNotNull(firstPag);
        firstPag.click();

        WebElement previousPag = controlsPag.findElement(By.id("previous-pag-members"));
        assertNotNull(previousPag);
        previousPag.click();

        WebElement nextPag = controlsPag.findElement(By.id("next-pag-members"));
        assertNotNull(nextPag);
        nextPag.click();

        WebElement lastPag = controlsPag.findElement(By.id("last-pag-members"));
        assertNotNull(lastPag);
        lastPag.click();
    }

    /**
     *Test Edit User Permissions.
     */
    @Test
    public void iitestEditUserPermissions(){
        accessUserEdit();

        WebElement encuestame_admin = driver.findElement(By.id("encuestame_admin"));
        assertNotNull(encuestame_admin);

        WebElement encuestame_owner = driver.findElement(By.id("encuestame_owner"));
        assertNotNull(encuestame_owner);
        encuestame_owner.click();

        WebElement encuestame_editor = driver.findElement(By.id("encuestame_editor"));
        assertNotNull(encuestame_editor);
        //TODO: Define Button Id to close window.
    }//picture-profile

    /**
     * Test Profile pictore on UserEdit
     */
    @Test
    public void testEditUser(){
        accessUserEdit();
        WebElement profilePicture = driver.findElement(By.id("picture-profile"));
        assertNotNull(profilePicture);
        profilePicture.click();
        //TODO: Define Button Id to close window.
    }

    /**
     * Access to edit User window.
     */
    private void accessUserEdit(){
        accessTeamConfiguration();
        WebElement username = driver.findElement(By.className("link"));
        assertNotNull(username);
        username.click();
        WebElement permissions = driver.findElement(By.id("user-permissions"));
        assertNotNull(permissions);

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
}
