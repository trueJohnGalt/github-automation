package com.elysium;

import com.elysium.annotations.Credentials;
import com.elysium.annotations.Regression;
import com.elysium.annotations.Smoke;
import com.elysium.context.CredentialsContext;
import com.elysium.pages.GitHubHomePage;
import com.elysium.pages.GitHubLoginPage;
import com.elysium.pages.GitHubRegistrationPage;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class GitHubLoginPageTest extends BaseTest {

    @Autowired
    private GitHubHomePage homePage;

    @Autowired
    private GitHubLoginPage loginPage;

    @Autowired
    private GitHubRegistrationPage registrationPage;

    @Smoke @Credentials
    @DisplayName("User tries to login with non-existent credentials")
    public void loginWithNonExistentCredentials() {
        homePage.getHeader().navigateToLoginPage();
        loginPage.login(CredentialsContext.getCredentials());
        assertThat(loginPage.isLoginErrorMessageDisplayed())
                .withFailMessage("Login error message should be displayed")
                .isTrue();
    }

    @Regression
    @DisplayName("User navigates to registration page from login page")
    public void navigateToRegistrationPage() {
        loginPage.open();
        loginPage.navigateToRegistrationPage();
        assertThat(registrationPage.isRegistrationFormDisplayed())
                .withFailMessage("Registration form should be displayed")
                .isTrue();
    }
}
