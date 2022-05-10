package com.nghiavd;

import com.smartfoxserver.v2.extensions.SFSExtension;

public class GrpcClientExt extends SFSExtension {
    @Override
    public void init() {
        this.addRequestHandler("math", GrpcClientHandler.class);
    }
}
