/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Lab2Burneika;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;
import studijosKTU.*;
/**
 *
 * @author Martynas
 */
public class Player implements KTUable<Player> {
    
    final static private int priimtinųMetųRiba = 1975;
    final static private int esamiMetai = LocalDate.now().getYear();
    
    final static private double minNaudBal = 5;
    
    
    private String vardas;
    private String pavarde;
    private int metai;
    private double ugis;
    private double svoris;
    private double NaudBal;

    public Player() {
    }
    
    public Player(String vardas, String pavarde, int metai, double ugis, double svoris, double NaudBal) {
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.metai = metai;
        this.ugis = ugis;
        this.svoris =svoris;
        this.NaudBal = NaudBal;
    }
    
    public Player(String dataString) {
            this.parse(dataString);
    }
    
    @Override
    public Player create(String dataString) {
	return new Player(dataString);

    }
    
    @Override
    public final void parse(String dataString) {
	try {   
		Scanner ed = new Scanner(dataString);
		ed.useDelimiter(";"); 
		vardas = ed.next();
		pavarde = ed.next();
		metai = ed.nextInt();
		ugis = ed.nextDouble();
		svoris = ed.nextDouble();
                                        NaudBal = ed.nextDouble();
	} catch (InputMismatchException e) {
		Ks.ern("Blogas duomenų formatas apie žaidėja -> " + dataString);
	} catch (NoSuchElementException e) {
		Ks.ern("Trūksta duomenų apie žaidėja -> " + dataString);
	}
    }
    
    @Override
    public String toString() {  // surenkama visa reikalinga informacija
	return String.format("%-8s %-8s %4d%8.1f %8.1f %8.1f %s",
	vardas, pavarde, metai, ugis, svoris, NaudBal, validate());
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
    public double getUgis(){
        return ugis;
        
    }
    public double getSvoris(){
        return svoris;
        
    }
    public double getNaudBal(){
        return NaudBal;
    }
    @Override
    public int compareTo(Player a) {
	// lyginame pagal svarbiausią požymį - ugį
	double ugisKitas = a.getUgis();
	return Double.compare(ugisKitas, ugis);
    }
    
    
    public final static Comparator<Player> pagalVardą = new Comparator<Player>() {
	@Override
	public int compare(Player a1, Player a2) {
		int cmp = a1.getVardas().compareTo(a2.getVardas());
		return cmp;
	}
    };

    public final static Comparator pagalMetusBalą = new Comparator() {
       @Override
       public int compare(Object o1, Object o2) {
            Player a1 = (Player) o1;
            Player a2 = (Player) o2;
            if(a1.getMetai() < a2.getMetai()) return 1;
            if(a1.getMetai() > a2.getMetai()) return -1;
            if(a1.getNaudBal() < a2.getNaudBal()) return 1;
            if(a1.getNaudBal() > a2.getNaudBal()) return -1;
            return 0;
          }
    };
                public final static Comparator<Player > pagalUgi 
                = new Comparator<Player >() {
		@Override
		public int compare(Player  f1, Player  f2) {
                    double pirmas = f1.getUgis();
                    double antras = f2.getUgis();
                    
                      if (pirmas > antras)
                        return -1;
                    else if (pirmas < antras)
                        return 1;
                    else
                        return 0;
		}
                };
    
    @Override
    public String validate() {
	String klaidosTipas = "";
	if (metai < priimtinųMetųRiba || metai > esamiMetai) {
		klaidosTipas = "Netinkami žaidėjo metai, turi būti ["
				+ priimtinųMetųRiba + ":" + esamiMetai + "]";
	}
	if (NaudBal < minNaudBal) {
		klaidosTipas += " Per mažas naudingumo balas [" + minNaudBal + "]";
	}
	return klaidosTipas;
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
