/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab4burn;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import laborai.studijosktu.KTUable;
import laborai.studijosktu.Ks;

/**
 *
 * @surname Martynas
 */
public final class Player implements KTUable{
    
    private String name;
    private String position;
    private double price;
    private String surname;
    private int pageNumber;
    private int printYear;
    
    public Player(){}
    
    public Player(String n, String c, double p, String a, int pn, int py){
        this.name = n;
        this.position = c;
        this.price = p;
        this.surname = a;
        this.pageNumber = pn;
        this.printYear = py;
    }
    
    public Player(String e){
        this.parse(e);
    }

    @Override
    public Player create(String dataString) {
        return new Player(dataString);
    }

    @Override
    public String validate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void parse(String e) {
        try{
            Scanner sc = new Scanner(e);
            this.name = sc.next();
            this.position = sc.next();
            this.price = sc.nextDouble();
            this.surname = sc.next();
            this.pageNumber = sc.nextInt();
            this.printYear = sc.nextInt();
        }catch(InputMismatchException d) {
            Ks.ern("Blogas duomenų formatas apie auto -> " + e);
        } catch (NoSuchElementException d) {
            Ks.ern("Trūksta duomenų apie auto -> " + e);
        }
    }
    
    @Override
    public String toString(){
        return name + "_" + position + "_" + price + "_" + surname + "_" + pageNumber + "_" + printYear;
    }
    
    public String getName(){
        return name;
    }
    public String getCategory(){
        return position;
    }
    public double getPrice(){
        return price;
    }
    public String getAuthor(){
        return surname;
    }
    public int getPageNumber(){
        return pageNumber;
    }
    public int getPrintYear(){
        return printYear;
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(name,position,price,surname,pageNumber,printYear);
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        Player newtemp = (Player) obj;
        if(!Objects.equals(this.name, newtemp.name)){
            return false;
        }
        if(!Objects.equals(this.position, newtemp.position)){
            return false;
        }
        if(Double.doubleToLongBits(this.price) != Double.doubleToLongBits(newtemp.price)){
            return false;
        }
        if(!Objects.equals(this.surname, newtemp.surname)){
            return false;
        }
        if(this.pageNumber != newtemp.pageNumber){
            return false;
        }
        if(this.printYear != newtemp.printYear){
            return false;
        }
        return true;            
    }
    
    public static class Builder {

        private final static Random RANDOM = new Random(2005);  // Atsitiktinių generatorius
        private final static String[][] MODELIAI = { // galimų automobilių markių ir jų modelių masyvas
            {"Cristiano", "striker","Ronaldo"},
            {"Lionel", "striker","Messi"},
            {"Romelu", "striker","Lukaku"},
            {"Raphael", "defender","Varane"},
            {"Kevin", "Midf","De Bruyne"},
            {"Eden", "Winger","Hazard"},
            {"Hugo", "GK","Lloris"}
        };

        private String name = "";
        private String position = "";
        private double price = -1.0;
        private String surname = "";
        private int pageNumber = -1;
        private int printYear = -1;

//        public Player build() {
//            return new Player(this);
//        }

        public Player buildRandom() {
            int ma = RANDOM.nextInt(MODELIAI.length);             
            return new Player(MODELIAI[ma][0],
                    MODELIAI[ma][1],
                    20 + RANDOM.nextDouble(40),
                    MODELIAI[ma][2],
                    200 + RANDOM.nextInt(400),
                    1990 + RANDOM.nextInt(33));
        }

        public Builder printYear(int py) {
            this.printYear = py;
            return this;
        }

        public Builder name(String n) {
            this.name = n;
            return this;
        }

        public Builder position(String c) {
            this.position = c;
            return this;
        }

        public Builder surname(String a) {
            this.surname = a;
            return this;
        }

        public Builder price(double p) {
            this.price = p;
            return this;
        }
        
        public Builder pageNumber(int pn){
            this.pageNumber = pn;
            return this;
        }
    }
}
