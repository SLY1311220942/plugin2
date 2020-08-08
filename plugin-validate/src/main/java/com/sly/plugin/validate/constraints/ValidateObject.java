package com.sly.plugin.validate.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author SLY
 * @description TODO
 * @date 2020/8/8
 */
@Documented
@Target({FIELD})
@Retention(RUNTIME)
public @interface ValidateObject {
}
