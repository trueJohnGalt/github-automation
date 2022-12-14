package com.elysium;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import com.elysium.extensions.TestResultLoggerExtension;
import com.elysium.pages.GitHubHomePage;
import com.elysium.spring.SpringConfig;
import com.elysium.spring.ProfileMatcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.codeborne.selenide.Selenide.*;
import static com.elysium.utils.WaitUtils.waitForPageToLoad;

@ContextConfiguration(classes = SpringConfig.class)
@ExtendWith({SpringExtension.class, TestResultLoggerExtension.class, ScreenShooterExtension.class})
public class BaseTest {

    @Value("${webdriver.base.url}")
    private String baseUrl;

    @Value("${browser}")
    private String browser;

    @Value("${desktop.resolution}")
    private String desktopResolution;

    @Autowired
    private GitHubHomePage homePage;

    @Autowired
    private ProfileMatcher profileMatcher;

    @BeforeEach
    @Order(1)
    public void setBrowser() {
        Configuration.browser = browser;
    }

    @BeforeEach
    @Order(2)
    public void setBaseUrl() {
        Configuration.baseUrl = baseUrl;
    }

    @BeforeEach
    @Order(1)
    public void setScreenResolution() {
        if (profileMatcher.isProfileMatches("desktop")) {
            Configuration.browserSize = desktopResolution;
        } else {
            System.setProperty("chromeoptions.mobileEmulation", "deviceName=Nexus 5");
        }
        Configuration.browserCapabilities.setCapability("enableVNC", true);
    }

    @BeforeEach
    @Order(3)
    public void openHomePage() {
        homePage.open();
        clearBrowserCookies();
        clearBrowserLocalStorage();
        refresh();
        waitForPageToLoad();
    }
}
