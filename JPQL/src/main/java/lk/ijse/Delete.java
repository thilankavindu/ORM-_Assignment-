package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

public class Delete {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("delete from Customer where customer_id = ?1");
        query.setParameter(1, 1);
        int executed = query.executeUpdate();
        System.out.println(executed);

        transaction.commit();
        session.close();
    }
}
