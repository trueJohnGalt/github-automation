package com.elysium.context;

import com.elysium.models.Credentials;

public class CredentialsContext {

    private final static ThreadLocal<Credentials> credentials = new ThreadLocal<>();

    public static Credentials getCredentials() {
        return credentials.get();
    }

    public static void setCredentials(Credentials credentials) {
        CredentialsContext.credentials.set(credentials);
    }
}
