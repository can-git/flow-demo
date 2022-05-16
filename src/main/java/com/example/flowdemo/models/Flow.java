package com.example.flowdemo.models;

import com.example.flowdemo.domain.ProcessableEntity;
import lombok.*;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Flow extends ProcessableEntity {
    private String token;
    private long value;
    private int count;
}
