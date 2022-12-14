package com.elysium.pages;

import com.elysium.annotations.Url;
import com.elysium.fragments.header.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Url("/")
public class GitHubHomePage implements Page {

    @Autowired
    private Header header;

    public Header getHeader() {
        return header;
    }
}
