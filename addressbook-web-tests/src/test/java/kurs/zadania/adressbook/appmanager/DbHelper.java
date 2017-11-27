package kurs.zadania.adressbook.appmanager;

import kurs.zadania.adressbook.model.ContactData;
import kurs.zadania.adressbook.model.GroupData;
import kurs.zadania.adressbook.model.Groups;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class DbHelper {

  private final SessionFactory sessionFactory;

  public DbHelper() {
// A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
      sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
  }

  public Groups groups() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<GroupData> result = session.createQuery( "from GrouptData" ).list();
    session.getTransaction().commit();
    session.close();
    return new Groups(result);
  }
}
