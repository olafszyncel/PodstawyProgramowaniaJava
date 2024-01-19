package javaapplication1;
import java.util.Scanner;

// Prrogram sprawdza czy wprowadzona przez użytkownika liczba jest l. pierwszą

public class JavaApplication1 {
    public static void main(String[] args) {
        Scanner liczby = new Scanner(System.in);
        System.out.println("Podaj liczbę: "); int x = liczby.nextInt();
        if (x < 2) {
            System.out.println("nie");
        } 
        else if (x % 2 == 0 || x % 3 == 0) {
            if (x == 2 || x == 3) {
                System.out.println("tak");
            }
            else {
                System.out.println("nie");
            }
        }
        else {
            int p = 3;
            while (p*p <= x && x % p != 0) {
                p += 2;
            }
                if (x % p != 0) {
                    System.out.println("tak");
                }
                else {
                    System.out.println("nie");
                }
        }
    }
}
