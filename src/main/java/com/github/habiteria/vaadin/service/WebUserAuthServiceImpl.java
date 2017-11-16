package com.github.habiteria.vaadin.service;

import com.github.habiteria.dto.UserDto;
import com.github.habiteria.security.UserAuthService;
import com.github.habiteria.vaadin.ui.beans.SignUpBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @author Alex Ivchenko
 */
@Slf4j
@Service
public class WebUserAuthServiceImpl implements WebUserAuthService {
    private UserAuthService userAuthService;
    private AuthenticationProvider authenticationProvider;

    @Autowired
    public void setUserAuthService(UserAuthService userAuthService) {
        this.userAuthService = userAuthService;
    }

    @Autowired
    public void setAuthenticationProvider(AuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }

    @Override
    public void signUp(SignUpBean bean) {
        UserDto dto = new UserDto();
        dto.setUsername(bean.getUsername());
        dto.setEmail(bean.getEmail());
        dto.setFirstName(bean.getFirstName());
        dto.setLastName(bean.getLastName());
        dto.setPassword(bean.getPassword());
        userAuthService.signUp(dto);
    }

    @Override
    public void signIn(String username, String password) {
        log.info("signing in: " + username + " " + password);
        AbstractAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        Authentication auth = authenticationProvider.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(auth);
    }
}
