package com.sly.plugin.validate.constraints;

import com.sly.plugin.validate.constant.Constant;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 手机号验证
 * 
 * @author sly
 * @time 2019年6月26日
 */
@Documented
@Target({ FIELD, PARAMETER })
@Retention(RUNTIME)
@Repeatable(Phone.List.class)
public @interface Phone {

	/**
	 * message
	 * 
	 * @return
	 * @author sly
	 * @time 2019年6月26日
	 */
	String message() default "{com.sly.plugin.validate.constraints.Phone.message}";

	/**
	 * 验证分组
	 * 
	 * @return
	 * @author sly
	 * @time 2019年6月26日
	 */
	String[] group() default { Constant.DEFAULT_GROUP };

	/**
	 * 
	 * @author sly
	 * @time 2019年6月26日
	 */
	@Target({ FIELD, PARAMETER })
	@Retention(RUNTIME)
	@Documented
	public @interface List {
		Phone[] value();
	}
}
