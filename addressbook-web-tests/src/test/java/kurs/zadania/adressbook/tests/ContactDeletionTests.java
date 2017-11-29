package kurs.zadania.adressbook.tests;

import kurs.zadania.adressbook.model.ContactData;
import kurs.zadania.adressbook.model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
    app.goTo().home();
      app.contact().create(new ContactData()
              .withFirstname("firstname").withLastname("lastname").withAddress("address")
              .withEmail("mail").withEmail2("mail2").withEmail3("mail3")
              .withHomephone("homephone").withMobile("mobile").withWorkphone("workphone")
              .withGroup("test1").withPhoto(new File("src/test/resources/pict.png")));
    }
  }

  @Test
  public void testContactDeletion() {
    Contacts before = app.db().contacts();
    ContactData deleteContact = before.iterator().next();
    app.goTo().home();
    app.contact().delete(deleteContact);
    assertThat(app.contact().count(), equalTo(before.size() - 1));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(deleteContact)));
    verifyContactListInUI();
  }
}

