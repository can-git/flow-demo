package com.example.flowdemo.domain;

import lombok.Data;

@Data
public class ProcessableEntity extends Entity{
    private ProcessDetails processDetails;
}
