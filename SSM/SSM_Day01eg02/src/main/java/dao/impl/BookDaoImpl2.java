package dao.impl;

import dao.BookDao2;

public class BookDaoImpl2 implements BookDao2 {

    @Override
    public void save() {
        System.out.println("数据层（dao）输出，这里通过构造方法绑定关系");
    }
}
