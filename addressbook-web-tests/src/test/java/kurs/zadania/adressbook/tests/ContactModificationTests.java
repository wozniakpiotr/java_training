package kurs.zadania.adressbook.tests;

import kurs.zadania.adressbook.model.ContactData;
import kurs.zadania.adressbook.model.Contacts;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
    app.goTo().home();
      app.contact().create(new ContactData().withFirstname("first"));
    }
  }

  @Test
  public void testContactModification(){
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstname("first").withLastname("user").withAddress("address")
            .withEmail("mail").withEmail2("mail2").withEmail3("mail3")
            .withHomephone("homephone").withMobile("mobile").withWorkphone("workphone")
            .withGroup("test1");
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before. without(modifiedContact).withAdded(contact)));
  }

}
