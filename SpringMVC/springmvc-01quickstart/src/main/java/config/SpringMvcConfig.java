package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Datetime: 2024/7/4上午4:06
 * @author: Camellia.xioahua
 */
//3.创建springmvc的配置文件，加载Controller对应的bean。
@Configuration
@ComponentScan("controller")
public class SpringMvcConfig {
}
