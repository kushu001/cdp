package com.chomolungma.cdp.mapstruct;

import com.chomolungma.cdp.mapstruct.source.PageSon;
import com.chomolungma.cdp.mapstruct.source.Son;
import com.chomolungma.cdp.mapstruct.target.PageSub;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Son son1 = new Son();
        son1.setName("son");
        son1.setSchool("school");
        Son son2 = new Son();
        son2.setName("son2");
        son2.setSchool("school2");

        List<Son> sons = new ArrayList<>();
        sons.add(son1);
        sons.add(son2);

        PageSon pageSon = new PageSon();
        pageSon.setList(sons);


        PageSub pageSub = TestMapper.INSTANCE.toPageSub(pageSon);

        System.out.println(pageSub);

    }
}
