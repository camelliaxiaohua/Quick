package com.camellia.service;

import com.camellia.pojo.Emp;

import java.util.List;

/**
 * @Datetime: 2024/6/30下午5:48
 * @author: Camellia.xioahua
 */
public interface EmpService {
    //获取员工列表
    public List<Emp> listEmp();
}
