package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class Query02 {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query<Object[]> query = session.createQuery("select customer_id,name from Customer");
        List<Object[]> list = query.getResultList();
        List<Customer> customers = new ArrayList<>();
        for (Object[] o : list) {
            customers.add(new Customer((Integer)o[0],(String) o[1]));
        }
        for (Customer customer : customers) {
            System.out.println(customer);
        }

        transaction.commit();
        session.close();
    }
}
