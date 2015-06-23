package org.encuestame.selenium.pages;

import org.openqa.selenium.WebDriver;

/**
 * Team Page.
 * @author Morales, Diana Paola paolaATencuestame.org
 * @since June 19, 2015
 */
public class TeamPage extends AbstractEnmePages {

    public TeamPage(WebDriver webDriver) {
        this.driver= webDriver;
    }

    /**
     * members Administrator
     */
    public void membersAdministrator() {
        //1-Login Encuestame
        waitUntilToElementBeClickable("members-menu");
        clickElementById("members-menu");

        //2- Find element(user link)
      /*  clickByLinkText("link"); //TODO: Change classname to ID

        verifyElementByIdOnPage("userEdit");

        List<WebElement> userPermissions = driver.findElements(By.id("user-permissions")); //TODO: Add classname value to div with user permissions
        System.out.println("User Permissions-->" + userPermissions.size());*/
        //TODO: Select a permission
        /*  //3- Find element (window-popup)permissions-list
        WebElement newUser = driver.findElement(By.id("newUser"));
        Assert.assertNotNull(newUser);
        //4- Find element (Gravatar)
        WebElement box = driver.findElement(By.id("ym-gbox"));
        */
    }


    /**
     * Add new Request Member directly.
     */
    public void addUserDirectly() {
        waitUntilToElementBeClickable("new_user_button");
        clickElementById("new_user_button");

        setInputFieldValue("input_newUsername", "dmorales13456");
        setInputFieldValue("input_newEmailUser","dmorales@encuestame.org");
        //TODO: Complete the following proccess
        // clickElementById("send-member-request");
        //5- Retrieve Response
        clickElementById("close-request-window");

    }

    /*
     * New Request Member by email Invitation.
     */
    public void inviteUser(){
        accessTeamConfiguration();
        clickElementById("new_user_button");
        waitUntilToElementBeClickable("userInvitation_button");
        clickElementById("userInvitation_button");
        waitUntilToElementBeClickable("input_emailInvitationText");
        verifyElementByIdOnPage("input_emailInvitationText");
        setInputFieldValue("input_emailInvitationText", "dmorales@encuestame.org");
        //clickElementById("send-invitation-request");
        clickElementById("close-request-window");
    }

    /**
     * Members table pagination.
     */
    public void membersTablePagination(){
        accessTeamConfiguration();
        verifyElementByClassNameOnPage("controlsTable");
        clickElementById("first-pag-members");
        clickElementById("previous-pag-members");
        clickElementById("next-pag-members");
        clickElementById("last-pag-members");
    }

    /**
     * Edit User Permissions.
     */
    public void editUserPermissions(){
        accessUserEdit();
        verifyElementByIdOnPage("encuestame_admin");
        //clickElementById("encuestame_owner");
        verifyElementByIdOnPage("encuestame_editor");
        //TODO: Define Button Id to close window.
    }

    /**
     * Profile pictore on UserEdit
     */
    public void editUserPictureProfile(){
        accessTeamConfiguration();
        clickElementByClassName("link");
        clickElementById("picture-profile");
        //TODO: Define Button Id to close window.
    }

    /**
     * Access to edit User window.
     */
    private void accessUserEdit(){
        accessTeamConfiguration();
        verifyElementByClassNameOnPage("link");
        clickElementByClassName("link");
        verifyElementByIdOnPage("user-permissions");
    }

    /**
     * New Request Member access menu.
     */
    private void newRequestMember() {
        // Access Team Configuration
        waitUntilToElementBeClickable("members-menu");
        clickElementById("members-menu");
        //2- Find Element Button New User
        waitUntilToElementBeClickable("new_user_button");
        clickElementById("new_user_button");
    }

    /**
     * Access to team configuration menu.
     */
    private void accessTeamConfiguration() {
        driver.get("http://localhost:8080/encuestame/admon/members");
    }
}
