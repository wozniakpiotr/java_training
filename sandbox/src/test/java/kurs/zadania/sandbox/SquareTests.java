package kurs.zadania.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SquareTests {

  @Test
  public void testArea() {

    Square s = new Square(5);
    Assert.assertEquals (s.area(), 25.0);
  }
}

/*
test 1
public class SquareTests {

  @Test
  public void testArea() {

    Square s = new Square(4);
    Assert.assertEquals (s.area(), 25.0);
  }
}

test 2
public class SquareTests {

  @Test
  public void testArea() {

    Square s = new Square(4);
    Assert.assertEquals (s.area(), 16.0);
  }
}

test 3
public class SquareTests {

  @Test
  public void testArea() {

    Square s = new Square(5);
    Assert.assertEquals (s.area(), 30);
  }
}
 */
