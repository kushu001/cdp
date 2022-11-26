package com.chomolungma.test;

import com.chomolungma.system.staff.infrastructure.mybatis.repository.mapper.StaffMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {
    @Autowired
    private StaffMapper staffMapper;

    @Test
    public void testSelect() {
//        System.out.println(("----- selectAll method test ------"));
//        List<User> userList = userMapper.selectList(null);
//        Assert.assertEquals(2, userList.size());
//        userList.forEach(System.out::println);
    }

}
