package kurs.zadania.adressbook.tests;

import kurs.zadania.adressbook.model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDetailsTests extends TestBase {

  @BeforeMethod

  public void ensurePreconditions() {
    app.goTo().home();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData()
              .withFirstname("first").withLastname("user").withAddress("address")
              .withEmail("mail").withEmail2("mail2").withEmail3("mail3")
              .withHomephone("homephone").withMobile("mobile").withWorkphone("workphone")
              .withGroup("test1"));
    }
  }

  @Test

  public void testDetailsContact() {
    app.goTo().home();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactDataFromDetailsForm = app.contact().dataFromDetailsForm(contact);
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contactDataFromDetailsForm.getAllDetails(), equalTo(mergeData(contactInfoFromEditForm)));
  }

  private String mergeData(ContactData contact) {
    return Arrays.asList(contact.getFirstname(), contact.getLastname(), contact.getAddress(),
            contact.getHomephone(), contact.getMobile(), contact.getWorkphone(),
            contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> !s.equals(""))
            .map(ContactDetailsTests::cleaned)
            .collect(Collectors.joining(""));
  }

    public static String cleaned(String AllDetails) {
    return AllDetails.replaceAll("\\s", "")
            .replaceAll("[-()]", "")
            .replaceAll("\n+", "\n");
  }
}
