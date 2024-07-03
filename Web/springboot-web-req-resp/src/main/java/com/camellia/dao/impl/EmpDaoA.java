package com.camellia.dao.impl;

import com.camellia.pojo.Emp;
import com.camellia.dao.EmpDao;
import org.springframework.stereotype.Repository;
import com.camellia.utils.XmlParserUtils;

import java.util.List;

/**
 * @Datetime: 2024/6/30下午5:46
 * @author: Camellia.xioahua
 */
@Repository("empDao")
public class EmpDaoA implements EmpDao {
    @Override
    public List<Emp> findAll() {
        //1.加载并解析emp.xml
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        List<Emp> parse = XmlParserUtils.parse(file, Emp.class);
        return parse;
    }
}
