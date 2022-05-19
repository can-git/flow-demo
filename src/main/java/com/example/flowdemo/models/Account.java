package com.example.flowdemo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String id;
    private long creationDate;
    private long updatedDate;
    private String username;
    private String password;
    private List<String> roles;
    private boolean disabled;
}
