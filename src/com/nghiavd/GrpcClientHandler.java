package com.nghiavd;
import com.nghiavd.grpc.userGrpc;
import com.nghiavd.grpc.userGrpc.userBlockingStub;
import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSObject;
import com.smartfoxserver.v2.extensions.BaseClientRequestHandler;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import com.nghiavd.grpc.User.LoginRequest;
import com.nghiavd.grpc.User.APIResponse;
import com.google.common.base.Preconditions;
public class GrpcClientHandler extends BaseClientRequestHandler {
    @Override
    public void handleClientRequest(User user, ISFSObject params) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();

        userBlockingStub userStub = userGrpc.newBlockingStub(channel);

        LoginRequest loginRequest = LoginRequest.newBuilder().setUsername("nghiavd").setPassword("nghiavd").build();

        APIResponse response = userStub.login(loginRequest);

        String test = response.getResponsemessage();

//
//        int n1 = params.getInt("n1");
//        int n2 = params.getInt("n2");
//        System.out.println(n1);

        ISFSObject rtn = new SFSObject();

        rtn.putUtfString("sum", test);
        //rtn.putInt("sum", n1 + n2);

        GrpcClientExt parentEx = (GrpcClientExt) getParentExtension();
        parentEx.send("math", rtn, user);


    }
}
