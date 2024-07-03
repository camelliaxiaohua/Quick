package config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

/**
 * @Datetime: 2024/7/4上午4:09
 * @author: Camellia.xioahua
 */
//4.定义一个Servlet容器启动的配置类，在里面加载spring的配置。
public class ServletContainersInitConfig extends AbstractDispatcherServletInitializer {
    //加载SpringMVC容器的配置。
    @Override
    protected WebApplicationContext createServletApplicationContext() {
        //创建容器
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        //注册配置
        context.register(SpringMvcConfig.class);
        return context;
    }
    //设置哪些请求归SpringMVC处理。
    @Override
    protected String[] getServletMappings() {
        //设置所有请求归SpringMVC处理。
        return new String[]{"/"};
    }
    //加载spring容器的配置，目前没整合暂不配置。
    @Override
    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }
}
