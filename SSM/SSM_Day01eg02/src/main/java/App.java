import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.BookService;
import service.BookService2;

public class App {
        public static void main(String[] args) {
               //3、获取IoC容器
                ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
                /**获取bean*/
                //通过set方法绑定
                BookService bookService=(BookService) ctx.getBean("bookService");
                bookService.save();
                //通过构造方法绑定
                BookService2 bookService2=(BookService2) ctx.getBean("bookService2");
                bookService2.save();

                /** bean的作用范围 singleton（默认）、prototype。*/
                System.out.println(bookService);
                BookService bookService3=(BookService) ctx.getBean("bookService");
                System.out.println(bookService3);
        }
}