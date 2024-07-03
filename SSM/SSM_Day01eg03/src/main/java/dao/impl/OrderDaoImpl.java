package dao.impl;

import dao.OrderDao;

public class OrderDaoImpl implements OrderDao {
    @Override
    public void save() {
        System.out.println("order dao save . . .");
    }
}
