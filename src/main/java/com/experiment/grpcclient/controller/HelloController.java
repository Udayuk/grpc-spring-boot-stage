package com.experiment.grpcclient.controller;


import com.experiment.grpcserver.hello.HelloRequest;
import com.experiment.grpcserver.hello.HelloServiceGrpc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final HelloServiceGrpc.HelloServiceBlockingStub helloServiceBlockingStub;
    public HelloController(HelloServiceGrpc.HelloServiceBlockingStub helloServiceBlockingStub) {
        this.helloServiceBlockingStub = helloServiceBlockingStub;
    }

    @GetMapping("/hello")
    public String sayHello(@RequestBody String name){
        try{
            HelloRequest request = HelloRequest.newBuilder().setName(name).build();

            return helloServiceBlockingStub.greeting(request).getMessage();
        }
        catch(Exception e){
            e.printStackTrace();
            return "Something went wrong!";
        }
    }

}
