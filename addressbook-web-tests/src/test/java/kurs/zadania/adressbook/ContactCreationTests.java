package kurs.zadania.adressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() {
        initContactCreation();
        fillContactForm(new ContactData("first", "user", "111 111 111", "firstuser@mail"));
        submitContact();
    }

}
