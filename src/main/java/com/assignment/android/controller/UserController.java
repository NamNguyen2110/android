package com.assignment.android.controller;

import com.assignment.android.common.response.ResponseData;
import com.assignment.android.common.utils.MessageUtils;
import com.assignment.android.dto.LoginFormDto;
import com.assignment.android.exception.CustomGlobalException;
import com.assignment.android.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/authentication")
    public ResponseEntity<ResponseData> authentication(@Valid @RequestBody LoginFormDto request) throws CustomGlobalException {
        var accessToken = userService.authenticateAccount(request);
        return ResponseEntity.ok(ResponseData.ofSuccess(MessageUtils.getMessage("Thành công"), accessToken));
    }

}
