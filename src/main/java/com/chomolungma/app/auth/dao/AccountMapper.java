package com.chomolungma.app.auth.dao;

import com.chomolungma.app.auth.pojo.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

@Mapper
public interface AccountMapper {
	Map<String, String> findByUsernameAndPassword(Account account);

	Account findById(int id);

    void save(Account account);
    
    void update(Account account);

    void resetPasswordById(@Param("ids") String[] ids, @Param("password") String password);
    
    
}
