package com.nghiavd;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import com.nghiavd.grpc.User.LoginRequest;
import com.nghiavd.grpc.User.APIResponse;
import com.nghiavd.grpc.userGrpc;
import com.nghiavd.grpc.userGrpc.userBlockingStub;
import com.google.common.base.Preconditions;
import com.google.common.base.Preconditions;


public class TestNghiavd {
    public static void main(String [] args)
    {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();

        userBlockingStub userStub = userGrpc.newBlockingStub(channel);

        LoginRequest loginRequest = LoginRequest.newBuilder().setUsername("nghiavd").setPassword("nghiavd1111").build();

        APIResponse response = userStub.login(loginRequest);

        System.out.println(response.getResponsemessage());
    }
}
