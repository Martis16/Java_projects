/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pirmas;

/**
 *Žaidėjo klasė 
 * @author Martynas
 */
public class Player implements Comparable<Player> {
    private final  String Name;
    private final int Age;
    private final int Height;
    /**
     * Konstruktorius 
     * @param Name vardas
     * @param Age amžius
     * @param Height ūgis
     */
    public Player(String Name, int Age,  int Height  ){
        this.Age  = Age;
        this.Name = Name;
        this.Height = Height;
    }
    /**
     * Grąžina žaidejo vardą
     * @return 
     */
        public String getName() {
        return Name;
    }
        /**
         * Grąžina žaidejo amžių
         * @return 
         */
        public int getAge() {
        return Age;
    }
        /**
         * Grąžina žaidejo ūgį
         * @return 
         */
            public int getHeight() {
        return Height;
    }
            
            /**
             * Užklotas spausdinimo metodas
             * @return 
             */
     @Override
    public String toString() {  // pirmas parametras - vaizdavimo formatas
        return String.format("%-2s\t%d\t%d\t",
                Name, Age, Height);
         }
    
    /**
     * užklotas rikiavimo metodas
     * @param pl lyginamas žaidėjas
     * @return 
     */
    @Override public int compareTo(Player pl){
            int poz = (this.Name.compareTo(pl.Name));
                 if ((this.Age > pl.Age) || ((this.Age == pl.Age) && (poz > 0)))
                return 1;
                else return -1;

    }
}
