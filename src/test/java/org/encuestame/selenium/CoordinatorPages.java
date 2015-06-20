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

import org.encuestame.selenium.pages.Hashtag;
import org.encuestame.selenium.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by jpicado on 20/06/15.
 */
public class CoordinatorPages{

    /**
     *
     */
    private WebDriver driver;

    public CoordinatorPages(DesiredCapabilities capabilities) throws Exception {
        createSession(capabilities);
        this.homePage();
        this.goHome();
        this.hashtagPage();
        this.goHome();
        this.driver.close();
        this.driver.quit();
    }

    private void homePage() throws Exception{
        final HomePage home = new HomePage(this.driver);
        //pages...
    }


    private void hashtagPage()throws Exception{
        final Hashtag hashtag = new Hashtag(this.driver);
    }

    private void goHome(){
        driver.get("http://192.168.1.80:8080/encuestame/home");
    }

    public void createSession(DesiredCapabilities capabilities) throws Exception {
        final URL url = new URL("http://localhost:4444/wd/hub/");
        this.driver = new RemoteWebDriver(url, capabilities);
        driver.get("http://192.168.1.80:8080/encuestame/home");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS).pageLoadTimeout(80, TimeUnit.SECONDS);
    }

}
