package com.chomolungma.common.tree.utils;

import com.chomolungma.common.tree.annotation.Children;
import com.chomolungma.common.tree.annotation.Id;
import com.chomolungma.common.tree.annotation.Pid;

import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class TreeEntity {
    public static <T> List<T> buildTree(List<T> oldList){
        Map<Long,T> map = new HashMap<>();

        for (T t: oldList) {
            Field[] fields = t.getClass().getDeclaredFields();
            for (Field field: fields) {
                Annotation idAnnotation = field.getAnnotation(Id.class);

                if (idAnnotation != null){
                    String idField = field.getName();
                    try {
                        PropertyDescriptor pd = new PropertyDescriptor(idField,t.getClass());
                        Method idMethod = pd.getReadMethod();
                        Long id = (Long)idMethod.invoke(t);
                        map.put(id,t);
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        }

        List<T> treeList = new ArrayList<>();
        for (T t: oldList) {
            Field[] fields = t.getClass().getDeclaredFields();

            for (Field field: fields) {
                Annotation pidAnnotation = field.getAnnotation(Pid.class);

                if (pidAnnotation != null){
                    String pidField = field.getName();
                    try {
                        PropertyDescriptor pd = new PropertyDescriptor(pidField,t.getClass());
                        Method pidMethod = pd.getReadMethod();
                        Long pid = (Long)pidMethod.invoke(t);

                        T parent = map.get(pid);
                        if (parent != null){
                            Field[] parentFields = parent.getClass().getDeclaredFields();

                            for (Field parentField: parentFields) {
                                Annotation childrenAnnotation = parentField.getAnnotation(Children.class);

                                if (childrenAnnotation != null){
                                    String childrenField = parentField.getName();


                                    PropertyDescriptor pdChildren = new PropertyDescriptor(childrenField,parent.getClass());
                                    Method childrenGetMethod = pdChildren.getReadMethod();
                                    List<T> children = (List<T>)childrenGetMethod.invoke(parent);

                                    if (children == null){
                                        List<T> ch = new ArrayList<>();
                                        ch.add(t);
                                        Method childrenSetMethod =pdChildren.getWriteMethod();
                                        childrenSetMethod.invoke(parent,ch);
                                    }else{
                                        List<T> ch =  (List<T>)childrenGetMethod.invoke(parent);
                                        ch.add(t);
                                        Method childrenSetMethod =pdChildren.getWriteMethod();
                                        childrenSetMethod.invoke(parent,ch);

                                    }


                                    break;
                                }

                            }
                        }else if(pid == null || pid <=0){
                            treeList.add(t);
                        }
                        break;
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }

            }

        }

        return treeList;
    }
}
