/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projektas;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Martynas
 */
public class Player{
    
    final static private int priimtinųMetųRiba = 1975;
    final static private int esamiMetai = LocalDate.now().getYear();  
    final static private double minNaudBal = 5;
    private String vardas;
    private String pavarde;
    private int metai;



    
    public Player(String vardas, String pavarde, int metai) {
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.metai = metai;

    }
    

    
    public String getVardas() {
        return vardas;
    }
    public String getPavarde() {
        return pavarde;
    }
    public int getMetai(){
        return metai;
        
    }




    public final static Comparator pagalMetusBalą = (Comparator) (Object o1, Object o2) -> {
        Player a1 = (Player) o1;
        Player a2 = (Player) o2;
        if(a1.getMetai() < a2.getMetai()) return 1;
        if(a1.getMetai() > a2.getMetai()) return -1;
        return 0;
    };

    
    
    public static class Builder {

        private final static Random RANDOM = new Random(1949);  // Atsitiktinių generatorius                  
        private final static String[][] MODELIAI = {
                        {"Cristiano", "Ronaldo"},
                        {"Lionel", "Messi"},
                        {"Christian", "Eriksen"},
                        {"Kyllian", "Mbappe"},
                        {"Romelu", "Lukaku"},
                        {"Karim", "Benzema"},};

        private String vardas = "";
        private String pavarde= "";
        private int metai = 0;




        public Player buildRandom() {
            int ma = RANDOM.nextInt(MODELIAI.length);        // vardass indeksas  0..
            int mo = RANDOM.nextInt(MODELIAI[ma].length - 1) + 1;// modelio indeksas 1..              
            return new Player(MODELIAI[ma][0],
                    MODELIAI[ma][mo], metai++);
                    

        }

        public Builder metai(int metai) {
            this.metai = metai;
            return this;
        }

        public Builder vardas(String vardas) {
            this.vardas = vardas;
            return this;
        }

        public Builder pavarde(String pavarde) {
            this.pavarde = pavarde;
            return this;
        }


        
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
