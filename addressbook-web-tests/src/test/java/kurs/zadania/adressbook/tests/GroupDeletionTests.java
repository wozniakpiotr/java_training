package kurs.zadania.adressbook.tests;

import kurs.zadania.adressbook.model.GroupData;
import kurs.zadania.adressbook.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupDeletionTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
      if (app.db().groups().size() == 0) {
        app.goTo().groupPage();
        app.group().create(new GroupData().withName("test1"));
    }
  }

    @Test
    public void testGroupDeletion() {
     Groups before = app.db().groups();
     GroupData deleteGroup = before.iterator().next();
     app.goTo().groupPage();
     app.group().delete(deleteGroup);
     assertThat(app.group().count(), equalTo(before.size() - 1));
     Groups after = app.db().groups();
     assertThat(after, equalTo(before.without(deleteGroup)));
    }
}

