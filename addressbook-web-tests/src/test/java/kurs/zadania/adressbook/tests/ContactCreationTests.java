package kurs.zadania.adressbook.tests;

import kurs.zadania.adressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() {
        app.initContactCreation();
        app.fillContactForm(new ContactData("first", "user", "111 111 111", "firstuser@mail"));
        app.submitContact();
    }

}
