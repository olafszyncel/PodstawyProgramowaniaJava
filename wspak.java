package javaapplication1;
import java.util.Scanner;
import java.util.InputMismatchException;

// program wypisze wspak słowo wpisane klawiaturą

public class JavaApplication1 {
  public static void main(String[] args) {
    Scanner klawiatura=new Scanner(System.in);
    boolean OK;
    String x = null;
    do {
      try {
        OK=true;
        System.out.print("\nPodaj słowo: ");
        x=klawiatura.nextLine();
      }
      catch (InputMismatchException ex) {OK=false;klawiatura.nextLine();}
    }
    while (!OK);
    int len = x.length();
    for (int i=len; i>0; i--) {
      System.out.print(x.charAt(i-1));
    }
  }
}
