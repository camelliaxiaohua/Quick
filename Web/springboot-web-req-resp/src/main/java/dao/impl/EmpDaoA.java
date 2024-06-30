package dao.impl;

import com.camellia.pojo.Emp;
import com.camellia.pojo.Result;
import dao.EmpDao;
import utils.XmlParserUtils;

import java.util.List;

/**
 * @Datetime: 2024/6/30下午5:46
 * @author: Camellia.xioahua
 */
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
