package com.assignment.android.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AccessTokenDto implements Serializable {
    private String username;
    private String accessToken;
    private String role;
}
