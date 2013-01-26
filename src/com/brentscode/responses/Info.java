package com.brentscode.responses;

import com.brentscode.ResponseMessage;

/**
 * A simple informational response message
 */
public class Info extends ResponseMessage {
    private String message;

    public Info(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    
}
