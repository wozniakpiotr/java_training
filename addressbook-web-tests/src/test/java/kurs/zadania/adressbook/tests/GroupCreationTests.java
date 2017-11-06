package kurs.zadania.adressbook.tests;

import kurs.zadania.adressbook.model.GroupData;
import org.junit.Assert;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupPage();
        int before = app.getGroupHelper().getGroupCount();   //liczenie należy pzeprowadzać będąc na odpowiedniej stronie
        app.getGroupHelper().createGroup(new GroupData("test1", null, null));
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before + 1);
    }

}
