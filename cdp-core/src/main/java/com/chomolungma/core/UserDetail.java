package com.chomolungma.core;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class UserDetail implements UserDetails {

    private Long accountId;

    private String username;

    private String password;

    private List<Long> roleIds;

    private List<String> permissions;

    private List<String> resources;

    //存储SpringSecurity所需要的权限信息的集合
    @JSONField(serialize = false)
    private List<GrantedAuthority> authorities;

    public UserDetail(Long accountId, String username, String password, List<Long> roleIds, List<String> permissions, List<String> resources) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.permissions = permissions;
        this.resources = resources;
        this.roleIds = roleIds;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(authorities!=null){
            return authorities;
        }
        //把resources中字符串类型的权限信息转换成GrantedAuthority对象存入authorities中
        authorities = resources.stream().
                map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
