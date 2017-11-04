package kurs.zadania.adressbook.tests;

import kurs.zadania.adressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData("first", "user", "111 111 111", "firstuser@mail", "test1"), true);
      //  app.getContactHelper().submitContact();
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToHomePage();
    }

}
