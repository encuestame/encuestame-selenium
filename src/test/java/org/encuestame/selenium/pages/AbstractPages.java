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

package org.encuestame.selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by jpicado on 20/06/15.
 */
public abstract class AbstractPages {

    /**
     *
     */
    protected  WebDriver driver;

    /**
     * Helper to Login Encuestame.
     */
    public void loginEnme() {
        //driver.get("http://localhost:8080/encuestame/home");
        WebElement signin_home = driver.findElement(By.id("signin-home"));
        Assert.assertNotNull(signin_home);
        signin_home.click();
        // Input
        WebElement username = driver.findElement(By.id("j_username"));
        Assert.assertNotNull(username);
        WebElement password = driver.findElement(By.id("j_password"));
        Assert.assertNotNull(password);
        // Write input
        username.sendKeys("dianmorales");
        password.sendKeys("12345");
        WebElement signInbutton = driver.findElement(By.id("signin-button"));
        Assert.assertNotNull(signInbutton);
        signInbutton.click();
    }

    public void closeBrowser() throws Exception {

    }
}
