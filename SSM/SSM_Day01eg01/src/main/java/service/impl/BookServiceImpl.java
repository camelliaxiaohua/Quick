package service.impl;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import service.BookService;

public class BookServiceImpl implements BookService {
    private BookDao bookDao=new BookDaoImpl(); //还需要new，未能完成解耦。
    @Override
    public void save() {
        System.out.println("这里是业务层(BoolService");
        bookDao.save();
    }
}
