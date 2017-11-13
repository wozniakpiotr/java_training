package kurs.zadania.adressbook.tests;

import kurs.zadania.adressbook.model.GroupData;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

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
     Set<GroupData> before = app.group().all();
     GroupData deleteGroup = before.iterator().next();
     app.group().delete(deleteGroup);
     Set<GroupData> after = app.group().all();
     Assert.assertEquals(after.size(), before.size() - 1);

     before.remove(deleteGroup);
     Assert.assertEquals(before, after);
    }

}

