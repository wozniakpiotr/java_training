package kurs.zadania.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {

    Punkt p1 = new Punkt();
    Punkt p2 = new Punkt();
    p1.x1 = 10;
    p1.y1 = 10;
    p2.x2 = 10;
    p2.y2 = 20;
    System.out.println("Współrzędne punktu p1 to " + "x = " + p1.x1 + " i " + "y = " + p1.y1);
    System.out.println("Współrzędne punktu p2 to " + "x = " + p2.x2 + " i " + "y = " + p2.y2);
    System.out.println("Odległość między punktami p1 i p2" + " = " + distance(p1,p1));
  }
  public static double distance(Punkt p1, Punkt p2)

  {
    return Math.sqrt((p1.x1 - p2.x2)*(p1.x1 - p2.x2)+
            (p1.y1 - p2.y2)*(p1.y1 - p2.y2));

  }

}

 /*

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
 */