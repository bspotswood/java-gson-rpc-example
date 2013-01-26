package com.brentscode;

import com.brentscode.requests.Goodbye;
import com.brentscode.responses.Hello;
import java.io.IOException;

/**
 * Our intent here is to create a simple RPC protocol that will be callable
 * from a Node.js script as a child process that communicates via
 * standard IO streams. This will be done by the node script sending in
 * a JSON encoded request object that gets converted into a corresponding
 * RequestMessage object. The RequestMessage will process the request and
 * then return any number of ResponseMessage objects, as necessary, to
 * fulfill the request. This java program makes use of Google's GSON library 
 * to convert between JSON objects and native Java objects.
 */
public class GsonRpc {

    public static final String APP_VERSION = "0.1";
    
    public static void main(String[] args) throws IOException {
        GsonRpc instance = new GsonRpc();

        instance.run();
    }

    private void run() throws IOException {
        // When started, we automatically send out a Hello message
        (new Hello()).send();

        // Now pump messages until we receive a Goodbye
        RequestMessage message;
        while ((message = RequestMessage.fetchRequest()) != null) {
            if (message instanceof Goodbye) {
                return;
            }
            
            message.process();
        }
    }
}
