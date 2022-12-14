package com.elysium.fragments.header;

import com.codeborne.selenide.SelenideElement;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

@Component
@Profile("desktop")
public class HeaderDesktop implements Header {

    private final SelenideElement rootElement = $("header");

    @Override
    public void navigateToLoginPage() {
        rootElement.$("a[href='/login']").shouldBe(enabled).click();
    }

    protected SelenideElement getRootElement() {
        return rootElement;
    }
}
