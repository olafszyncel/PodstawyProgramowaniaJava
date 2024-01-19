package javaapplication1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.PrintWriter;

// Program odczyta plik tekstowy i zapisze jego statysyki w pliku o tej samej nazwie z rozszerzeniem stat

public class JavaApplication1 {

    public static void main(String[] args) {
        
        //Pobranie nazwy pliku od użytkownika
        Scanner klawiatura=new Scanner(System.in);
        PrintWriter plikZapisywany;
        String linia="";
        boolean OK;
        do {
           try {   
                OK=true; 
                System.out.print("\nPodaj nazwe pliku: "); 
                linia=klawiatura.nextLine();
                
                }
            catch (InputMismatchException ex) {OK=false;}
                       
       } while (!OK);
        
        
        
        //odcyztanie pliku i zliczenie
        int wyrazy = 1;
        int zdania = 0;
        int litery = 0;
        int samogloski = 0;
        int spolgloski = 0;
        String nowaLinia = "";
        char x;
        
        File handler = new File(linia);
        try {
            Scanner liniaPliku =new Scanner(handler);            
            while (liniaPliku.hasNextLine()) { //pętla iterująca po każdej lini tekstu w pliku
                nowaLinia = liniaPliku.nextLine();
                nowaLinia = nowaLinia.toLowerCase(); //sprowadzenie liter do jednej wielkości by if miał mniej sprawdzania
                for (int i = 0; i<nowaLinia.length(); i++){ //pętla iterująca po każdym znaku w lini
                    x = nowaLinia.charAt(i);
                    if (Character.isLetter(x)) { //sprawdzenie czy znak jest litera
                        litery++;
                        if (x == 'a' || x == 'ą' || x == 'e' || x == 'ę' || x == 'o' || x == 'ó' || x =='u' || x=='y' || x=='i') { //sprawdzenie czy znak jest samogłoska
                            samogloski++;
                        } else { //jesli nie jest samogloska to jest spolgloska
                            spolgloski++;
                        }
                       
                    } else if(x==' '){ // sprawdzenie czy skonczyl sie wyraz
                        wyrazy++;
                    }else if (x=='.') { // sprawdzenie czy skonczylo sie zdanie
                        if (i-1 > 0){
                            if (nowaLinia.charAt(i-1)!='.') {
                                if (i+1 < nowaLinia.length()){
                                    if (nowaLinia.charAt(i+1)!='.') {
                                        zdania++;
                                    }
                                } else {
                                    zdania++;
                                }
                            } 
                        }
                    }
                }
                    
                
               
            }
            
            //Zapisywanie do pliku
            
            String[] pliczek = linia.split("\\.");
            String nazwaPliku = pliczek[0];
            nazwaPliku = nazwaPliku + ".stat";
            plikZapisywany=new PrintWriter(nazwaPliku);
            
            plikZapisywany.write("Wyrazy: " + wyrazy + "\r\n");  
            plikZapisywany.flush(); 
            plikZapisywany.write("Zdania: " + zdania + "\r\n"); 
            plikZapisywany.flush(); 
            plikZapisywany.write("Litery: " + litery + "\r\n"); 
            plikZapisywany.flush(); 
            plikZapisywany.write("Spółgłoski: " + spolgloski + "\r\n");
            plikZapisywany.flush(); 
            plikZapisywany.write("Samogłoski: " + samogloski + "\r\n");  
            plikZapisywany.flush(); 
            
            plikZapisywany.close(); 
            
        }
         
        catch (FileNotFoundException ex) {
            System.err.println("Nie udało się otworzyć pliku - prawdopodobnie plik nie istnieje..."); 
        }
        
        
    }
}
