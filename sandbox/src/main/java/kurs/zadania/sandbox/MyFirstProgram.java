package kurs.zadania.sandbox;


public class MyFirstProgram {

  public static void main(String[] args) {


    Punkt p1 = new Punkt(2, 2);

    Punkt p2 = new Punkt(5, 6);

    System.out.println("Współrzędne punktu p1 to " + "x = " + p1.x + " i " + "y = " + p1.y);
    System.out.println("Współrzędne punktu p2 to " + "x = " + p2.x + " i " + "y = " + p2.y);
    System.out.println("Odległość między punktem p1 (" + p1.x + ", " + p1.y + ") a p2 ("
            + p2.x + ", " + p2.y + ") = " + p1.distance(p2) + ".");
  }
}



/*
  public static void main(String[] args) {
    hello("world");

    Square s = new Square (5);
    System.out.println("Powierzchnia kwadratu o boku " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(4,6);
    System.out.println("Powierzchnia prostokąta o bokach " + r.a + " i " + r.b + " = " + r.area());
  }

  public static void hello(String somebody) {
    System.out.println("Hello," + somebody + "!");
  }


}
*/