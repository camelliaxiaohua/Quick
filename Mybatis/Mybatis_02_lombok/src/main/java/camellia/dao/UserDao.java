package camellia.dao;

import camellia.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Datetime: 2024/7/4上午10:16
 * @author: Camellia.xioahua
 */
@Mapper
public interface UserDao {

    @Select("select * from user")
    public List<User> findAll();
}
