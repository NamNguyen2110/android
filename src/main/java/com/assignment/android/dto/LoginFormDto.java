package com.assignment.android.dto;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LoginFormDto implements Serializable {
    private String username;
    private String password;
}
