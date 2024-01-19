package javaapplication1;
import java.util.Scanner;
import static java.lang.Math.*;
import java.util.Random;

// Program randomowo rzuca kostką do gry tyle razy ile poprosi użytkownik

public class JavaApplication1 {
  public static void main(String[] args) {
    Scanner liczby = new Scanner(System.in);
    System.out.println("Podaj liczbę rzutów kostką: "); int x = liczby.nextInt();
    for (int i=0; i<x; i++) {
      Random rand=new Random();
      int luck = (abs(rand.nextInt() % 6));
      switch (luck) {
        case 0:
        System.out.println();
        System.out.println(" * ");
        System.out.println();
        break;
        case 1:
        System.out.println(" *");
        System.out.println("");
        System.out.println(" *");
        break;
        case 2:
        System.out.println(" *");
        System.out.println(" * ");
        System.out.println(" *");
        break;
        case 3:
        System.out.println(" * *");
        System.out.println("");
        System.out.println(" * *");
        break;
        case 4:
        System.out.println(" * *");
        System.out.println(" * ");
        System.out.println(" * *");
        break;
        case 5:
        System.out.println(" * *");
        System.out.println(" * *");
        System.out.println(" * *");
        break;
      }
      System.out.println("================");
    }
  }
}
