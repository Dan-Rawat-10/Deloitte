

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class NewClient {
public static void main(String[] args) {
	Configuration config = new Configuration().configure();
	SessionFactory factory = config.buildSessionFactory();
	Session session = factory.openSession();
	
	Transaction trans = session.beginTransaction();
	Customer cust = new Customer(1,"asd","asd",199);
	session.save(cust);
	trans.commit();
	session.close();
	
	
}
}
 