package org.encuestame.selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
/**
 * Encuestame initial page test.
 * @author Morales, Diana Paola paolaATencuestame.org
 * @since June 22, 2015
 */
public abstract class AbstractEnmePages {

    /**
     *
     */
    protected WebDriver driver;

    /**
     * Find and Click on element by Id
     * @param elementId
     */
    protected void clickElementById(String elementId) {

        WebElement element = driver.findElement(By.id(elementId));
        Assert.assertNotNull(element);
        element.click();
    }

    /**
     * Find and Click on Element by classname
     * @param elementId
     */
    protected void clickElementByClassName(String elementId) {
        WebElement element = driver.findElement(By.className(elementId));
        Assert.assertNotNull(element);
        element.click();
    }


    /**
     *  Find and Click on element by Link text
     * @param elementLinkText
     */
    protected void clickByLinkText(String elementLinkText) {
        WebElement element = driver.findElement(By.linkText(elementLinkText));
        Assert.assertNotNull(element);
        element.click();
    }

    /**
     *  Verify Element by Id on Page.
     * @param elementId
     */
    protected void verifyElementByIdOnPage(String elementId) {
        try {
            WebElement element = driver.findElement(By.id(elementId));
            Assert.assertNotNull(element);
            } catch (NoSuchElementException e) {
                throw new IllegalStateException("Id "
              	                    + elementId + " not found.");
            }
        //return element;
    }

    /**
     * Verify Element on Page by Classname.
     * @param elementId
     */
    protected void verifyElementByClassNameOnPage(String elementId) {
        //WebElement element;
        try {
            driver.findElement(By.className(elementId));
        } catch (NoSuchElementException e) {
            throw new IllegalStateException("Classname "
                    + elementId + " not found.");
        }
        //return element;
    }

    /**
     * Verify Element by Link text.
     * @param elementId
     */
    protected void verifyElementByLinkOnPage(String elementId) {
        try {
            WebElement element = driver.findElement(By.linkText(elementId));
            Assert.assertNotNull(element);
        } catch (NoSuchElementException e) {
            throw new IllegalStateException("Id "
                    + elementId + " not found.");
        }
        //return element;
    }

    /**
     * Find Element by Id.
     * @param fieldId
     * @return
     */
    protected WebElement findWebElement(String fieldId){
        WebElement element = driver.findElement(By.id(fieldId));
        Assert.assertNotNull(element);
        return element;
    }

    /**
     * Set input fiel with new value.
     * @param fieldId
     * @param value
     */
    protected void setInputFieldValue(String fieldId, String value) {
        WebElement field = this.findWebElement(fieldId);
        field.clear();
        field.sendKeys(value);
    }

    /**
     * Submit input field.
     * @param fieldId
     */
    protected void submitInputField(String fieldId) {
        WebElement field = this.findWebElement(fieldId);
        field.click();
    }

    /**
     * Wait Until To element be clickable
     * @param elementId
     */
    protected  void waitUntilToElementBeClickable(final String elementId){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.id(elementId)));
    }

    /**
     * Wait Until To element be clickable by Link text
     * @param elementId
     */
    protected  void waitUntilToElementBeClickableLink(final String elementId){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText(elementId)));
    }
}