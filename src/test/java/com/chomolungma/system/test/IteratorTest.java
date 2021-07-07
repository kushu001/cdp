package com.chomolungma.system.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {
    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        list.add("del");
        list.add("aaa");
        list.add("del");
        list.add("bbbb");;

        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String x = it.next();
            if(x.equals("del")){
                it.remove();
            }


            System.out.println(list.size());
        }
    }
}
