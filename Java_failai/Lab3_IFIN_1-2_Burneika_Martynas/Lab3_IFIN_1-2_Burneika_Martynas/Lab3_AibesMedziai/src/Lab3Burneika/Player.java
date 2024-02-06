/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab3Burneika;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;
import laborai.studijos.ktu.KTUable;
import laborai.studijos.ktu.Ks;

/**
 *
 * @author Martynas
 */
public class Player implements KTUable<Player> {
    
    final static private int priimtinųMetųRiba = 1975;
    final static private int esamiMetai = LocalDate.now().getYear();  
    final static private double minNaudBal = 5;
    private static int Nmbr = 100; 
    private static final String Nr = "Nr";
    private final String MarskineliuNr;
    private String vardas;
    private String pavarde;
    private int metai;
    private double ugis;
    private double svoris;
    private double NaudBal;

    public Player() {
        MarskineliuNr = Nr+(Nmbr++);
    }
    
    public Player(String vardas, String pavarde, int metai, double ugis, double svoris, double NaudBal) {
        MarskineliuNr = Nr+(Nmbr++);
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.metai = metai;
        this.ugis = ugis;
        this.svoris =svoris;
        this.NaudBal = NaudBal;
    }
    
    public Player(String dataString) {
            MarskineliuNr = Nr+(Nmbr++);
            this.parse(dataString);
    }
    
        public Player(Player.Builder builder) {
            MarskineliuNr = Nr+(Nmbr++);
        this.vardas = builder.vardas;
        this.pavarde = builder.pavarde;
        this.metai = builder.metai;
        this.ugis = builder.ugis;
        this.svoris = builder.svoris;
        this.NaudBal =builder. NaudBal;
        validate();
    }
    
    @Override
    public Player create(String dataString) {
	return new Player(dataString);

    }
    
    @Override
    public final void parse(String dataString) {
	try {   
		Scanner ed = new Scanner(dataString);
		vardas = ed.next();
		pavarde = ed.next();
		metai = ed.nextInt();
		ugis = ed.nextDouble();
		svoris = ed.nextDouble();
                                        NaudBal = ed.nextDouble();
	} catch (InputMismatchException e) {
		Ks.ern("Blogas duomenų formatas apie žaidėja -> " + dataString);
	} catch (NoSuchElementException e) {
		Ks.ern("Truksta duomenu apie zaideja -> " + dataString);
	}
    }
    
    @Override
    public String toString() {  // surenkama visa reikalinga informacija
	return String.format("%-8s %-8s %-8s %4d%8.1f %8.1f %8.1f %s", getMarskNr(),
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
    public String getMarskNr() {  
        return MarskineliuNr;
    }
    @Override
    public int compareTo(Player a) {
        return getMarskNr().compareTo(a.getMarskNr());
    }

    public static Comparator<Player> pagalVarda = (Player a1, Player a2) -> a1.vardas.compareTo(a2.vardas); // pradžioje pagal markes, o po to pagal modelius

    public static Comparator<Player> pagalugi = (Player a1, Player a2) -> {
        // didėjanti tvarka, pradedant nuo mažiausios
        if (a1.ugis < a2.ugis) {
            return -1;
        }
        if (a1.ugis > a2.ugis) {
            return +1;
        }
        return 0;
    };

    public final static Comparator pagalMetusBalą = (Comparator) (Object o1, Object o2) -> {
        Player a1 = (Player) o1;
        Player a2 = (Player) o2;
        if(a1.getMetai() < a2.getMetai()) return 1;
        if(a1.getMetai() > a2.getMetai()) return -1;
        if(a1.getNaudBal() < a2.getNaudBal()) return 1;
        if(a1.getNaudBal() > a2.getNaudBal()) return -1;
        return 0;
    };
                public final static Comparator<Player > pagalUgi 
                = (Player  f1, Player  f2) -> {
                    double pirmas = f1.getUgis();
                    double antras = f2.getUgis();
                    
                    if (pirmas > antras)
                        return -1;
                    else if (pirmas < antras)
                        return 1;
                    else
                        return 0;
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
    
    public static class Builder {

        private final static Random RANDOM = new Random(1949);  // Atsitiktinių generatorius
//        private final static String[][] MODELIAI = { // galimų automobilių markių ir jų modelių masyvas
//            {"Mazda", "121", "323", "626", "MX6"},
//            {"Ford", "Fiesta", "Escort", "Focus", "Sierra", "Mondeo"},
//            {"Saab", "92", "96"},
//            {"Honda", "Accord", "Civic", "Jazz"},
//            {"Renault", "Laguna", "Megane", "Twingo", "Scenic"},
//            {"Peugeot", "206", "207", "307"}
//        };                        
        private final static String[][] MODELIAI = {
                        {"Cristiano", "Ronaldo"},
                        {"Lionel", "Messi"},
                        {"Christian", "Eriksen"},
                        {"Kyllian", "Mbappe"},
                        {"Romelu", "Lukaku"},
                        {"Karim", "Benzema"},};

        private String vardas = "";
        private String pavarde= "";
        private int metai = -1;
        private double ugis = -1.0;
        private double svoris = -1.0;
        private double NaudBal  = -1.0;

        public Player build() {
            return new Player(this);
        }

        public Player buildRandom() {
            int ma = RANDOM.nextInt(MODELIAI.length);        // vardass indeksas  0..
            int mo = RANDOM.nextInt(MODELIAI[ma].length - 1) + 1;// modelio indeksas 1..              
            return new Player(MODELIAI[ma][0],
                    MODELIAI[ma][mo],
                    1970 + RANDOM.nextInt(30),// metai tarp 1990 ir 2009
                    160 + RANDOM.nextDouble(30),// ugis tarp 6000 ir 228000
                    60 + RANDOM.nextDouble(24),// svoris tarp 800 ir 88800
                     5 + RANDOM.nextDouble(5));
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

        public Builder ugis(double ugis) {
            this.ugis = ugis;
            return this;
        }

        public Builder svoris(double svoris) {
            this.svoris = svoris;
            return this;
        }
         public Builder naudbal(double naudbal) {
            this.NaudBal = naudbal;
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
