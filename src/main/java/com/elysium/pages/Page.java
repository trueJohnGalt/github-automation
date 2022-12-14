package com.elysium.pages;

import com.codeborne.selenide.Selenide;
import com.elysium.annotations.Url;

import static com.elysium.utils.WaitUtils.waitForPageToLoad;

public interface Page {

    default void open() {
        Selenide.open(this.getClass().getAnnotation(Url.class).value());
        waitForPageToLoad();
    }
}
