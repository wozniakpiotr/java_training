package kurs.zadania.adressbook.tests;

import kurs.zadania.adressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() {
        app.goTo().home();
        Set<ContactData> before = app.contact().all();
        ContactData contact = new ContactData()
                .withFirstname("first").withLastname("user").withMobile("111 111 111").withEmail("firstuser@mail").withGroup("test1");
        app.contact().create(contact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() + 1);

        contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before, after);

    }

}
