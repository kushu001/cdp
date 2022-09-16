package com.chomolungma.system.user.domain.service;

import com.chomolungma.common.exception.BusinessRuntimeException;
import com.chomolungma.system.user.domain.entity.User;
import com.chomolungma.system.user.domain.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDomainService {
    @Autowired
    private IUserRepository iUserRepository;

    public void save(User user){
        User isUser = iUserRepository.findUser(user.getIdNumber());
        if (isUser != null) {
            throw new BusinessRuntimeException("用户身份证号已存在，请查证后再建！");
        } else {
           iUserRepository.save(user);
        }
    }
}
