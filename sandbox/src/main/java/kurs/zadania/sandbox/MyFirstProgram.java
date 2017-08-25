package kurs.zadania.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");

    double l = 5;
    System.out.println("Powierzchnia kwadratu o boku " + 1 + " = " + area(l));

    double a = 4;
    double b = 6;
    System.out.println("Powierzchnia prostokąta o bokach " + a + " i " + b + " = " + area(a,b));
  }

  public static void hello(String somebody) {
    System.out.println("Hello," + somebody + "!");
  }

  public static double area (double len) {
    return len * len;
  }

  public static double area (double a, double b) {
    return a * b;
  }
}