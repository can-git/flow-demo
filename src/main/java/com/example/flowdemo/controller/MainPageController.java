package com.example.flowdemo.controller;

import com.example.flowdemo.models.Flow;
import com.example.flowdemo.payload.requests.CreateFlowRequest;
import com.example.flowdemo.payload.response.CreateFlowResponse;
import com.example.flowdemo.services.MainPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MainPageController {

    private final MainPageService mainPageService;

    @GetMapping("/home")
    public ResponseEntity<?> getFlowData(){
        return ResponseEntity.ok(
                mainPageService.getAll()
        );
    }

    @PostMapping("/insert/{token}")
    public ResponseEntity<?> newFlowData(
            @PathVariable String token,
            @RequestBody CreateFlowRequest flowRequest){
        flowRequest.setToken(token);

        CreateFlowResponse flowResponse = new CreateFlowResponse();
        flowResponse.accept(mainPageService.insertData(flowRequest));

        return ResponseEntity.ok(
                flowResponse
        );
    }

    @PostMapping("/getSpecialToken")
    public ResponseEntity<?> getSpecialToken(@RequestBody String jwtLogin){
        return ResponseEntity.ok(
//                mainPageService.getNameByToken(jwtLogin)
                "11111111"
        );
    }
}
