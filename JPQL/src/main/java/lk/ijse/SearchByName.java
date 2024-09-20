package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

public class SearchByName {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query<Object[]> query = session.createQuery("select (customer_id,name) from Customer c where name = ?1");
        query.setParameter(1, "Thilan");
        List<Object[]> customers = query.list();
        for (Object[] customer : customers) {
            System.out.println(customer[0] + " " + customer[1]);
        }

        transaction.commit();
        session.close();
    }
}
