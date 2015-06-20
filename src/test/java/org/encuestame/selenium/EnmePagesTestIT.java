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

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by jpicado on 20/06/15.
 */
public class EnmePagesTestIT extends TestCase{

    /**
     *
     */
    private WebDriver driver;

    @Before
    public void before() {

    }

    @Test
    public void testbrowserTest() throws Exception{
        final CoordinatorPages chromePages = new CoordinatorPages(createCapabilities("chrome"));
    }

    /**
     *
     * @param browser
     * @return
     */
    private DesiredCapabilities createCapabilities(final String browser) {
       DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
       desiredCapabilities.setBrowserName(browser);
       desiredCapabilities.setJavascriptEnabled(Boolean.TRUE);
       return  desiredCapabilities;
    }

}
