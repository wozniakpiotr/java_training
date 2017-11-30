package kurs.zadania.adressbook.tests;

import kurs.zadania.adressbook.model.ContactData;
import kurs.zadania.adressbook.model.Contacts;
import kurs.zadania.adressbook.model.GroupData;
import kurs.zadania.adressbook.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddContactToGroupTests extends TestBase {

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
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testAddContactToGroup() {
    ContactData modifiedContact = app.db().contacts().iterator().next();
    app.goTo().home();
    GroupData group = app.db().groups().iterator().next();
    Contacts before = group.getContacts();
    app.contact().addContactToGroup(modifiedContact, group);
    GroupData addedGroup = app.db().groups().iterator().next();
    Contacts after = addedGroup.getContacts();
    assertThat(after, equalTo(before.withAdded(modifiedContact)));
  }
}
