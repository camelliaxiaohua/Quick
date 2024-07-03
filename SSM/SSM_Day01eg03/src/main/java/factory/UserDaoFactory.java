package factory;

import dao.UserDao;
import dao.impl.UserDaoImpl;

public class UserDaoFactory {
    public UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
