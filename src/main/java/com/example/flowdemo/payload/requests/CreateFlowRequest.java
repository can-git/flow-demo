package com.example.flowdemo.payload.requests;

import com.example.flowdemo.domain.EntityDetails;
import com.example.flowdemo.models.Flow;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.function.Supplier;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateFlowRequest implements Supplier<Flow> {
    private String token;
    private long value;
    private int count;

    @Override
    public Flow get() {
        Flow flow = new Flow();
        flow.setEntityDetails(
                EntityDetails.builder()
                        .createdAt(System.currentTimeMillis())
                .build()
        );
        flow.setToken(token);
        flow.setValue(value);
        flow.setCount(count);
        return flow;
    }
}
