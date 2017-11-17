package kurs.zadania.adressbook.tests;

import kurs.zadania.adressbook.model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDataTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().home();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData()
              .withFirstname("first").withLastname("user").withAddress("address")
              .withEmail("firstuser@mail").withEmail2("firstuser@mail2").withEmail3("firstuser@mail3")
              .withHomephone("222222222").withMobile("111 111 111").withWorkphone("333 333 333")
              .withGroup("test1"));
    }
  }


  @Test

public void testAddressContact() {

    app.goTo().home();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactDataFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAddress(), equalTo(contactDataFromEditForm.getAddress()));
//    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactDataFromEditForm)));
//    assertThat(contact.getAllphones(), equalTo(mergePhones(contactDataFromEditForm)));

  }

  @Test

public void testEmailContact() {

    app.goTo().home();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
    }


  private  String mergeEmails (ContactData contact) {
    return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> ! s.equals("")).collect(Collectors.joining("\n"));
  }


  @Test

  public void testPhoneContact() {

    app.goTo().home();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAllphones(), equalTo(mergePhones(contactInfoFromEditForm)));

  }

  private String mergePhones (ContactData contact) {
    return Arrays.asList(contact.getHomephone(), contact.getMobile(), contact.getWorkphone())
            .stream().filter((s) -> ! s.equals("")).map(ContactDataTests::cleaned).collect(Collectors.joining("\n"));
  }

public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
}

}
