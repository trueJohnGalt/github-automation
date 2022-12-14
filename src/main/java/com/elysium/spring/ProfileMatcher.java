package com.elysium.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import static java.util.Arrays.asList;

@Component
public class ProfileMatcher {

    @Autowired
    private Environment environment;

    public boolean isProfileMatches(String key) {
        return asList(environment.getActiveProfiles()).contains(key);
    }
}
