package com.example.flowdemo.controller;

import com.example.flowdemo.payload.requests.Flow.CreateFlowRequest;
import com.example.flowdemo.payload.requests.Flow.SpecialTokenRequest;
import com.example.flowdemo.payload.response.Flow.CreateFlowResponse;
import com.example.flowdemo.services.FlowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class FlowController {

    private final FlowService flowService;

    @GetMapping("/home")
    public ResponseEntity<?> getFlowData(Authentication authentication){
        return ResponseEntity.ok(
                flowService.getAllByToken(authentication.getName())
        );
    }

    @PostMapping("/insert/{token}")
    public ResponseEntity<?> newFlowData(
            @PathVariable String token,
            @RequestBody CreateFlowRequest flowRequest){
        flowRequest.setToken(token);

        CreateFlowResponse flowResponse = new CreateFlowResponse();
        flowResponse.accept(flowService.insertData(flowRequest));

        return ResponseEntity.ok(
                flowResponse
        );
    }

    @GetMapping("/getSpecialToken")
    public ResponseEntity<?> getSpecialToken(Authentication authentication){
        return ResponseEntity.ok(
                flowService.getAccountCreationDateByUsername(authentication.getName())
        );
    }
}
