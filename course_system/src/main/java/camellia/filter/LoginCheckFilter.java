package camellia.filter;

import camellia.utils.JwtUtils;
import camellia.utils.Result;
import com.alibaba.fastjson.JSONObject;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * @Datetime: 2024/7/9下午3:28
 * @author: Camellia.xioahua
 * @description: 登录检查过滤器，用于拦截所有请求，检查用户是否登录。
 */

@Slf4j
@WebFilter(urlPatterns = "/*") // 过滤器注解，拦截所有URL模式
public class LoginCheckFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 过滤器初始化方法
        System.out.println("init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 强制转换为HTTP协议的请求对象和响应对象，以便使用它们的特有方法
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 1. 获取请求的URL
        String url = request.getRequestURL().toString();
        log.info("请求路径：{}", url); // 打印请求路径

        // 2. 判断请求URL是否包含/login，如果包含，说明是登录操作，放行
        if (url.contains("/login")) {
            filterChain.doFilter(request, response); // 放行请求
            return; // 结束当前方法的执行
        }

        // 3. 获取请求头中的令牌（token）
        String token = request.getHeader("token");
        log.info("从请求头中获取的令牌：{}", token); // 打印获取的令牌

        // 4. 判断令牌是否存在，如果不存在，返回错误结果（未登录）
        if (!StringUtils.hasLength(token)) {
            log.info("Token不存在");

            Result responseResult = Result.error("NOT_LOGIN");
            // 把Result对象转换为JSON格式字符串
            String json = JSONObject.toJSONString(responseResult);
            response.setContentType("application/json;charset=utf-8");
            // 响应
            response.getWriter().write(json);

            return; // 结束当前方法的执行
        }

        // 5. 解析令牌，如果解析失败，返回错误结果（未登录）
        try {
            JwtUtils.parseJWT(token);
        } catch (Exception e) {
            log.info("令牌解析失败!");

            Result responseResult = Result.error("NOT_LOGIN");
            // 把Result对象转换为JSON格式字符串
            String json = JSONObject.toJSONString(responseResult);
            response.setContentType("application/json;charset=utf-8");
            // 响应
            response.getWriter().write(json);

            return; // 结束当前方法的执行
        }

        // 6. 放行请求
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // 过滤器销毁方法
        System.out.println("destory...");
    }
}
