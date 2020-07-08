package com.chomolungma.app;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Node {
    String id() default "id";
    String pid() default "pid";
    String children() default "children";
    int root() default 0;

}
