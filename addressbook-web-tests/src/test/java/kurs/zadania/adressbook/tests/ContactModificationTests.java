package kurs.zadania.adressbook.tests;

import kurs.zadania.adressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification(){
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("first", "user", "111 111 111", "firstuser@mail", "test1"));
    }
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("first", "user", "111 111 111", "firstuser@mail", null), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before);

  }
}
