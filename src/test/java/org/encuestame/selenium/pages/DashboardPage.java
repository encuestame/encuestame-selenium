package org.encuestame.selenium.pages;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;

/**
 * Dashboard Page Test.
 * @author Morales, Diana Paola paolaATencuestame.org
 * @since June 16, 2015
 */
public class DashboardPage extends AbstractEnmePages {

    /**
     * Dashboard Constructor.
     * @param webDriver
     */
    public DashboardPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    /**
     * Add new Gadget.
     */
    public void addGadgetToDashboard() {
        driver.get("http://localhost:8080/encuestame/user/dashboard");
        waitUntilToElementBeClickable("add_gadget_button");
        //clickElementById("add_gadget_button");
       // verifyElementByIdOnPage("gadget_item_stream");
        //TODO: row id for each gadget is repeated
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //TODO: <div> with new-gadget-win id is repeated
       // WebElement gadgetwin = driver.findElement(By.id("new-gadget-win"));

    }

    /**
     * Change to Dashboard Layout-A
     */
    public void changeToLayoutA(){
        changeLayout();
        verifyElementByIdOnPage("layout-a");
        clickElementById("dijit_form_Button_1_label");
    }

    /**
     * Change to Dashboard Layout-BA
     */
    public void changeToLayoutBA(){
        changeLayout();
        verifyElementByIdOnPage("layout-ba");
        clickElementById("dijit_form_Button_1_label");
    }

    /**
     * Change to Dashboard Layout-AB
     */
    public void changeToLayoutAA(){
        changeLayout();
        verifyElementByIdOnPage("layout-aa");
        clickElementById("dijit_form_Button_1_label");
    }

    /**
     * Change to Dashboard Layout-AB
     */
    public void changeToLayoutAB(){
        changeLayout();
        verifyElementByIdOnPage("layout-ab");
    }

    /**
     * Create Dashboard.
     */
    public void createDashboard(){
        verifyElementByLinkOnPage("Dashboard");
        verifyElementByIdOnPage("new_dashboard");
        setInputFieldValue("panel_name", "My Tweetpoll board");
        setInputFieldValue("panel_descr", "Board with all Tweetpoll");
        //TODO: Define Button ID
    }

    /**
     * Select Dashboard.
     */
    public void selectDashboard() {
        clickElementById("widget_change_dashboard");
    }

    /**
     * View Notifications.
     */
    public void notification() {
        clickElementByClassName("counter");
        clickByLinkText("View All");
        //WebElement allNotification = driver.findElement(By.className("final")).findElement(By.linkText("View All"));
        //Assert.assertNotNull(allNotification);
        //allNotification.click();
    }

    /**
     * Remove Notification.
     */
    public void removeNotification() {
        driver.get("http://localhost:8080/encuestame/home");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        verifyElementByClassNameOnPage("counter");
    }

    /**
     * Helper to Change Layout.
     */
    private void changeLayout(){
        waitUntilToElementBeClickable("change_layout_button");
        clickElementById("change_layout_button");
        verifyElementByClassNameOnPage("web-layout-select-body");
    }
}