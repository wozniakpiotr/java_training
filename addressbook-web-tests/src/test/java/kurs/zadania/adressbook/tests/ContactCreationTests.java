package kurs.zadania.adressbook.tests;

import kurs.zadania.adressbook.model.ContactData;
import kurs.zadania.adressbook.model.Contacts;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() {
        app.goTo().home();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData()
                .withFirstname("first").withLastname("user").withAddress("adress").withMobile("111 111 111").withEmail("firstuser@mail").withGroup("test1");
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));

    }
/*
    @Test
    public void testBadContactCreation() {
        app.goTo().home();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData()
                .withFirstname("first''").withLastname("user").withMobile("111 111 111").withEmail("firstuser@mail").withGroup("test1");
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before));

    }
*/
}
