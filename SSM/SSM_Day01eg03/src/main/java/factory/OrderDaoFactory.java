package factory;

import dao.OrderDao;
import dao.impl.OrderDaoImpl;

public class OrderDaoFactory {
    public static OrderDao getOrderDao() {
        System.out.println("factory setup . . .");
        return new OrderDaoImpl();
    }
}
