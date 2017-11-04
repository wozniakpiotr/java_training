package kurs.zadania.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase{

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

 // public void gotoGroupPage() { click(By.linkText("groups")); }

/* sprawdzanie elementu na stronie i przejście po linku - wariant 1
  public void gotoGroupPage() {
    if (!isElementPresent(By.tagName("h1"))
            || !wd.findElement(By.tagName("h1")).getText().equals("Groups")
            || !isElementPresent(By.name("new"))) {
      click(By.linkText("groups"));
    }
  }
*/
// sprawdzanie elementu na stronie i przejście po linku - wariant 2 lepszy

  public void gotoGroupPage() {
    if (isElementPresent(By.tagName("h1"))
            && !wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && !isElementPresent(By.name("new"))) {
      return;
    }
      click(By.linkText("groups"));
    }

  public void gotoHomePage() {
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
      click(By.linkText("home"));
  }

}
