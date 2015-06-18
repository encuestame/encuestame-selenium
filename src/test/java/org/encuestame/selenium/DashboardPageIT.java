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
     *
     * @throws Exception
     */
    @Test
    public void testAddGadget() throws Exception {
        //*********  Create helper to Sign In
        loginEnme();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //TODO: Define Id
        WebElement dashboard = driver.findElement(By.linkText("Dashboard"));
        assertNotNull(dashboard);
        dashboard.click();

        WebElement gadgetbutton = driver.findElement(By.id("add_gadget_button"));
        assertNotNull(gadgetbutton);
        gadgetbutton.click();
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //TODO: <div> with new-gadget-win id is repeated
       // WebElement gadgetwin = driver.findElement(By.id("new-gadget-win"));

    }

    /**
     * Test Change to Dashboard Layout-A
     */
    @Test
    public void testChangeLayoutA(){
        changeLayout();
        WebElement layouta = driver.findElement(By.id("layout-a"));
        assertNotNull(layouta);
       //
    }

    /**
     * Test Change to Dashboard Layout-BA
     */
    @Test
    public void testChangeLayoutBA(){
        changeLayout();
        WebElement layoutba = driver.findElement(By.id("layout-ba"));
        assertNotNull(layoutba);
    }

    /**
     * Test Change to Dashboard Layout-AB
     */
    @Test
    public void testChangeLayoutAA(){
        changeLayout();
        WebElement layoutaa = driver.findElement(By.id("layout-aa"));
        assertNotNull(layoutaa);
    }

    /**
     * Test Change to Dashboard Layout-AB
     */
    @Test
    public void testChangeLayoutAB(){
        changeLayout();
        WebElement layoutab = driver.findElement(By.id("layout-ab"));
        assertNotNull(layoutab);
    }

    @Test
    public void testDashboard() throws Exception {
        driver.get("http://localhost:8080/encuestame/home");
        //*********  Create helper to Sign In
        loginEnme();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement dashboard = driver.findElement(By.linkText("Dashboard"));

        Select droplist = new Select(driver.findElement(By.id("dijit_form_ComboBox_0")));
       // droplist.selectByVisibleText("English"); counter

    }

    @Test
    public void testNotification() throws Exception {
        driver.get("http://localhost:8080/encuestame/home");
        loginEnme();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement notification = driver.findElement(By.className("counter"));
        notification.click();

        WebElement allNotification = driver.findElement(By.className("final")).findElement(By.linkText("View All"));
       allNotification.click();
    }

    @Test
    public void testRemoveNotification(){
        driver.get("http://localhost:8080/encuestame/home");
        loginEnme();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement notification = driver.findElement(By.className("counter"));

    }

    /**
     *
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
