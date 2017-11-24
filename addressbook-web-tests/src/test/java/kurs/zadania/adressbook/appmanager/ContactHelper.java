package kurs.zadania.adressbook.appmanager;

import kurs.zadania.adressbook.model.ContactData;
import kurs.zadania.adressbook.model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHomephone());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("work"), contactData.getWorkphone());
    type(By.name("email"), contactData.getEmail());
    type(By.name("email2"), contactData.getEmail2());
    type(By.name("email3"), contactData.getEmail3());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void initContactCreation() {
    wd.findElement(By.linkText("add new")).click();
  }

  public void initContactModification() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  private void initContactModificationById(int id) {
    wd.findElement((By.cssSelector(String.format("a[href='edit.php?id=%s']", id)))).click();
  }

  public void submitContactModification() {
    click (By.name("update"));
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void deleteSelectedContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    accept();
  }

  public void acceptAlert() {
  }

  public void returnToHomePage() {
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home page"));
  }

  public void create(ContactData contact) {
    initContactCreation();
    fillContactForm(contact, true);
    submitContactCreation();
    contactCache = null;
    returnToHomePage();
  }

  public void modify(ContactData contact) {
    initContactModification();
    // initContactModificationById(contact.getId());
    fillContactForm(contact, false);
    submitContactModification();
    contactCache = null;
    returnToHomePage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContact();
    acceptAlert();
    contactCache = null;
    returnToHomePage();
  }

  public boolean isThereAContact() {
     return isElementPresent(By.name("selected[]"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }

      contactCache = new Contacts();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String address = cells.get(3).getText();
      String allEmails = cells.get(4).getText();
      String allPhones = cells.get(5).getText();

      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      contactCache.add(new ContactData()
              .withId(id).withFirstname(firstname).withLastname(lastname).withAddress(address)
              .withAllEmails(allEmails).withAllPhones(allPhones));

    }

    return  new Contacts(contactCache);
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String homephone = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String workphone = wd.findElement(By.name("work")).getAttribute("value");
    wd.navigate().back();
    return  new ContactData()
            .withId(contact.getId()).withFirstname(firstname).withLastname(lastname).withAddress(address)
            .withEmail(email).withEmail2(email2).withEmail3(email3)
            .withHomephone(homephone).withMobile(mobile).withWorkphone(workphone);

  }

  public ContactData dataFromDetailsForm(ContactData contact) {
    initContactDetailsById(contact.getId());
    // String allDetails = wd.findElement(By.xpath("//div[@id='content']")).getText();
    String allDetails = wd.findElement(By.id("content")).getText()
            .replaceAll("(Member of.*|Notice:.*|[WMH]: |\\(www.*\\))","")
            .replaceAll("\\s", "").replaceAll("[-()]", "")
            .replaceAll("\n+", "\n");
    wd.navigate().back();


    return  new ContactData().withAllDetails(allDetails);
  }

  private void initContactDetailsById(int id) {
    wd.findElement((By.cssSelector(String.format("a[href='view.php?id=%s']", id)))).click();
  }

}
