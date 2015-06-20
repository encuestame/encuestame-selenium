package org.encuestame.selenium;

import junit.framework.TestCase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

/**
 * Created by dmorales on 6/16/15.
 */
public class DashboardPageIT extends AbstractSelenium{

    /**
     * Test Add new Gadget.
     * @throws Exception
     */
    @Test
    public void iitestAddGadget() throws Exception {
        loginEnme();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //TODO: Define Id
        WebElement dashboard = driver.findElement(By.linkText("Dashboard"));
        assertNotNull(dashboard);
        dashboard.click();

        WebElement gadgetbutton = driver.findElement(By.id("add_gadget_button"));
        assertNotNull(gadgetbutton);
        gadgetbutton.click();
        WebElement streamgd = driver.findElement(By.id("gadget_item_stream"));
        assertNotNull(streamgd);
        //TODO: row id for each gadget is repeated
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //TODO: <div> with new-gadget-win id is repeated
       // WebElement gadgetwin = driver.findElement(By.id("new-gadget-win"));

    }

    /**
     * Test Change to Dashboard Layout-A
     */
    @Test
    public void iitestChangeLayoutA(){
        changeLayout();
        WebElement layouta = driver.findElement(By.id("layout-a"));
        assertNotNull(layouta);
       //
    }

    /**
     * Test Change to Dashboard Layout-BA
     */
    @Test
    public void iitestChangeLayoutBA(){
        changeLayout();
        WebElement layoutba = driver.findElement(By.id("layout-ba"));
        assertNotNull(layoutba);
    }

    /**
     * Test Change to Dashboard Layout-AB
     */
    @Test
    public void iitestChangeLayoutAA(){
        changeLayout();
        WebElement layoutaa = driver.findElement(By.id("layout-aa"));
        assertNotNull(layoutaa);
    }

    /**
     * Test Change to Dashboard Layout-AB
     */
    @Test
    public void iitestChangeLayoutAB(){
        changeLayout();
        WebElement layoutab = driver.findElement(By.id("layout-ab"));
        assertNotNull(layoutab);
    }

    /**
     * Test create Dashboard.
     */
    @Test
    public void iitestCreateDashboard(){
        loginEnme();
        WebElement dashboard = driver.findElement(By.linkText("Dashboard"));

        WebElement droplist = driver.findElement(By.id("new_dashboard"));
        assertNotNull(droplist);
        droplist.click();
        WebElement panelName= driver.findElement(By.id("panel_name"));
        assertNotNull(panelName);
        WebElement panelDesc= driver.findElement(By.id("panel_descr"));
        assertNotNull(panelDesc);
        // Sendkeys
        panelName.sendKeys("TweetpollDash");
        panelDesc.sendKeys("Tweetpoll Dashboard");
        //TODO: Define Button ID
        WebElement newButton= driver.findElement(By.id(""));
        assertNotNull(newButton);
    }

    /**
     * Test Select Dashboard.
     */
    @Test
    public void iitestSelectDashboard() {
        loginEnme();
        WebElement selector = driver.findElement(By.id("widget_change_dashboard"));
        assertNotNull(selector);
        selector.click();
    }

    /**
     * Test View Notifications.
     * @throws Exception
     */
    @Test
    public void iitestNotification() throws Exception {
        loginEnme();
        WebElement notification = driver.findElement(By.className("counter"));
        assertNotNull(notification);
        notification.click();
        WebElement allNotification = driver.findElement(By.className("final")).findElement(By.linkText("View All"));
        assertNotNull(allNotification);
        allNotification.click();
    }

    /**
     * Test Remove Notification.
     */
    @Test
    public void iitestRemoveNotification(){
        driver.get("http://localhost:8080/encuestame/home");
        loginEnme();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement notification = driver.findElement(By.className("counter"));

    }

    /**
     * Helper to Change Layout.
     */
    private void changeLayout(){
        loginEnme();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement layout = driver.findElement(By.id("change_layout_button"));
        assertNotNull(layout);
        layout.click();
        WebElement dialog = driver.findElement(By.className("web-layout-select-body"));
        assertNotNull(dialog);
    }
}
