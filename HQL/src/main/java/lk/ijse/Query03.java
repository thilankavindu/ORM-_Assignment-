package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class Query03 {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query<Object[]> query = session.createQuery("select a.address_id,c.name from Address a inner join Customer c on a.customer.customer_id = c.customer_id");
        List<Object[]> list = query.list();

        for (Object[] customer : list) {
            System.out.println(customer[0] + " " + customer[1]);
        }

        transaction.commit();
        session.close();
    }
}
