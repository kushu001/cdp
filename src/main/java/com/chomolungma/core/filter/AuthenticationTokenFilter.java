package com.chomolungma.core.filter;

import com.chomolungma.core.CurrentProfileHolder;
import com.chomolungma.system.account.domain.assembler.AccountAssembler;
import com.chomolungma.system.account.infrastructure.TokenUtils;
import com.chomolungma.system.login.domain.UserDetail;
import com.github.benmanes.caffeine.cache.Cache;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationTokenFilter extends OncePerRequestFilter {

    private final Cache<String, Object> caffeineCache;

    public AuthenticationTokenFilter(Cache<String, Object> caffeineCache) {
        this.caffeineCache = caffeineCache;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String bearerToken = request.getHeader("Authorization");
        if (!StringUtils.hasText(bearerToken)){
            filterChain.doFilter(request, response);
            return;
        }

        String[] tokenArray = bearerToken.split(" ");
        Long accountId = TokenUtils.decode(tokenArray[1]);
        caffeineCache.getIfPresent("accountId_" + accountId);
        UserDetail userDetail = (UserDetail) caffeineCache.asMap().get("accountId_" + accountId);

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDetail,null,null);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        CurrentProfileHolder.setContext(AccountAssembler.toDTO(userDetail.getAccount()));
        //放行
        filterChain.doFilter(request, response);

    }
}
