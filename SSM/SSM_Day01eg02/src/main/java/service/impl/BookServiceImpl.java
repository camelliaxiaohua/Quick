package service.impl;
import dao.BookDao;
import service.BookService;
public class BookServiceImpl implements BookService {
    /*private BookDao bookDao=new BookDaoImpl(); //还需要new，未能完成解耦。
    5、删除业务层中使用的new的方式创建的dao对象
     */
    private BookDao bookDao;
    @Override
    public void save() {
        System.out.println("这里是业务层(BoolService)");
        bookDao.save();
    }
    //6、提供对应的set方法
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
}
