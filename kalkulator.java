package javaapplication1;
import java.util.Scanner;
import static java.lang.Math.*;
import java.util.InputMismatchException;

//Program realizujący podstawowe funkcje kalkulatora

public class JavaApplication1 {
  public static void main(String[] args) {
    Scanner klawiatura=new Scanner(System.in);
    boolean OK;
    float x = 0;
    float y = 0;
    int z = 0;
    do {
      try {
        OK=true;
        System.out.print("\nPodaj pierwszą liczbę: ");
        x=klawiatura.nextFloat();
        System.out.print("\nPodaj drugą liczbę: ");
        y=klawiatura.nextFloat();
      }
      catch (InputMismatchException ex) {OK=false;klawiatura.nextFloat();}
    } while (!OK);
    do {
      try {
        OK=true;
        System.out.print("\nPodaj liczbe przy której jest operacje matematyczna");
        System.out.print("\n1 - Suma");
        System.out.print("\n2 - Różnica");
        System.out.print("\n3 - Iloczyn");
        System.out.println("\n4 - Iloraz");
        z=klawiatura.nextInt();
      }
      catch (InputMismatchException ex) {OK=false;klawiatura.nextInt();}
    } while (!OK);
    float suma = x+y;
    float roznica = x-y;
    float iloczyn = x*y;
    switch (z) {
      case 0:
      System.out.print("\nNie podałeś operacji matematycznej");
      break;
      case 1:
      System.out.println("suma: " + suma);
      break;
      case 2:
      System.out.println("różnica: " + roznica);
      break;
      case 3:
      System.out.println("iloczyn: " + iloczyn);
      break;
      case 4:
        if (y != 0) {
          float iloraz = x/y;
          System.out.println("iloraz: " + iloraz);
        } else {
          System.out.println("nie można wykonać ilorazu");
        }
        break;
    }
  }
}
