package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Datetime: 2024/7/4上午3:59
 * @author: Camellia.xioahua
 */
//2. 定义controller
//2.1 使用@Controller定义bean。
@Controller
public class UserController {

    //2.2设置当前操作的访问路径
    @RequestMapping("/save")
    //2.3设置当前操作的返回值类型
    @ResponseBody
    public String save(){
        System.out.println("UserController save");
        return "{'module':'SpringMVC'}";
    }
}
