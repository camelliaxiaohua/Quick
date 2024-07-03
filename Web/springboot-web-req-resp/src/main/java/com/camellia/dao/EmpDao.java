package com.camellia.dao;

import com.camellia.pojo.Emp;

import java.util.List;

/**
 * @Datetime: 2024/6/30下午5:45
 * @author: Camellia.xioahua
 */
public interface EmpDao {
    //获取员工列表数据
    public List<Emp> findAll();
}
