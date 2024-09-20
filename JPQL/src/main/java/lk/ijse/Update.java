package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

public class Update {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("update Customer set name = ?1 where customer_id = ?2");
        query.setParameter(1, "Orion");
        query.setParameter(2, 1);
        query.executeUpdate();

        transaction.commit();
        session.close();
    }
}
