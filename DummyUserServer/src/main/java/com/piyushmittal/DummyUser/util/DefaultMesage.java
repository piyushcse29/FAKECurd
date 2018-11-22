package com.piyushmittal.DummyUser.util;

import org.springframework.stereotype.Controller;

@Controller
public class DefaultMesage {

    String response;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
