package com.sly.plugin.common.result;

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * 公共返回对象
 *
 * @author sly
 * @time 2018年11月12日
 */
public class BaseResult extends HashMap<String, Object> {

    private static final long serialVersionUID = -1937095802242495571L;

    /**
     * 构造方法
     *
     * @return
     * @author SLY
     * @date 2020/8/6
     */
    public BaseResult() {
        super.put("data", new HashMap<>());
    }

    /**
     * 构造方法
     *
     * @param status
     * @return
     * @author SLY
     * @date 2020/8/6
     */
    public BaseResult(IStatus status) {
        super.put("data", new HashMap<>());
        setStatus(status);
    }

    /**
     * 构造方法
     *
     * @param status
     * @param key
     * @param value
     * @return
     * @author SLY
     * @date 2020/8/6
     */
    public BaseResult(IStatus status, String key, Object value) {
        super.put("data", new HashMap<>());
        setStatus(status);
        put(key, value);
    }

    /**
     * 构造方法
     *
     * @param status
     * @param total
     * @param rows
     * @return
     * @author SLY
     * @date 2020/8/6
     */
    public BaseResult(IStatus status, Integer total, List<?> rows) {
        super.put("data", new HashMap<>());
        setStatus(status);
        put("total", total);
        put("rows", rows);
    }

    /**
     * 构造方法
     *
     * @param status
     * @param message
     * @return
     * @author SLY
     * @date 2020/8/6
     */
    public BaseResult(IStatus status, String message) {
        setStatus(status.getStatus());
        setMessage(message);
    }

    /**
     * 获取成功结果对象
     *
     * @return
     * @author SLY
     * @date 2020/8/6
     */
    public static BaseResult success() {
        return new BaseResult(ResultStatus.SUCCESS);
    }

    /**
     * 获取失败结果对象
     *
     * @return
     * @author SLY
     * @date 2020/8/6
     */
    public static BaseResult failed() {
        return new BaseResult(ResultStatus.FAILED);
    }

    /**
     * 获取指定状态的结果对象
     *
     * @param status
     * @return
     * @author SLY
     * @date 2020/8/6
     */
    public static BaseResult setResultStatus(IStatus status) {
        return new BaseResult(status);
    }

    /**
     * 设置状态
     *
     * @param status
     * @return
     * @author SLY
     * @date 2020/8/6
     */
    public void setStatus(String status) {
        super.put("status", status);
    }

    /**
     * 设置状态和消息
     *
     * @param status
     * @return
     * @author SLY
     * @date 2020/8/6
     */
    public void setStatus(IStatus status) {
        setStatus(status.getStatus());
        setMessage(status.getMessage());
    }

    /**
     * 设置消息
     *
     * @param message
     * @return
     * @author SLY
     * @date 2020/8/6
     */
    public void setMessage(String message) {
        super.put("message", message);
    }

    /**
     * 获取状态
     *
     * @return
     * @author SLY
     * @date 2020/8/6
     */
    public String getStatus() {
        return (String) super.get("status");
    }

    /**
     * 获取消息
     *
     * @return
     * @author SLY
     * @date 2020/8/6
     */
    public String getMessage() {
        return (String) super.get("message");
    }

    /**
     * 设置分页总数和list
     *
     * @param total
     * @param rows
     * @return
     * @author SLY
     * @date 2020/8/6
     */
    public BaseResult putTotalList(Long total, List<?> rows) {
        put("total", total);
        put("rows", rows);
        return this;
    }

    /**
     * 设置分页总数和list
     *
     * @param total
     * @param rows
     * @return
     * @author SLY
     * @date 2020/8/6
     */
    public BaseResult putTotalList(Integer total, List<?> rows) {
        put("total", total);
        put("rows", rows);
        return this;
    }

    /**
     * 获取结果里的对象
     *
     * @param key
     * @param clazz
     * @return
     * @author sly
     * @time 2019年11月2日
     */
    public <T> T getResultObject(String key, Class<T> clazz) {
        return JSON.parseObject(JSON.toJSONString(get(key)), clazz);
    }

    /**
     * 获取结果里的list
     *
     * @param key
     * @param clazz
     * @return
     * @author sly
     * @time 2019年11月2日
     */
    public <T> List<T> getResultArray(String key, Class<T> clazz) {
        return JSON.parseArray(JSON.toJSONString(get(key)), clazz);
    }

    @Override
    public BaseResult put(String key, Object value) {
        ((HashMap<String, Object>) super.get("data")).put(key, value);
        return this;
    }

    @Override
    public Object get(Object key) {
        return ((HashMap<String, Object>) super.get("data")).get(key);
    }

    public <T> T get(String key, Class<T> clazz) {
        Object data = ((HashMap<String, Object>) super.get("data")).get(key);
        if (data != null) {
            return JSON.parseObject(JSON.toJSONString(data), clazz);
        }
        return null;
    }

    @Override
    public boolean containsKey(Object key) {
        return ((HashMap<String, Object>) super.get("data")).containsKey(key);
    }

    @Override
    public void clear() {
        ((HashMap<String, Object>) super.get("data")).clear();
    }

    @Override
    public boolean containsValue(Object value) {
        return ((HashMap<String, Object>) super.get("data")).containsValue(value);
    }

    @Override
    public boolean isEmpty() {
        return ((HashMap<String, Object>) super.get("data")).isEmpty();
    }

    @Override
    public void putAll(Map<? extends String, ? extends Object> m) {
        ((HashMap<String, Object>) super.get("data")).putAll(m);
    }

    @Override
    public Object remove(Object key) {
        return ((HashMap<String, Object>) super.get("data")).remove(key);
    }

    @Override
    public boolean remove(Object key, Object value) {
        return ((HashMap<String, Object>) super.get("data")).remove(key, value);
    }

    @Override
    public void replaceAll(BiFunction<? super String, ? super Object, ? extends Object> function) {
        ((HashMap<String, Object>) super.get("data")).replaceAll(function);
    }

    @Override
    public Object replace(String key, Object value) {
        return ((HashMap<String, Object>) super.get("data")).replace(key, value);
    }

    @Override
    public boolean replace(String key, Object oldValue, Object newValue) {
        return ((HashMap<String, Object>) super.get("data")).replace(key, oldValue, newValue);
    }

    @Override
    public Collection<Object> values() {
        return ((HashMap<String, Object>) super.get("data")).values();
    }

    @Override
    @Deprecated
    public Set<Entry<String, Object>> entrySet() {
        return super.entrySet();
    }

    @Override
    public Set<String> keySet() {
        return ((HashMap<String, Object>) super.get("data")).keySet();
    }

    @Override
    public int size() {
        return ((HashMap<String, Object>) super.get("data")).size();
    }

    @Override
    public Object compute(String key, BiFunction<? super String, ? super Object, ? extends Object> remappingFunction) {
        return ((HashMap<String, Object>) super.get("data")).compute(key, remappingFunction);
    }

    @Override
    public Object computeIfAbsent(String key, Function<? super String, ? extends Object> mappingFunction) {
        return ((HashMap<String, Object>) super.get("data")).computeIfAbsent(key, mappingFunction);
    }

    @Override
    public Object computeIfPresent(String key, BiFunction<? super String, ? super Object, ? extends Object> remappingFunction) {
        return ((HashMap<String, Object>) super.get("data")).computeIfPresent(key, remappingFunction);
    }

    @Override
    public void forEach(BiConsumer<? super String, ? super Object> action) {
        ((HashMap<String, Object>) super.get("data")).forEach(action);
    }

    @Override
    public Object merge(String key, Object value, BiFunction<? super Object, ? super Object, ? extends Object> remappingFunction) {
        return ((HashMap<String, Object>) super.get("data")).merge(key, value, remappingFunction);
    }

    @Override
    public Object putIfAbsent(String key, Object value) {
        return ((HashMap<String, Object>) super.get("data")).putIfAbsent(key, value);
    }

    @Override
    public Object getOrDefault(Object key, Object defaultValue) {
        return ((HashMap<String, Object>) super.get("data")).getOrDefault(key, defaultValue);
    }


}
