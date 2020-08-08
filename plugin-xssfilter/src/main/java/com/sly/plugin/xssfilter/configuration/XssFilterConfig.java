package com.sly.plugin.xssfilter.configuration;

import com.sly.plugin.xssfilter.filter.XssFilter;
import com.sly.plugin.xssfilter.properties.XssFilterProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * xss过滤器配置类
 * 
 * @author sly
 * @time 2019年6月18日
 */
@Configuration
@EnableConfigurationProperties(XssFilterProperties.class)
public class XssFilterConfig {
	
	/**
	 * xss过滤器注册
	 * 
	 * @return
	 * @author sly
	 * @time 2019年6月18日
	 */
	@Bean
	public FilterRegistrationBean<XssFilter> xssFilterRegistration(XssFilterProperties properties) {
		FilterRegistrationBean<XssFilter> registration = new FilterRegistrationBean<XssFilter>(new XssFilter(properties));
		registration.addUrlPatterns("/*");
		registration.addInitParameter("paramName", "paramValue");
		registration.setName("xssFilter");
		return registration;
	}
	
}
