package com.brentscode.requests;

import com.brentscode.RequestMessage;

/**
 * Tells the java program that it is done and can end.
 */
public class Goodbye extends RequestMessage {
    
    @Override
    public void process() {
        System.exit(0);
    }

}