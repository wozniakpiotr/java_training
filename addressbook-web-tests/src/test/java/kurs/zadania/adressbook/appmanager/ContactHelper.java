package kurs.zadania.adressbook.appmanager;

import kurs.zadania.adressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("email"), contactData.getEmail());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void initContactCreation() {
    wd.findElement(By.linkText("add new")).click();
  }

  /* public void selectContact() {
    click(By.name("selected"));  } */

  // public void initContactModification() {click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));}
  public void initContactModification() {click(By.cssSelector("img[alt='Edit'"));}

  // public void submitContactModification() {click(By.xpath("//div[@id='content']/form[1]/input[22]"));}
  public void submitContactModification() {click (By.name("update"));}

  public void submitContactCreation() {click(By.name("submit")); }

  public void returnToHomePage() {click(By.linkText("home page")); }
}
