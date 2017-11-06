package kurs.zadania.adressbook.tests;

import kurs.zadania.adressbook.model.GroupData;
import org.junit.Assert;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase{

    @Test
    public void testGroupDeletion() {
     app.getNavigationHelper().gotoGroupPage();
      int before = app.getGroupHelper().getGroupCount();
     if (! app.getGroupHelper().isThereAGroup()) {
        app.getGroupHelper().createGroup(new GroupData("test1", null, null));
     }
     app.getGroupHelper().selectGroup(before - 1);
     app.getGroupHelper().deleteSelectedGroups();
     app.getGroupHelper().returntoGroupPage();
      int after = app.getGroupHelper().getGroupCount();
      Assert.assertEquals(after, before - 1);
    }

}
