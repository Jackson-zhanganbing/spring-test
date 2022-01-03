package com.zab.springboot.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 工具类
 *
 * @author zab
 * @date 2021/12/20 10:01 PM
 */
public class ThreadLocalUtil {

    private ThreadLocalUtil() {
    }

    private static final ThreadLocal<Map<String, Object>> THREAD_LOCAL = ThreadLocal.withInitial(() -> new HashMap<>(10));

    public static Map<String, Object> getThreadLocal() {
        return THREAD_LOCAL.get();
    }

    public static <T> T get(String key) {
        Map<String, Object> map = THREAD_LOCAL.get();
        return get(key, null);
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(String key, T defaultValue) {
        Map<String, Object> map = THREAD_LOCAL.get();
        return (T) Optional.ofNullable(map.get(key)).orElse(defaultValue);
    }

    public static void set(String key, Object value) {
        Map<String, Object> map = THREAD_LOCAL.get();
        map.put(key, value);
    }

    public static void set(Map<String, Object> keyValueMap) {
        Map<String, Object> map = THREAD_LOCAL.get();
        map.putAll(keyValueMap);
    }

    public static void remove() {
        THREAD_LOCAL.remove();
    }

    @SuppressWarnings("unchecked")
    public static <T> T remove(String key) {
        Map<String, Object> map = THREAD_LOCAL.get();
        return (T) map.remove(key);
    }

}
