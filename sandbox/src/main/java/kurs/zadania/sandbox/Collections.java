package kurs.zadania.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

  public static void main (String[] args) {
    String[] langs = {"Java", "C#", "Python", "PHP"};  //nawias kwadratowy

    /* standardowo z wymienianiem elementów listy

    List<String> languages = new ArrayList<String>();
    languages.add("Java");
    languages.add("C#");
    languages.add("Python");
    languages.add("PHP");
    */

    // przy użyciu gotowej klasy do przekształcania tablicy w listę
    // rozmiar tablicy jest stały i nie można go zmieniać, rozmiar listy może się zmieniać dynamicznie
    // w przypadku elementów listy stosuje się nawias klamrowy, a w przypadku listy nawias zwykły

    List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP");   // w nawiasach trójkątnych określa się typ elementów listy, który potem można użyć w zmiennej

 //   for (int i = 0; i < langs.length; i++) {    dla tablicy stosuje się atrybut "długość", a dla listy metodę "rozmiar"
    //    for (String l : langs) {
       /* for (int i = 0; i < languages.size(); i++) {
        System.out.println("Chcę nauczyć się " + languages.get(i)); // l - zmienna odnośnik do elementu tablicy wskazuje wszystkie elementy kolecji
    */
       for (String l : languages) {
        System.out.println("Chcę nauczyć się " + l);
    }
  }
}

// klasy do pracy z tablicami : https://docs.oracle.com/javase/7/docs/api/index.html?java/util/Collections.html