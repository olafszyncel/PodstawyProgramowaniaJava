package javaapplication1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.*;
import java.util.Map.Entry;

// Program zlicza występowanie tych samych słów w podanym przez użytkownika pliku tekstowym

public class JavaApplication1 {

    public static void main(String[] args) {
        
        //Pobranie nazwy pliku od użytkownika
        Scanner klawiatura=new Scanner(System.in);
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
        
        //odcyztanie pliku i dodawanie do mapy 
        String nowaLinia;  
        File handler = new File(linia);
        try {
            Scanner liniaPliku =new Scanner(handler);  
            Map<String, Integer> slowa = new HashMap<>();          
            while (liniaPliku.hasNextLine()) { //pętla iterująca po każdej lini tekstu w pliku
                nowaLinia = liniaPliku.nextLine();
                nowaLinia = nowaLinia.toLowerCase(); //sprowadzenie liter do jednej wielkości
                String[] words = nowaLinia.split(" ");
                
                for (String word : words) { //petla iterujaca po slowach w kazdej lini
                    word = word.replace(".", "").replace(",", "");
                    if(slowa.containsKey(word)) {
                        slowa.put(word, slowa.get(word)+1);
                    }
                    else {
                        slowa.put(word, 1);
                    }
                }
            }
            //sortowanie, najpierw klucza alfabetycznie, nastepnie malejaco wartosci i wypisanie na ekran
            List<Entry<String, Integer>> sortowane = new ArrayList<>(slowa.entrySet());
            sortowane.sort(Entry.comparingByKey(Comparator.naturalOrder()));
            sortowane.sort(Entry.comparingByValue(Comparator.reverseOrder()));
            sortowane.forEach(System.out::println); 
        }
        
        catch (FileNotFoundException ex) {
            System.err.println("Nie udało się otworzyć pliku - prawdopodobnie plik nie istnieje..."); 
        }
        
        
    }
}

