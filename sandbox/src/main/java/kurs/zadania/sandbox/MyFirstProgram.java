package kurs.zadania.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");

    Square s = new Square (5);
    System.out.println("Powierzchnia kwadratu o boku " + s.l + " = " + area(s));

    Rectangle r = new Rectangle(4,6);

    System.out.println("Powierzchnia prostokąta o bokach " + r.a + " i " + r.b + " = " + area(r));
  }

  public static void hello(String somebody) {
    System.out.println("Hello," + somebody + "!");
  }

  public static double area (Square s) {
    return s.l * s.l;
  }

  public static double area (Rectangle r) {
    return r.a * r.b;
  }
}