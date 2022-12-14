package com.elysium.data;

import com.elysium.models.Credentials;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CredentialsGenerator {

    public static Credentials generateCredentials() {
        return Credentials.builder().email(generateEmail()).password("Password1").build();
    }

    private static String generateEmail() {
        return "test" + getTimeStamp() + getThreadId() + "@mail.com";
    }

    private static String getTimeStamp() {
        LocalDateTime dateTime = LocalDateTime.now();
        return dateTime.format(DateTimeFormatter.ofPattern("MMddHHmmss"));
    }

    private static String getThreadId() {
        return String.valueOf(Thread.currentThread().getId());
    }
}
