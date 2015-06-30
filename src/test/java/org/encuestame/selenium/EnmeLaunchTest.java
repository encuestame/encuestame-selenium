package org.encuestame.selenium;

import org.encuestame.selenium.pages.*;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by dmorales on 29/06/15.
 */
public class EnmeLaunchTest {

    public void launchEnme(WebDriver driver, String baseUrl){

    System.out.println(" ******  GETTING BASE URL ******");
    driver.get(baseUrl);
    /**  -------  Test Home Page  ------ **/
    HomePage enmeHomePage= new HomePage(driver);

    // Test Home Menu navigations Links
    enmeHomePage.navHomeMenuLinks();
    System.out.println(" ******  Navigation Home Links ******");

    // Test Home page Encuestame Logo link
    enmeHomePage.verifyEnmeLogoLink();
    System.out.println(" ******  Enme Logo Link ******");

    // Test each Elements on Items
    enmeHomePage.VerifiyElementsOnHomeItems();
    System.out.println(" ******  Verify Elements on Home Items ******");

    // Test Home page quick Search
    enmeHomePage.homeQuickSearch();
    System.out.println(" ******  Home Quick Search ******");

    // Test Elements on Popular hashtags Block.
    enmeHomePage.verifyElementsOnPopularHashtagsBlock();
    System.out.println(" ******  Verify Elements on Popular Hashtag Block ******");

    // Test Elements on Rated users Block.
    enmeHomePage.verifiyElementsOnRatedUsersBlock();
    System.out.println(" ******  Verify Elements on Rated Users Block ******");
/*

    ///  -------  Test Login Page  ------ ///
    System.out.println(" ******  GETTING BASE URL ******");
    driver.get(baseUrl);

    LoginPage enmeLoginPage = new LoginPage(driver);
    enmeLoginPage.recoverPassword();
    System.out.println(" ******  Recovering Password  ******");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    System.out.println(" ******  GETTING BASE URL ******");
    driver.get(baseUrl);

    enmeLoginPage.createAccount();
    System.out.println(" ****** Sign-up Create Account ******");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get(baseUrl);
    enmeLoginPage.loginToEncuestame();
    System.out.println(" ****** Login To Encuestame ******");


    ///  -------  Test Team Page  ------ ///
    TeamPage enmeTeamPage = new TeamPage(driver);

    enmeTeamPage.membersAdministrator();

    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    enmeTeamPage.addUserDirectly();
    System.out.println(" ******  Add New User by Send Request  ******");

    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    enmeTeamPage.inviteUser();
    System.out.println(" ******  Add new User by Invitation email ******");

    enmeTeamPage.membersTablePagination();
    System.out.println(" ******  Verify Members table Pagination ******");

    enmeTeamPage.editUserPermissions();
    System.out.println(" ******  Edit User Permissions ******");

    enmeTeamPage.editUserPictureProfile();
    System.out.println(" ******  Edit User Picture profile ******");

    ///  -------  Test Dashboard Page  ------ ///
    DashboardPage boardPage = new DashboardPage(driver);

    boardPage.addGadgetToDashboard();
    System.out.println(" ******  Add Gadget to Dashboard ******");

    boardPage.changeToLayoutA();
    System.out.println(" ******  Change Dashboard Layout to Layout A ******");

    boardPage.changeToLayoutAA();
    System.out.println(" ******  Change Dashboard Layout to Layout AA ******");

    boardPage.changeToLayoutAB();
    System.out.println(" ******  Change Dashboard Layout to Layout AB ******");

    boardPage.changeToLayoutBA();
    System.out.println(" ******  Change Dashboard Layout to Layout BA ******");

    boardPage.createDashboard();
    System.out.println(" ******  Create new Dashboard  ******");

    boardPage.notification();
    System.out.println(" ******  Edit User Picture profile ******");

    ///  -------  Test Profile Page  ------ ///
    Profile profilePage = new Profile(driver);
    profilePage.settingsAccountConfiguration();
             /*s  System.out.println(" ******  Profile Settings Configuration ******");

        profilePage.uploadGravatarImage();
        System.out.println(" ******  Upload profile gravatar Image ******");

        profilePage.uploadImage();
        System.out.println(" ******  Upload Profile image ******");*/
    }
}
