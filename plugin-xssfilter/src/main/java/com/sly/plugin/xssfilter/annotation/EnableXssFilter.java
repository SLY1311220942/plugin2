package com.sly.plugin.xssfilter.annotation;

import com.sly.plugin.xssfilter.configuration.XssFilterConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启xss过滤器注解
 * 
 * @author sly
 * @time 2019年6月18日
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(XssFilterConfig.class)
public @interface EnableXssFilter {

}
