package com.assignment.android.service.impl;

import com.assignment.android.common.utils.MessageUtils;
import com.assignment.android.dto.AccessTokenDto;
import com.assignment.android.dto.LoginFormDto;
import com.assignment.android.exception.CustomGlobalException;
import com.assignment.android.repository.UserRepository;
import com.assignment.android.security.jwt.TokenProvider;
import com.assignment.android.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepo;
    private final TokenProvider provider;
    private final AuthenticationManager manager;
    private final PasswordEncoder encoder;

    @Override
    public AccessTokenDto authenticateAccount(LoginFormDto request) throws CustomGlobalException {
        var authentication = manager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        var user = userRepo.findByUsername(request.getUsername())
                .orElseThrow(() -> new CustomGlobalException(MessageUtils.getMessage("Người dùng không tồn tại")));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String accessToken = provider.generateToken(authentication);
        return new AccessTokenDto(user.getUsername(), accessToken, user.getRole());
    }
}
