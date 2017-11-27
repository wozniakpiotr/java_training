package kurs.zadania.adressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import kurs.zadania.adressbook.model.ContactData;
import kurs.zadania.adressbook.model.Contacts;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase{


    @DataProvider
    public Iterator<Object[]> validContactsFromXml() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")));
        String xml = "";
        String line = reader.readLine();
        while (line != null) {
            xml += line;
            String[] split = line.split(";");
            line = reader.readLine();
        }
        XStream xStream = new XStream();
        xStream.processAnnotations(ContactData.class);
        List<ContactData> contacts = (List<ContactData>) xStream.fromXML(xml);
        return contacts.stream().map((c) -> new Object[]{c}).collect(Collectors.toList()).iterator();
    }

    @DataProvider  // trzeba ustawić odpowiedni format pliku i zmiennej, w której odczytywana jest zawartość pliku
    public Iterator<Object[]> validContactsFromJson() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")));
        String json = "";
        String line = reader.readLine();
        while (line != null) {
            json += line;
            line = reader.readLine();
        }
        Gson gson = new Gson();
        List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>(){}.getType());
        return contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
    }

        @Test(dataProvider = "validContactsFromJson")  // "validContactsFromXml") - określa z którego pliku będą ładowane dane
    public void testContactCreation(ContactData contact) {
        app.goTo().home();
    //    File photo = new File("src/test/resources/pict.png");
        Contacts before = app.db().contacts();
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));

    }

    // dodatkowy test wskazujący ścieżkę do bieżącego katalog podczas wykonywania testu
/*
    @Test

    public void testCurrentDir() {
        File currentDir = new File(".");
        System.out.println(currentDir.getAbsolutePath());
        File photo = new File("src/test/resources/pict.png");
        System.out.println(photo.getAbsolutePath());                       // sprawdzenie, czy ścieżka jest poprawna
        System.out.println(photo.exists());                                 // sprawdzenie, czy istnieje
    }
*/
/*
    @Test
    public void testBadContactCreation() {
        app.goTo().home();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData()
                .withFirstname("first''").withLastname("user").withMobile("111 111 111").withEmail("firstuser@mail").withGroup("test1");
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before));

    }
*/
}
