package kurs.zadania.adressbook.appmanager;

import kurs.zadania.adressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GroupHelper extends HelperBase{

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void returntoGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void deleteSelectedGroups() {
    click(By.name("delete"));
  }

  public void selectGroup() {
    click(By.name("selected[]"));
  }

  public void initGroupModification() {
    click(By.name("edit"));

  }

  public void submitGroupModification() {
    click(By.name("update"));

  }
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> parent of 61ef5e4... Revert "checking and ensuring the performance of the preconditions have been met"

  public void createGroup(GroupData group) {
  initGroupCreation();
  fillGroupForm(group);
  submitGroupCreation();
  returntoGroupPage();
  }

<<<<<<< HEAD
  public boolean isThereAGroup() { return isElementPresent(By.name("selected[]"));
  }
>>>>>>> parent of 0c641b0... Revert "Revert "Revert "NelperBase class optimalisation"""
=======
  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }
>>>>>>> parent of 61ef5e4... Revert "checking and ensuring the performance of the preconditions have been met"
}
