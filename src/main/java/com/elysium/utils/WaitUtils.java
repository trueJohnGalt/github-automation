package com.elysium.utils;

import org.awaitility.core.ConditionFactory;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static org.awaitility.Awaitility.with;
import static org.awaitility.Durations.*;

public class WaitUtils {

    public static ConditionFactory doWait() {
        return with().pollInterval(ONE_SECOND).pollInSameThread().atMost(ONE_MINUTE);
    }

    public static void waitForPageToLoad() {
        doWait().until(() -> executeJavaScript("return document.readyState").equals("complete"));
    }
}
