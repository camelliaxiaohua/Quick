package com.camellia.controller;

import com.camellia.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


/**
 * 测试请求参数接受
 * @Datetime: 2024/6/30下午2:25
 * @author: Camellia.xioahua
 */
@RestController
public class RequestController {
    /*简单参数--------------------------------------------------------------------------------------*/

    /**
     * 1.原始方式
     * @param request
     * @return
     */
    @RequestMapping("/simpleParam")
    public String simpleParam(HttpServletRequest request) {
        //获取请求参数
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        Integer ageInt = Integer.parseInt(age);
        System.out.println(name + ":"+ ageInt);
        return "OK";
    }

    /**
     * 2.springboot方式
     * @param name
     * @param age
     * @return
     */
    @RequestMapping("/springboot")
    public String springboot(String name, Integer age) {
        //参数名要和请求的参数名一致，如果不一致则是空值（引用类型）
        System.out.println(name+":"+age);
        return "OK";
    }


    /**
     * 3.springboot方式，解决请求参数名不一致
     * @param username
     * @param age
     * @return OK
     * @RequestParam 中的required属性默认为true（默认值也是true），代表该请求参数必须传递，如果不传递将报错
     * 如果该参数是可选的，可以将required属性设置为false
     */
    @RequestMapping("/springboot2")
    public String springboot2(@RequestParam(name = "name" ,required = false) String username, Integer age) {
        //参数名要和请求的参数名一致，如果不一致则是空值（引用类型）
        System.out.println(username+":"+age);
        return "OK";
    }

    /*实体参数-----------------------------------------------------------------------------*/

    /**
     * 简单实体参数
     * 参数名和实体类属性名不一致时,实体类属性名为空。
     * @param user
     * @return
     */
    @RequestMapping("simplePojo")
    public String simplePojo(User user) {
        System.out.println(user);
        return "OK";
    }

    /**
     * 复杂实体对象指的是，在实体类中有一个或多个属性，也是实体对象类型的。
     * @param user
     * @return
     */
    @RequestMapping("complexPojo")
    public String complexPojo(User user) {
        System.out.println(user);
        return "OK";
    }

    /*数组集合参数-----------------------------------------------------------------------------*/

    /**
     * 数组
     * @param hobby
     * @return
     */
    @RequestMapping("arrayParam")
    public String aeeryParam(String[] hobby) {
        System.out.println(Arrays.toString(hobby));
        return "OK";
    }

    /**
     * 集合参数：**请求参数名与形参集合对象名相同且请求参数为多个，@RequestParam 绑定参数关系**
     * @param hobby
     * @return
     */
    @RequestMapping("listParam")
    public String listParam(@RequestParam List<String> hobby) {
        System.out.println(hobby);
        return "OK";
    }

    /*日期参数--------------------------------------------------------------------------------*/

    /**
     * 因为日期的格式多种多样（如：2022-12-12 10:05:45 、2022/12/12 10:05:45），
     * 那么对于日期类型的参数在进行封装的时候，需要通过@DateTimeFormat注解，以及其pattern属性来设置日期的格式。
     * @param updateTime
     * @return
     */
    @RequestMapping("/dataParam")
    public String dataParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime) {
        System.out.println(updateTime);
        return "OK";
    }

    /* JSON参数------------------------------------------------------------------------*/

    /**
     *- 传递json格式的参数，在Controller中会使用实体类进行封装。
     *- 封装规则：**JSON数据键名与形参对象属性名相同，定义POJO类型形参即可接收参数。需要使用 @RequestBody标识。**
     * @param user
     * @return
     */
    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User user) {
        System.out.println(user);
        return "OK";
    }

    /*路径参数-------------------------------------------------------------------------*/
    @RequestMapping("/path/{id}/{name}")
    public String path(@PathVariable Integer id , @PathVariable String name) {
        System.out.println(id+":"+name);
        return "OK";
    }
}
