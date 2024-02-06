/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Lab2Burneika;


import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;
import java.util.Random;
import studijosKTU.*;
/**
 *
 * @author Martynas
 */
public class greitaveika {

    
    	Player[] ZaidejoBazė1;
	ListKTU<Player> aSeries = new ListKTU<>();
	Random ag = new Random();  // atsitiktinių generatorius
	int[] tiriamiKiekiai = {2_000, 4_000, 8_000, 16_000};
        
        
        	void generuotiAutomobilius(int kiekis) {
                        String[][] Zaidejai = {
                        {"Cristiano", "Ronaldo", "1985", "180", "80", "9.5"},
                        {"Lionel", "Messi", "1987", "170", "70", "9.5"},
                        {"Christian", "Eriksen", "1988", "182", "81", "7.5"},
                        {"Kyllian", "Mbappe", "1998", "185", "80", "9.5"},
                        {"Romelu", "Lukaku", "1992", "189", "86", "7.3"},
                        {"Karim", "Benzema", "1986", "184", "82", "8.8"},};
		ZaidejoBazė1 = new Player[kiekis];
		ag.setSeed(2016);
		for (int i = 0; i < kiekis; i++) {
                                                            int randomIndex = ag.nextInt(Zaidejai.length);			
            			ZaidejoBazė1[i] = new Player(Zaidejai[randomIndex][0],"", 1970 + ag.nextInt(20), 
                                        160+ ag.nextInt(20) , 60 + ag.nextInt(24), 5 + ag.nextDouble(5));                       
                        }
                
                		Collections.shuffle(Arrays.asList(ZaidejoBazė1));
		aSeries.clear();
		for (Player f : ZaidejoBazė1) {
			aSeries.add(f);
		}
                
                
                }

	void paprastasTyrimas(int elementųKiekis) {
		// Paruošiamoji tyrimo dalis
		long t0 = System.nanoTime();
		generuotiAutomobilius(elementųKiekis);
		ListKTU<Player> aSeries2 = aSeries.clone();
		ListKTU<Player> aSeries3 = aSeries.clone();
		ListKTU<Player> aSeries4 = aSeries.clone();
                ListKTU<Player> aSeries5 = aSeries.clone();
		long t1 = System.nanoTime();
		System.gc();
		System.gc();
		System.gc();
		long t2 = System.nanoTime();

		//  Greitaveikos bandymai ir laiko matavimai
		aSeries.sortJava();
		long t3 = System.nanoTime();
		aSeries2.sortJava(Player.pagalVardą);
		long t4 = System.nanoTime();
		aSeries3.sortBuble(Player.pagalUgi);
		long t5 = System.nanoTime();
		aSeries4.sortBuble(Player.pagalMetusBalą);
		long t6 = System.nanoTime();
                                        aSeries5.minMax(Player.pagalUgi);
                                        long t7 = System.nanoTime();
		Ks.ouf("%7d %7.4f %7.4f %7.4f %7.4f %7.4f %7.4f %7.4f\n", elementųKiekis,
				(t1 - t0) / 1e9, (t2 - t1) / 1e9, (t3 - t2) / 1e9,
				(t4 - t3) / 1e9, (t5 - t4) / 1e9, (t6 - t5) / 1e9, (t7-t5)/1e9);
	}

	void tyrimoPasirinkimas() {
		long memTotal = Runtime.getRuntime().totalMemory();
		Ks.oun("memTotal= " + memTotal);
		// Pasižiūrime kaip generuoja automobilius (20) vienetų)
		generuotiAutomobilius(20);
		for (Player a : aSeries) {
			Ks.oun(a);
		}
		Ks.oun("1 - Pasiruošimas tyrimui - duomenų generavimas");
		Ks.oun("2 - Pasiruošimas tyrimui - šiukšlių surinkimas");
		Ks.oun("3 - Rūšiavimas sisteminiu greitu būdu be Comparator");
		Ks.oun("4 - Rūšiavimas sisteminiu greitu būdu su Comparator");
		Ks.oun("5 - Rūšiavimas List burbuliuku be Comparator");
		Ks.oun("6 - Rūšiavimas List burbuliuku su Comparator");
                Ks.oun("7 - Rūšiavimas List minMax su Comparator");
		Ks.ouf("%6d %7d %7d %7d %7d %7d %7d %7d\n", 0, 1, 2, 3, 4, 5, 6, 7);
		for (int n : tiriamiKiekiai) {
			paprastasTyrimas(n);
		}
		Ks.oun("Rikiavimo metodų greitaveikos tyrimas baigtas.");
		
		// Čia gali būti ir kitokio tyrimo metodo (jūsų sugalvoto) iškvietimas.
	}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        		Locale.setDefault(new Locale("LT"));
		new greitaveika().tyrimoPasirinkimas();
    }
    
}
