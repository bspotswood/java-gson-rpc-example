package com.brentscode.requests;

import com.brentscode.RequestMessage;
import com.brentscode.responses.Info;

public class Echo extends RequestMessage {

    private String message;
    
    @Override
    public void process() {
        (new Info(message)).send();
    }
    
}
