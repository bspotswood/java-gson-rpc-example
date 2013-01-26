package com.brentscode.responses;

import com.brentscode.GsonRpc;
import com.brentscode.ResponseMessage;

/**
 * This message is sent out as soon as the java app is started. It informs the
 * client of the version and helps the client verify that it is indeed
 * talking to the expected host.
 */
public class Hello extends ResponseMessage
{
    private String appName = GsonRpc.class.getSimpleName();
    private String version = GsonRpc.APP_VERSION;
}