package kurs.zadania.sandbox;

public class Equality {

  public static void main(String[] args) {
    String s1 = "firefox";
    String s2 = new String(s1);      /* String s2 = s1; */

    System.out.println(s1 == s2); /* dwa znaki równości porównują linki (adresy) obiektów - porównanie fizyczne, np. liczb*/
    System.out.println(s1.equals(s2)); /*metoda equals porównuje zawartość obiektów - porównanie logiczne*/

  }
}
