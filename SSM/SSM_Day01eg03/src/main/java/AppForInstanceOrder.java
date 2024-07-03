import dao.OrderDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppForInstanceOrder {
    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        OrderDao orderDao= (OrderDao)ctx.getBean("orderDao");
        orderDao.save();
    }
}
