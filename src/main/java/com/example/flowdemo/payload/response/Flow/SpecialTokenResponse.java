package com.example.flowdemo.payload.response.Flow;

import lombok.Data;

import java.util.function.Consumer;

@Data
public class SpecialTokenResponse implements Consumer<Long> {
    private String token;

    @Override
    public void accept(Long s) {
        this.token = String.valueOf(s);
    }
}
