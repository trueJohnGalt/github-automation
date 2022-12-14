package com.elysium.extensions;

import com.elysium.context.CredentialsContext;
import com.elysium.data.CredentialsGenerator;
import com.elysium.models.Credentials;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class GenerateCredentialsExtension implements BeforeEachCallback {

    private final Logger LOGGER = LogManager.getLogger(GenerateCredentialsExtension.class);

    @Override
    public void beforeEach(ExtensionContext context) {
        Credentials credentials = CredentialsGenerator.generateCredentials();
        CredentialsContext.setCredentials(credentials);
        LOGGER.info("Email was generated for test: {}", credentials.getEmail());
    }
}
