package javaapplication1;
import java.util.Scanner;
import java.util.InputMismatchException;

// Program po pobraniu zdania wypisze każde słowo w osobnej lini

public class JavaApplication1 {
    public static void main(String[] args) {
        Scanner klawiatura=new Scanner(System.in);
        boolean OK;
        String x = null;
        do {
            try {
                OK=true;
                System.out.print("\nPodaj zdanie: ");
                x=klawiatura.nextLine();
            }
            catch (InputMismatchException ex)
            {OK=false;klawiatura.nextLine();}
        }
        while (!OK);
        int len = x.length();
        for (int i=0; i<len; i++) {
            if (x.charAt(i) != (char) 32) {
                System.out.print(x.charAt(i));
            }
            else {
                System.out.println();
            }
        }
        System.out.println();
    }
}
