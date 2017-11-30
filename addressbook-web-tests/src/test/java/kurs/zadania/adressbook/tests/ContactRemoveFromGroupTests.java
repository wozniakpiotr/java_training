package kurs.zadania.adressbook.tests;

import kurs.zadania.adressbook.model.ContactData;
import kurs.zadania.adressbook.model.Contacts;
import kurs.zadania.adressbook.model.GroupData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class ContactRemoveFromGroupTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().home();
      app.contact().create(new ContactData()
              .withFirstname("firstame").withLastname("lastname").withAddress("address")
              .withEmail("mail").withEmail2("mail2").withEmail3("mail3")
              .withHomephone("homephone").withMobile("mobile").withWorkphone("workphone"));
    }
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test 1"));
    }
  }

  @Test
  public void testContactRemoveFromGroup() {
    app.goTo().home();
    Contacts before = app.db().getContactToRemove();
    ContactData removeContact = before.iterator().next();
    GroupData group = app.db().groups().iterator().next();
    app.contact().removeContactFromGroup(removeContact, group);
    Contacts after = app.db().contacts();
    assertTrue(after.iterator().next().getGroups().isEmpty());

  }
}

