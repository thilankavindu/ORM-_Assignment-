package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class Delete {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("delete from Customer where customer_id = :id");
        query.setParameter("id", 2);
        int executed = query.executeUpdate();
        System.out.println(executed);

        transaction.commit();
        session.close();
    }
}
