package kurs.zadania.sandbox;


public class Punkt {

  public double x1;
  public double y1;
  public double x2;
  public double y2;

}
    double x;
    double y;
  double x;

  double y;
  public Punkt(double x, double y) {

    this.x = x;
    this.y = y;
  }

  public double distance(Punkt p) {

    return Math.sqrt((x - p.x) * (x - p.x) + (y - p.y) * (y - p.y));
    return Math.sqrt((x - p.x)*(x - p.x) + (y - p.y)*(y - p.y));
  }

}
