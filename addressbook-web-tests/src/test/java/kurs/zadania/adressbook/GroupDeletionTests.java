package kurs.zadania.adressbook;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase{

    @Test
    public void testGroupDeletion() {
     gotoGroupPage();
     selectGroup();
     deleteSelectedGroups();
     returntoGroupPage();
    }

}
