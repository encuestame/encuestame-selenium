/*
 *
 *  * Copyright 2015 encuestame
 *  *
 *  *  Licensed under the Apache License, Version 2.0 (the "License");
 *  *  you may not use this file except in compliance with the License.
 *  *  You may obtain a copy of the License at
 *  *
 *  *       http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  *  Unless required by applicable law or agreed to in writing, software
 *  *  distributed under the License is distributed on an "AS IS" BASIS,
 *  *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *  See the License for the specific language governing permissions and
 *  *  limitations under the License.
 *
 */

package org.encuestame.selenium;

import org.encuestame.selenium.pages.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Encuestame initial page test.
 * @author Picado, Juan juanATencuestame.org
 * @since May 26, 2015
 */
public class EnmeInitialPageTestIT {

    /**
     * WebDriver
     */
    private WebDriver driver;

    /**
     * Url Base
     */
    private String baseUrl;

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception{
        final URL url = new URL("http://127.0.0.1:4444/wd/hub/");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName("chrome");
        desiredCapabilities.setJavascriptEnabled(Boolean.TRUE);
        driver = new RemoteWebDriver(url, desiredCapabilities);
        baseUrl = "http://localhost:8080/encuestame/home";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    /**
     * Initial
     */
    @Test
    public void testInitialEnme(){
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


        /**  -------  Test Login Page  ------ **/
        System.out.println(" ******  GETTING BASE URL ******");
        driver.get(baseUrl);

        LoginPage enmeLoginPage = new LoginPage(driver);
        enmeLoginPage.recoverPassword();
        System.out.println(" ******  Recovering Password  ******");

        System.out.println(" ******  GETTING BASE URL ******");
        driver.get(baseUrl);

        enmeLoginPage.createAccount();
        System.out.println(" ****** Sign-up Create Account ******");

        enmeLoginPage.loginToEncuestame();
        System.out.println(" ****** Login To Encuestame ******");


        /**  -------  Test Team Page  ------ **/
        TeamPage enmeTeamPage = new TeamPage(driver);

        enmeTeamPage.membersAdministrator();
        System.out.println(" ******  Verify Members Administration Menu ******");

        enmeTeamPage.addUserDirectly();
        System.out.println(" ******  Add New User by Send Request  ******");

        enmeTeamPage.inviteUser();
        System.out.println(" ******  Add new User by Invitation email ******");

        enmeTeamPage.membersTablePagination();
        System.out.println(" ******  Verify Members table Pagination ******");

        enmeTeamPage.editUserPermissions();
        System.out.println(" ******  Edit User Permissions ******");

        enmeTeamPage.editUserPictureProfile();
        System.out.println(" ******  Edit User Picture profile ******");

        /**  -------  Test Dashboard Page  ------ **/
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

    }

    /**
     *
     * @param browser
     * @return
     */
   /* private DesiredCapabilities createCapabilities(final String browser) {
       DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
       desiredCapabilities.setBrowserName(browser);
       desiredCapabilities.setJavascriptEnabled(Boolean.TRUE);
       return  desiredCapabilities;
    }*/

}
