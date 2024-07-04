package camellia.dao;

import camellia.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Datetime: 2024/7/4上午6:12
 * @author: Camellia.xioahua
 */

@Mapper //运行时，会自动生成该接口的实现类对象(代理对象)，并且将该对象交给IOC容器管理。
public interface UserDao {

    //查询全部用户的信息
    @Select("select * from user")
    public List<User> selectAll();

    @Delete("delete from user where id = #{id}")
    public Integer deleteById(Integer id);
}
