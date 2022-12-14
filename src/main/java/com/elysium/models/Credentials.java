package com.elysium.models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Credentials {

    private String email;
    private String password;

}
