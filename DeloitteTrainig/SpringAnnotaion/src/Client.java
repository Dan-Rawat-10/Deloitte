import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Client {
public static void main(String[] args) {
	AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
	//Resource res = new ClassPathResource("NewFile.xml");
	//BeanFactory factory = new XmlBeanFactory(res);
	Customer cust = context.getBean(Customer.class);
	Address add = context.getBean(Address.class);
	cust.setCustomerAddress("Mumbai");
	cust.setBillAmount(12234);
	cust.setCustomerId(10);
	cust.setCustomerName("Name");
	
	add.setaId(123);
	add.setCity("Mumbai");
	add.setState("Maha");
	
	//cust.setAddress(add);
	System.out.println(cust);
	
	context.registerShutdownHook();
}
}