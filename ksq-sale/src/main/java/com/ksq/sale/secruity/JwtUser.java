package com.ksq.sale.secruity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

public class JwtUser implements UserDetails {
    private Integer userId;
    private String loginName;
    private String pwd;
    private String userName;
    private final Date lastPasswordResetDate;
    private String state;
    private final Collection<? extends GrantedAuthority> authorities;

    public JwtUser(
            String loginName,
            Integer userId,
            String userName,
            String state,
            String password,
            Collection<? extends GrantedAuthority> authorities,
            Date lastPasswordResetDate) {
        this.loginName = loginName;
        this.userId = userId;
        this.userName = userName;
        this.state = state;
        this.pwd = password;
        this.authorities = authorities;
        this.lastPasswordResetDate = lastPasswordResetDate;

    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }


    @JsonIgnore
    @Override
    public String getPassword() {
        return pwd;
    }

    @JsonIgnore
    @Override
    public String getUsername() {
        return userName;
    }


    @JsonIgnore
    public Integer getUserId() {
        return userId;
    }


    @JsonIgnore
    public String getLoginName() {
        return loginName;
    }


    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }

    @JsonIgnore
    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    /**
     * 根据Authentication获取当前登录用户信息
     * @return
     */
    public static JwtUser getCurrentJWTUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null) return null;
        try {
            return (JwtUser) authentication.getPrincipal();
        } catch (Exception e) {
            return null;
        }
    }

    public static String getCurrentUserName(){
        JwtUser user = getCurrentJWTUser();
        return user == null ? "匿名用户" : user.getLoginName();
    }

    public static Long getCurrentUserId(){
        JwtUser user = getCurrentJWTUser();
        return user == null ? 0L : user.getUserId();
    }



}
