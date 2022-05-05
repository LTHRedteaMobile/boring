package com.microservice.auth.service;

import com.microservice.auth.constant.MessageConstant;
import com.microservice.auth.domain.OauthUser;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Alex Liu
 * @date 2022/05/04
 */
@Service
public class UserAuthService implements UserDetailsService {

    private List<OauthUser> oauthUsers = new LinkedList<>();

    @PostConstruct
    private void init() {
        OauthUser user1 = OauthUser.builder().username("Alex").password("Alex").role("admin").build();
        OauthUser user2 = OauthUser.builder().username("Eric").password("Eric").role("user").build();
        OauthUser user3 = OauthUser.builder().username("Vicky").password("Vicky").role("test").build();
        oauthUsers.add(user1);
        oauthUsers.add(user2);
        oauthUsers.add(user3);
    }

    /**
     * 在这里实现用户信息校验
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<OauthUser> findUserList = oauthUsers.stream()
                .filter(item -> item.getUsername().equals(username))
                .collect(Collectors.toList());
        if (CollectionUtils.isEmpty(findUserList)) {
            throw new UsernameNotFoundException(MessageConstant.USERNAME_PASSWORD_ERROR);
        }
        OauthUser securityUser = findUserList.get(0);
        if (!securityUser.isEnabled()) {
            throw new DisabledException(MessageConstant.ACCOUNT_DISABLED);
        } else if (!securityUser.isAccountNonLocked()) {
            throw new LockedException(MessageConstant.ACCOUNT_LOCKED);
        } else if (!securityUser.isAccountNonExpired()) {
            throw new AccountExpiredException(MessageConstant.ACCOUNT_EXPIRED);
        } else if (!securityUser.isCredentialsNonExpired()) {
            throw new CredentialsExpiredException(MessageConstant.CREDENTIALS_EXPIRED);
        }
        return securityUser;
    }
}
