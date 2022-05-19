package com.example.flowdemo.services;

import com.example.flowdemo.Repository.AccountRepository;
import com.example.flowdemo.Repository.FlowRepository;
import com.example.flowdemo.models.Account;
import com.example.flowdemo.models.Flow;
import com.example.flowdemo.payload.requests.Flow.CreateFlowRequest;
import com.example.flowdemo.payload.requests.Flow.SpecialTokenRequest;
import com.example.flowdemo.payload.response.Flow.SpecialTokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class FlowService {

    private final FlowRepository flowRepository;
    private final AccountRepository accountRepository;

    final private List<Flow> temp = Arrays.asList(
            new Flow("1652893599702", 1642237219000L, 4),
            new Flow("1652893599702", 1644915619000L, 2),
            new Flow("1652893599702", 1647334819000L, 7),
            new Flow("1652893599702", 1650013219000L, 4),
            new Flow("1652893599702", 1652605219000L, 8),
            new Flow("1652893599702", 1652705219000L, 10),
            new Flow("1652893599702", 1655283619000L, 3),
            new Flow("1652893599702", 1657875619000L, 7),
            new Flow("1652893599702", 1660554019000L, 0),
            new Flow("1652893599702", 1657875619000L, 3)

    );

    public SpecialTokenResponse getAccountCreationDateByUsername(String username) {
        SpecialTokenResponse specialTokenResponse = new SpecialTokenResponse();

        specialTokenResponse.accept(accountRepository.findByUsername(username)
                .get().getCreationDate());

        return specialTokenResponse;
    }

    public List<Flow> getAllByToken(String token) {
        return flowRepository.findAllByTokenEqualsOrderByValue(
                String.valueOf(
                        accountRepository.findByUsername(token).get().getCreationDate()
                )
        );
    }

    public List<Flow> getAll() {
        return temp;
    }


    public Flow insertData(CreateFlowRequest flowRequest) {
        return flowRepository.insert(flowRequest.get());
    }
}
