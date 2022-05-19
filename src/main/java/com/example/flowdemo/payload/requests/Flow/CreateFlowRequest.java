package com.example.flowdemo.payload.requests.Flow;

import com.example.flowdemo.domain.EntityDetails;
import com.example.flowdemo.models.Flow;
import com.mongodb.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.function.Supplier;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateFlowRequest implements Supplier<Flow> {
    @Null
    private String token;
    @NotNull
    private long value;
    @NotNull
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
