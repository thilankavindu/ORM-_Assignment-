package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class Insert {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("insert into Customer (customer_id,name) values (:id,:name)");
        query.setParameter("id",1);
        query.setParameter("name","Kavindu");
        int executed = query.executeUpdate();
        System.out.println(executed);

        transaction.commit();
        session.close();
    }
}