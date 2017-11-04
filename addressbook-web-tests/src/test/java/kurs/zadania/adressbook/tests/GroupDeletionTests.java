package kurs.zadania.adressbook.tests;

import kurs.zadania.adressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase{

    @Test
    public void testGroupDeletion() {
     app.getNavigationHelper().gotoGroupPage();
     if (! app.getGroupHelper().isThereAGroup()) {
        app.getGroupHelper().createGroup(new GroupData("test1", null, null));
     }
     app.getGroupHelper().selectGroup();
     app.getGroupHelper().deleteSelectedGroups();
     app.getGroupHelper().returntoGroupPage();
    }

}
