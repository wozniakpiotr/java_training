package kurs.zadania.sandbox;


public class Punkt {


  double x;

  double y;
  public Punkt(double x, double y) {

    this.x = x;
    this.y = y;
  }
  public double distance(Punkt p) {

    return Math.sqrt((x - p.x)*(x - p.x) + (y - p.y)*(y - p.y));
  }
}
