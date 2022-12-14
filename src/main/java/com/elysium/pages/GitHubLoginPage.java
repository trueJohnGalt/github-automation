package com.elysium.pages;

import com.elysium.annotations.Url;
import com.elysium.models.Credentials;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;
import static com.elysium.utils.WaitUtils.waitForPageToLoad;

@Component
@Url("/login")
public class GitHubLoginPage implements Page {

    public void login(Credentials credentials) {
        $("input[name='login']").setValue(credentials.getEmail());
        $("input[name='password']").setValue(credentials.getPassword());
        $("input[type='submit']").click();
        waitForPageToLoad();
    }

    public void navigateToRegistrationPage() {
        $("p.login-callout a").click();
        waitForPageToLoad();
    }

    public boolean isLoginErrorMessageDisplayed() {
        return $("div.auth-form div.flash-error").isDisplayed();
    }
}
