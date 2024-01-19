package javaapplication1;
import java.util.Scanner;
import java.util.InputMismatchException;

// Program szyfrujący, oparty na założeniach szyfru cezara

public class JavaApplication1 {
  public static void main(String[] args) {
    Scanner klawiatura=new Scanner(System.in);
    boolean OK;
    String x = null;
    int y=0;
    int cc=0;
    char c;
    do {
      try {
        OK=true;
        System.out.print("\nPodaj zdanie: ");
        x=klawiatura.nextLine().toUpperCase();
      }
      catch (InputMismatchException ex) {OK=false;klawiatura.nextLine();}
    } while (!OK);
    do {
      try {
        OK=true;
        System.out.print("\nPodaj klucz: ");
        y=klawiatura.nextInt();
      }
      catch (InputMismatchException ex) {OK=false;klawiatura.nextInt();}
    } while (!OK);
    int len = x.length();
    for(int i=0; i<len;i++) {
      int p=(int) x.charAt(i);
      if (p >= 65 && p<=90) {
        cc = (((p - 64)+y+2)%26)+64;
        System.out.print((char) cc);
      } else {
        System.out.print(x.charAt(i));
      }
    }
  }
}
