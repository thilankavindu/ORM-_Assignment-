package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.entity.Address;
import lk.ijse.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class Join {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();


        Query<Object[]> query = session.createQuery("select c.customer_id,c.name,a.address_id,a.no,a.street,a.city from Customer c join Address a on c.customer_id = a.customer.customer_id");
        List<Object[]> resultList = query.getResultList();
        for (Object[] res : resultList) {
            System.out.println("customer_id: " + res[0] + "\nname: " + res[1] + "\naddress_id: " + res[2] + "\nno: " + res[3] + "\nstreet: " + res[4] + "\ncity: " + res[5]);
        }

        transaction.commit();
        session.close();
    }
}
