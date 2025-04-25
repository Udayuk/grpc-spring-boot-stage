package com.experiment.grpcclient.config;

import com.experiment.grpcserver.hello.HelloServiceGrpc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.grpc.client.GrpcChannelFactory;

@Configuration
public class StubConfig {

    @Bean
    HelloServiceGrpc.HelloServiceBlockingStub helloServiceBlockingStub(GrpcChannelFactory channelFactory){
        return HelloServiceGrpc.newBlockingStub(channelFactory.createChannel("service1"));
    }
}
