package kurs.zadania.adressbook.tests;

import kurs.zadania.adressbook.model.ContactData;
import kurs.zadania.adressbook.model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
    app.goTo().home();
    app.contact().create(new ContactData()
            .withFirstname("firstame").withLastname("lastname").withAddress("address")
            .withEmail("mail").withEmail2("mail2").withEmail3("mail3")
            .withHomephone("homephone").withMobile("mobile").withWorkphone("workphone")
            .withGroup("test1"));
    }
  }

  @Test
  public void testContactModification(){
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withFirstname("firstname").withLastname("lastname").withAddress("address")
            .withEmail("mail").withEmail2("mail2").withEmail3("mail3")
            .withHomephone("homephone").withMobile("mobile").withWorkphone("workphone")
            .withGroup("test1");
    app.goTo().home();
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before. without(modifiedContact).withAdded(contact)));
  }
}
