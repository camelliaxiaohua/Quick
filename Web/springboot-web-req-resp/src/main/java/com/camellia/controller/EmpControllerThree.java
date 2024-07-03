package com.camellia.controller;

import com.camellia.pojo.Emp;
import com.camellia.pojo.Result;
import com.camellia.service.EmpService;
import com.camellia.service.impl.EmpServiceA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Datetime: 2024/6/30下午5:59
 * @author: Camellia.xioahua
 */
@RestController
public class EmpControllerThree {

    @Autowired
    private EmpService empService;

    @RequestMapping("/listEmp")
    public Result listEmp() {
        //1.调用service，获取数据。
        List<Emp> emps = empService.listEmp();
        return Result.success(emps);
    }
}
