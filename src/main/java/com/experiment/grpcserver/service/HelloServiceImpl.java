package com.experiment.grpcserver.service;


import com.experiment.grpcserver.hello.HelloRequest;
import com.experiment.grpcserver.hello.HelloResponse;
import com.experiment.grpcserver.hello.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;


@Service
public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void greeting(HelloRequest request, StreamObserver<HelloResponse> responseObserver){
        String greeting = "Hello, " + request.getName() + "!!";

        HelloResponse response = HelloResponse.newBuilder().setMessage(greeting).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
