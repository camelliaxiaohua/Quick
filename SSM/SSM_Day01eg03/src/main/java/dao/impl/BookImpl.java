package dao.impl;

import dao.BookDao;

public class BookImpl implements BookDao {
    public BookImpl(){
        System.out.println("book dao 构造方法 is running...");
    }
    @Override
    public void save() {
        System.out.println("book dao save ...");
    }
}
