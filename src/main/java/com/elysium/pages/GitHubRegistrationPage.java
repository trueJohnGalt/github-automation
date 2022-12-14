package com.elysium.pages;

import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;

@Component
public class GitHubRegistrationPage implements Page {

    public boolean isRegistrationFormDisplayed() {
        return $("div.signup-content-container").isDisplayed();
    }
}
