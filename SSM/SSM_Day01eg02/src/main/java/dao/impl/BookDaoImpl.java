package dao.impl;

import dao.BookDao;

public class BookDaoImpl implements BookDao {

    @Override
    public void save() {
        System.out.println("这里是数据层（DAO），通过set方法绑定关系。");
    }
}
