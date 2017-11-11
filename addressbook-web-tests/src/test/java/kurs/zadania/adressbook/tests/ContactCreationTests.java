package kurs.zadania.adressbook.tests;

import kurs.zadania.adressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() {
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().gotoHomePage();
        ContactData contact = new ContactData("first", "user", "111 111 111", "firstuser@mail", "test1");
        app.getContactHelper().createContact(contact);
        // app.getNavigationHelper().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);

  /*      int max = 0;
        for (ContactData c : after) {
            if (c.getId() > max) {
                max = c.getId();

            }
        } */
        // contact.setId(after.stream().max((ContactData, t1) -> Integer.compare(ContactData.getId(), t1.getId())).get().getId());
        contact.setId(after.stream().max((t1, t2) -> Integer.compare(t1.getId(), t2.getId())).get().getId());
        before.add(contact);
        Comparator<? super ContactData> ById = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(ById);
        after.sort(ById);
        Assert.assertEquals(before, after);
        // Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

    }

}
