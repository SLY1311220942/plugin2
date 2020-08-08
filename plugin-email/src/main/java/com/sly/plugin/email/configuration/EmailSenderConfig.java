package com.sly.plugin.email.configuration;

import com.sly.plugin.email.properties.EmailSenderProperties;
import com.sly.plugin.email.sender.EmailSender;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 邮件发送配置
 *
 * @author SLY
 * @time 2019年7月11日
 * @return
 */
@Configuration
@EnableConfigurationProperties(EmailSenderProperties.class)
public class EmailSenderConfig {

    /**
     * 邮件注册验证
     *
     * @param properties
     * @return
     * @author sly
     * @time 2019年7月11日
     */
    @Bean
    public EmailSender getEmailSender(EmailSenderProperties properties) {
        EmailSender emailSender = new EmailSender();
        emailSender.setEmailSenderProperties(properties);
        return emailSender;
    }
}
