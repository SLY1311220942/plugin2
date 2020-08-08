package com.sly.plugin.validate.constraints;

import com.sly.plugin.validate.constant.Constant;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 对象验证注解
 *
 * @author SLY
 * @description
 * @date 2020/8/8
 */
@Documented
@Target({PARAMETER})
@Retention(RUNTIME)
public @interface Validate {

    /**
     * 验证分组
     *
     * @return
     * @author sly
     */
    @AliasFor("group")
    String value() default Constant.DEFAULT_GROUP;

    /**
     * 验证分组
     *
     * @return
     * @author sly
     * @time 2019年6月26日
     */
    @AliasFor("value")
    String group() default Constant.DEFAULT_GROUP;
}
