/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Lab3Burneika;

/**
 *
 * @author Martynas
 */
import laborai.studijos.ktu.Ks;
import laborai.studijos.ktu.AvlSetKTUx;
import laborai.studijos.ktu.SortedSetADTx;
import laborai.studijos.ktu.SetADT;
import laborai.studijos.ktu.BstSetKTUx;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import laborai.studijos.ktu.BstSetKTU;


/*
 * Aibes testavimas be Swing'o
 *
 */
public class PlayerTestai {

    static Player[] playerBaze;
    static SortedSetADTx<Player> aSerija = new BstSetKTUx(new Player(), Player.pagalUgi);

    public static void main(String[] args) throws CloneNotSupportedException {
        Locale.setDefault(Locale.US); // Suvienodiname skaiciu formatus
        aibesTestas();
    }

    static SortedSetADTx generuotiAibe(int kiekis, int generN) {
        playerBaze = new Player[generN];
        for (int i = 0; i < generN; i++) {
            playerBaze[i] = new Player.Builder().buildRandom();
        }
        Collections.shuffle(Arrays.asList(playerBaze));
        aSerija.clear();
        for (int i = 0; i < kiekis; i++) {
            aSerija.add(playerBaze[i]);
        }
        return aSerija;
    }
    


    public static void aibesTestas() throws CloneNotSupportedException {
        Player a1 = new Player("Gabriel", "Jesus", 1995, 171, 75, 8);
        Player a2 = new Player.Builder()
                .vardas("Lionel")
                .pavarde("messi")
                .metai(1988)
                .ugis(170)
                .svoris(65)
                .naudbal(5)
                .build();
        Player a3 = new Player.Builder().buildRandom();
        Player a4 = new Player("Cristiano Ronaldo 1985 180 80 9.5");                        
        Player a5 = new Player("Lionel Messi 1987 170 70 9.5");
        Player a6 = new Player("Christian Eriksen 1988 182 81 7.5");
        Player a7 = new Player("Kyllian Mbappe 1998 185 80 9.5");
        Player a8 = new Player("Romelu Lukaku 1992 189 86 7.3");
        Player a9 = new Player("Karim Benzema 1986 184 82 8.8");

        Player[] zaidMasyvas = {a9, a7, a8, a5, a1, a6};

        Ks.oun("Zaideju Aibe:");
        SortedSetADTx<Player> zaidAibe = new BstSetKTUx(new Player());
        
        

        for (Player a : zaidMasyvas) {
            zaidAibe.add(a);
            
            Ks.oun("Aibe papildoma: " + a + ". Jos dydis: " + zaidAibe.size());
        }
//        Ks.oun("");
//        Ks.oun(zaidAibe.toVisualizedString(""));

        SortedSetADTx<Player> zaidAibeKopija
                = (SortedSetADTx<Player>) zaidAibe.clone();

              

        
        zaidAibeKopija.add(a2);
        zaidAibeKopija.add(a3);
        zaidAibeKopija.add(a4);
        Ks.oun("Papildyta autoaibes kopija:");
        Ks.oun(zaidAibeKopija.toVisualizedString(""));

       

//        Ks.oun("Originalas:");
//        Ks.ounn(zaidAibe.toVisualizedString(""));

        Ks.oun("Ar elementai egzistuoja aibeje?");
        for (Player a : zaidMasyvas) {
            Ks.oun(a + ": " + zaidAibe.contains(a));
        }
        Ks.oun(a2 + ": " + zaidAibe.contains(a2));
        Ks.oun(a3 + ": " + zaidAibe.contains(a3));
        Ks.oun(a4 + ": " + zaidAibe.contains(a4));
        Ks.oun("");
        

        Ks.oun("Ar elementai egzistuoja aibes kopijoje?");
        for (Player a : zaidMasyvas) {
            Ks.oun(a + ": " + zaidAibeKopija.contains(a));
        }
        Ks.oun(a2 + ": " + zaidAibeKopija.contains(a2));
        Ks.oun(a3 + ": " + zaidAibeKopija.contains(a3));
        Ks.oun(a4 + ": " + zaidAibeKopija.contains(a4));
        Ks.oun("");

        Ks.oun("Elementu salinimas is kopijos. Aibes dydis pries salinima:  " + zaidAibeKopija.size());
        for (Player a : new Player[]{a2, a1, a9, a8, a5, a3, a4, a2, a7, a6, a7, a9}) {
            zaidAibeKopija.remove(a);
            Ks.oun("Is autoaibes kopijos pasalinama: " + a + ". Jos dydis: " + zaidAibeKopija.size());
        }
        Ks.oun("");

        Ks.oun("Automobiliu aibe su iteratoriumi:");
        Ks.oun("");
        for (Player a : zaidAibe) {
            Ks.oun(a);
        }
        
        Ks.oun("\nAibes poaibis" +"\nIvestas zaidejas = " +a6+"\n\n"+ zaidAibe.headSet(a6));
        
        
        Ks.oun("\n\n"+"Aibes aukstis = "+zaidAibe.height()+"\n\n");
        
        zaidAibe.add(a4);
        
        
        Ks.oun("\nAibe po iterpimo:");
        for(Player a: zaidAibe){
            Ks.oun(a);
        }
//        Ks.oun("");
//        Ks.oun("Automobiliu aibe AVL-medyje:");
//        SortedSetADTx<Player> zaidAibe3 = new AvlSetKTUx(new Player());
//        for (Player a : zaidMasyvas) {
//            zaidAibe3.add(a);
//        }
//        Ks.ounn(zaidAibe3.toVisualizedString(""));
//
//        Ks.oun("Automobiliu aibe su iteratoriumi:");
//        Ks.oun("");
//        for (Player a : zaidAibe3) {
//            Ks.oun(a);
//        }
//
//        Ks.oun("");
//        Ks.oun("Automobiliu aibe su atvirkstiniu iteratoriumi:");
//        Ks.oun("");
//        Iterator iter = zaidAibe3.descendingIterator();
//        while (iter.hasNext()) {
//            Ks.oun(iter.next());
//        }
//
//        Ks.oun("");
//        Ks.oun("Automobiliu aibes toString() metodas:");
//        Ks.ounn(zaidAibe3);
//
//        // Isvalome ir suformuojame aibes skaitydami is failo
//        zaidAibe.clear();
//        zaidAibe3.clear();
//
//        Ks.oun("");
//        Ks.oun("Automobiliu aibe DP-medyje:");
//        zaidAibe.load("Duomenys\\ban.txt");
//        Ks.ounn(zaidAibe.toVisualizedString(""));
//        Ks.oun("Issiaiskinkite, kodel medis augo tik i viena puse.");
//
//        Ks.oun("");
//        Ks.oun("Automobiliu aibe AVL-medyje:");
//        zaidAibe3.load("Duomenys\\ban.txt");
//        Ks.ounn(zaidAibe3.toVisualizedString(""));
//
//        SetADT<String> zaidAibe4 =PlayerApskaita.PlayerNamesz(zaidMasyvas);
//        Ks.oun("Pasikartojancios automobiliu vardass:\n" + zaidAibe4.toString());
    }
}
