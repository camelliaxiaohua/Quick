package service.impl;
import dao.BookDao2;
import service.BookService2;

public class BookServiceImpl2 implements BookService2 {
private BookDao2 bookDao2;
    @Override
    //other way通过构造方法绑定关系
    public void save() {
        System.out.println("业务层（service）输出");
        bookDao2.save();
    }
    public BookServiceImpl2(BookDao2 bookDao2) {
        this.bookDao2 = bookDao2;
    }
}
