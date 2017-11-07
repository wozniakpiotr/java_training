package kurs.zadania.adressbook.tests;

import kurs.zadania.adressbook.model.GroupData;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GroupDeletionTests extends TestBase{

    @Test
    public void testGroupDeletion() {
     app.getNavigationHelper().gotoGroupPage();
     if (! app.getGroupHelper().isThereAGroup()) {
        app.getGroupHelper().createGroup(new GroupData("test1", null, null));
     }
      List<GroupData> before = app.getGroupHelper().getGroupList();
     app.getGroupHelper().selectGroup(before.size() - 1);
     app.getGroupHelper().deleteSelectedGroups();
     app.getGroupHelper().returntoGroupPage();
      List<GroupData> after = app.getGroupHelper().getGroupList();
      Assert.assertEquals(after.size(), before.size() - 1);    // porównanie list w całości przed i po usunięciu elementu

      before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }
}

