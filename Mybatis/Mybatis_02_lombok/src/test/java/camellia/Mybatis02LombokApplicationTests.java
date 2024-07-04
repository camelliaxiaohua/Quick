package camellia;

import camellia.dao.UserDao;
import camellia.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Mybatis02LombokApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    public void testSelectAll(){
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user.toString());
        }

    }
}
