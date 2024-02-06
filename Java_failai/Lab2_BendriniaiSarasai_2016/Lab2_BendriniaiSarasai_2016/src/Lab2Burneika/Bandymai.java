/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Lab2Burneika;


import java.util.Locale;
import studijosKTU.*;
/**
 *
 * @author Martynas
 */
public class Bandymai {

    
    	ListKTUx<Player> bandomieji = new ListKTUx<>(new Player());

	ListKTU<Player> kopija; // klonavimo metodo clone testui

	void metodoParinkimas() {
//		tikrintiAtskirusZaidejus();
		formuotiZaidejuSąrašą();
//		peržiūrėtiSąrašą();
//        papildytiSąrašą();
//        patikrintiRikiavimą();
	}
        
        	void tikrintiAtskirusZaidejus() {
		Player a1 = new Player("Cristiano", "Ronaldo", 1985, 185, 80, 9);
		Player a2 = new Player("Lionel", "Messi", 1987, 172, 68, 10);
		Player a3 = new Player("Erling", "Halland", 1998, 189, 88, 8.9);


		Ks.oun(a1);
		Ks.oun(a2);
		Ks.oun(a3);
		Ks.oun("Pirmų 3 auto Ugio vidurkis= "
				+ (a1.getUgis() + a2.getUgis() + a3.getUgis()) / 3);
	}

	void formuotiZaidejuSąrašą() {
		// Kartu patikrina ir clone metodo veikimą
		Player a1 = new Player("Cristiano", "Ronaldo", 1985, 185, 80, 9);
		Player a2 = new Player("Lionel", "Messi", 1987, 172, 68, 10);
		Player a3 = new Player("Erling", "Halland", 1998, 189, 88, 8.9);
		bandomieji.add(a1);
		bandomieji.add(a2);
		bandomieji.add(a3);
		bandomieji.println("Pirmi 3 Zaidejai");

		kopija = bandomieji.clone(); // Kitas sąrašas - pirmų trijų automobilių kopija

		// Papildome sąrašą bandomisji dar trimis aotomobiliais (sąrašas kopija nesikeis):
                                        Player a4 = new Player("Romelu", "Lukaku", 1994, 190, 90, 8.4);
		Player a5 = new Player("Sergio", "Ramos", 1987, 188, 78, 7.9);
		Player a6 = new Player("Kevin", "De Bruyne", 1998, 189, 88, 8.9);
		bandomieji.add(a4);
		bandomieji.add(a5);
		bandomieji.add(a6);
                                        bandomieji.println("Pradinis sarasas");
                                        bandomieji.set(1, a6);
                                        if(bandomieji.contains(a5))
                                            Ks.oun( "ZAIDEJAS priklauso sarasui");
                                        int m = bandomieji.indexOf(a3);                                       
                                        Ks.oun(m);
                                        
		bandomieji.println("Visi 6 Zaidejai");
                                        bandomieji.remove(4);
                                        bandomieji.println("Zaidejai po pasalinimo");
                                        

		Ks.oun("Kopijos elementai");
		for (Player a : kopija) {
			Ks.oun(a);
		}
		Ks.oun("Kopijos elementai su nuoroda ::");
		kopija.forEach(System.out::println); // Galima "mandriau" - su nuoroda ::

		Ks.oun("\nPirmų 3 Zaideju ugio vidurkis= "
				+ (bandomieji.get(0).getUgis() + bandomieji.get(1).getUgis()
				+ bandomieji.get(2).getUgis()) / 3);
                bandomieji.save("band.txt");

	}
        
        

	void peržiūrėtiSąrašą() {
		int sk = 0;
		for (Player a : bandomieji) {
			if (a.getVardas().compareTo("Cristiano") == 0) {
				sk++;
			}
		}
		Ks.oun("Cristiano Ronaldo yra = " + sk);

		// Kopijos testas:
		sk = 0;
		for (Player a : kopija) {
			if (a.getVardas().compareTo("Cristiano") == 0) {
				sk++;
			}
		}
		Ks.oun("Kopijoje Cristiano Ronaldo yra = " + sk);
	}

	void papildytiSąrašą() {
		for (int i = 0; i < 8; i++) {
			bandomieji.add(new Player("Cristiano", "Ronaldo",
					1990 - i, 180 + i, 90 - i, 10-0.5*i));
		}
		bandomieji.println("Testuojamų Zaideju sąrašas");
		bandomieji.save("ban.txt");
	}



	void patikrintiRikiavimą() {
		                
                                        Player a1 = new Player("Cristiano", "Ronaldo", 1985, 185, 80, 9);
		Player a2 = new Player("Lionel", "Messi", 1987, 172, 68, 10);
		Player a3 = new Player("Erling", "Halland", 1998, 189, 88, 8.9);
		bandomieji.add(a1);
		bandomieji.add(a2);
		bandomieji.add(a3);
		bandomieji.println("Bandomasis rinkinys");
		bandomieji.sortBuble(Player.pagalVardą);
		bandomieji.println("Rūšiavimas pagal Varda");
                                        bandomieji.sortBuble(Player. pagalMetusBalą);
		bandomieji.println("Rūšiavimas pagal Metus ir bala");
                                        bandomieji.sortBuble(Player.pagalUgi );
		bandomieji.println(" Rūšiavimas pagal Ugi");
	}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        		Locale.setDefault(new Locale("LT"));
		new Bandymai().metodoParinkimas();
    }
    
}
