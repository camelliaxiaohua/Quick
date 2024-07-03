import dao.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.BookService;

public class App {
        public static void main(String[] args) {
               //3、获取IoC容器
                ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
                //获取bean
                BookDao bookDao=(BookDao) ctx.getBean("bookDao");
                BookService bookService=(BookService) ctx.getBean("bookService");
                bookService.save();
        }
}