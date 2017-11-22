package kurs.zadania.adressbook.tests;

import kurs.zadania.adressbook.model.GroupData;
import kurs.zadania.adressbook.model.Groups;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class GroupDeletionTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
      app.goTo().groupPage();
      if (app.group().all().size() == 0) {
        app.group().create(new GroupData().withName("test1"));
    }
  }

    @Test
    public void testGroupDeletion() {
     Groups before = app.group().all();
     GroupData deleteGroup = before.iterator().next();
     app.group().delete(deleteGroup);
     assertThat(app.group().count(), equalTo(before.size() - 1));
     Groups after = app.group().all();
     assertThat(after, equalTo(before.without(deleteGroup)));
    }

}

