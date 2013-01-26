package com.brentscode.requests;

import com.brentscode.GsonRpc;
import com.brentscode.RequestMessage;
import com.brentscode.ResponseMessage;
import com.brentscode.responses.Error;
import com.brentscode.responses.Info;

/**
 * A friendly hello from the client. We'll either reject with an error message
 * or accept with an Info message response.
 */
public class Hello extends RequestMessage {

    private String version;
    
    @Override
    public void process() {
        ResponseMessage response;
        if(!GsonRpc.APP_VERSION.equals(version)) {
            response = new Error(new Exception("Client does not match expected version " + GsonRpc.APP_VERSION));
        } else {
            response = new Info("Ready to receive requests.");
        }
        
        response.send();
    }
    
}
