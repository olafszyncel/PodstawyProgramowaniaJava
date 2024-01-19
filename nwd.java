package javaapplication1;
import java.util.Scanner;

// Największy wspólny dzielnik

public class JavaApplication1 {
  public static void main(String[] args) {
    Scanner liczby = new Scanner(System.in);
    System.out.println("Podaj pierwszą liczbę: "); int x = liczby.nextInt();
    System.out.println("Podaj drugą liczbę: "); int y = liczby.nextInt();
    while (x != y) {
      if (x > y) {
      x -= y;
      } else {
      y -= x;
      }
    }
    System.out.println(x);
  }
}

