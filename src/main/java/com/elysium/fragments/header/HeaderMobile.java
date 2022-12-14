package com.elysium.fragments.header;

import com.codeborne.selenide.SelenideElement;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Condition.attribute;
import static com.elysium.utils.WaitUtils.doWait;

@Component
@Profile("mobile")
public class HeaderMobile extends HeaderDesktop {

    @Override
    public void navigateToLoginPage() {
        openMenu();
        super.navigateToLoginPage();
    }

    private void openMenu() {
        if (!isMenuOpen()) {
            getMenuToggleButton().click();
            doWait().until(this::isMenuOpen);
        }
    }

    private boolean isMenuOpen() {
        return getMenuToggleButton().has(attribute("aria-expanded", "true"));
    }

    private SelenideElement getMenuToggleButton() {
        return getRootElement().$("button.Button--link[aria-label='Toggle navigation']");
    }
}
