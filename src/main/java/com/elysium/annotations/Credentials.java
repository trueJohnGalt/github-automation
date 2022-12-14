package com.elysium.annotations;

import com.elysium.extensions.GenerateCredentialsExtension;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Tag("credentials")
@ExtendWith(GenerateCredentialsExtension.class)
public @interface Credentials {
}
