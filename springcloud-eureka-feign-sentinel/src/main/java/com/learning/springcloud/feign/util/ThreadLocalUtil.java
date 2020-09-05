package com.learning.springcloud.feign.util;

public final class ThreadLocalUtil {

    private static final ThreadLocal MAP = new ThreadLocal();

    public static <T> void set(T t){
        MAP.set(t);
    }

    public static <T> T get(){
        return (T)MAP.get();
    }

}
