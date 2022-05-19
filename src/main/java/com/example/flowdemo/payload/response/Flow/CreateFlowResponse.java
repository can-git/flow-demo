package com.example.flowdemo.payload.response.Flow;

import com.example.flowdemo.domain.EntityDetails;
import com.example.flowdemo.models.Flow;
import lombok.Data;

import java.util.function.Consumer;

@Data
public class CreateFlowResponse implements Consumer<Flow> {
    private String token;
    private long value;
    private int count;
    private EntityDetails entityDetails;

    @Override
    public void accept(Flow flow) {
        this.token = flow.getToken();
        this.value = flow.getValue();
        this.count = flow.getCount();
        this.entityDetails = flow.getEntityDetails();
    }
}
