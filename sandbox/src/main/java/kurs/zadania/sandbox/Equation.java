package kurs.zadania.sandbox;

public class Equation {

  private final double a;
  private final double b;
  private final double c;
  private int n;

  public Equation (double a, double b, double c) {

    this.a = a;
    this.b = b;
    this.c = c;

    double d = b*b - 4*a*c;

    /*  niepełna forma konstrukcji "if" - bez "else",
        czyli jeśli wrunki wykonują się, kod zadziała
        jeżeli warunki nie wykonują się - nie ma alternatywy

    if (a == 0) {
      System.out.println("To zdegenerowanie równanie");
    }
    */

    if (a == 0) {
      if (b == 0) {
        if (c == 0) {
          n = -1;
        } else {
          n = 0;
        }
      } else {
        n = 1;
      }

    } else {
    /* przed optymalizacją - warianty zachowania zagnieżdzone
    if (d > 0) {
      n = 2;
    } else {
      if (d ==0) {
        n = 1;
      } else {
        n = 0;
      }
   */
   /* po optymalizacji - warianty zachowania równorzędne */
      if (d > 0) {
        n = 2;
      } else if (d == 0) {
        n = 1;
      } else {
        n = 0;
      }

    }

   /* wariant poprawny, ale niefektywny,
      bo wymusza sprawdzanie wszystkich 3 równorzędnych warunków,
      nawet jeśli wystarczyłoby sprawdzenie pierwszego wariantu

    if (d > 0) {
      n = 2;
    }

    if (d == 0) {
      n = 1;
    }

    if  (d < 0) {
      n = 0;
    }
    */

  }

  public int rootNumber() {
    return n;
  }

}

/* po ostatecznej optymalizacji i zamianie miejscami równania linearnego i kwadratowego

 if (a != 0) {
      if (d > 0) {
      n = 2
      } else if (d == 0) {
          n = 1;
        } else {
          n = 0;
        }

      } else if (b != c) {
        n = 0;

      } else if (c != 0) {
      n = -1
      
      }
 */