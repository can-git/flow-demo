package com.example.flowdemo.services;

import com.example.flowdemo.Repository.FlowRepository;
import com.example.flowdemo.models.Flow;
import com.example.flowdemo.payload.requests.CreateFlowRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.*;

@Service
@RequiredArgsConstructor
public class MainPageService {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private FlowRepository flowRepository;

    final private List<Flow> temp = Arrays.asList(
            new Flow("11111111", 1642237219000L,4),
            new Flow("11111111", 1644915619000L,2),
            new Flow("11111111", 1647334819000L,7),
            new Flow("11111111", 1650013219000L,4),
            new Flow("11111111", 1652605219000L,8),
            new Flow("11111111", 1652705219000L,10),
            new Flow("11111111", 1655283619000L,3),
            new Flow("11111111", 1657875619000L,7),
            new Flow("11111111", 1660554019000L,0),
            new Flow("11111111", 1663232419000L,3)

    );

    public List<Flow> getAll(){
        return temp;
    }

    public String getNameByToken(String token){
        return jwtUtil.extractUsername(token);
    }

    public Flow insertData(CreateFlowRequest flowRequest) {
        return flowRepository.insert(flowRequest.get());
    }
}
