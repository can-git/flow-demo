package com.example.flowdemo.controller;

import com.example.flowdemo.payload.requests.FlowResponse;
import com.example.flowdemo.payload.response.JwtLogin;
import com.example.flowdemo.services.JwtUtil;
import com.example.flowdemo.services.MainPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

//    @PostMapping("/insertData")
//    public ResponseEntity<?> getFlowDataFromAPI(@RequestBody FlowResponse flowResponse){
//        return ResponseEntity.ok(
//                mainPageService.insertData()
//        );
//    }


    @PostMapping("/getSpecialToken")
    public String getSpecialToken(@RequestBody String jwtLogin){

        System.out.println(mainPageService.getName(jwtLogin));
        return mainPageService.getName(jwtLogin);

//        return ResponseEntity.ok(
//                mainPageService.getSpecialTokenByToken()
//        );
    }
}
