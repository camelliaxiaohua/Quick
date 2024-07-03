package com.camellia.service.impl;

import com.camellia.pojo.Emp;
import com.camellia.service.EmpService;
import com.camellia.dao.EmpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Datetime: 2024/6/30下午5:50
 * @author: Camellia.xioahua
 */
@Service
public class EmpServiceA implements EmpService {
    @Autowired
    @Qualifier("empDao")
    private EmpDao empDao;

    @Override
    public List<Emp> listEmp() {
        //1.调用dao
        List<Emp> parse = empDao.findAll();
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
        return parse;
    }
}
