package com.camellia.controller;

import com.camellia.pojo.Emp;
import com.camellia.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utils.XmlParserUtils;

import java.util.List;

/**
 * @Datetime: 2024/6/30下午5:11
 * @author: Camellia.xioahua
 */
@RestController
public class EmpController {
    @RequestMapping("/listEmpnull")
    public Result listEmp() {
        //1.加载并解析emp.xml
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        List<Emp> parse = XmlParserUtils.parse(file, Emp.class);
        //2.对数据进行处理
        parse.stream().forEach(emp -> {
            //处理gender 1：男,2：女
            String gender = emp.getGender();
            if ("1".equals(gender))emp.setGender("男");
            else if("2".equals(gender))emp.setGender("女");
        });

        parse.stream().forEach(emp -> {
            //处理Job 1：讲师,2：班主任，3：就业指导
        String job = emp.getJob();
        if ("1".equals(job))emp.setJob("讲师");
        else if("2".equals(job))emp.setJob("班主任");
        else if("3".equals(job))emp.setJob("就业指导");
    });
        //3.响应结果
        return Result.success(parse);
    }
}
