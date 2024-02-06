/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab4burn;

import java.util.Locale;
import laborai.studijosktu.HashType;
import laborai.studijosktu.Ks;
import laborai.studijosktu.MapKTUx;

/**
 *
 * @author Martynas
 */
public class PlayerTestai {
    
    public static void main(String[] args) {
        Locale.setDefault(new Locale("LT")); // Suvienodiname skaičių formatus
        mapTest();
        //greitaveikosTestas();
    }
    
    
    public static void mapTest() {
        Player k1 = new Player("Cristiano", "ST", 50.23, "Ronaldo", 500, 2006);
        Player k2 = new Player("Hugo", "GK", 50.56, "Lloris", 550, 2007);
        Player k3 = new Player("Lionel", "LW", 50.78, "Messi", 600, 2008);
        Player k4 = new Player("Eden", "RW", 53.20, "Hazard", 420, 2009);
        Player k5 = new Player.Builder().buildRandom();
        Player k6 = new Player("Romelu", "ST", 35.30, "Lukaku", 305, 2010);
        Player k7 = new Player("Gabriel", "ST", 25.50, "Jesus", 150, 2011);
        Player k8 = new Player("Peter", "GK", 28.30, "Chech", 600, 2012);
        // Raktų masyvas
        String[] booksId = {"NR156", "NR102", "NR178", "NR171", "NR105", "NR106", "NR107", "NR108"};
        int id = 0;
        MapKTUx<String, Player> map
                = new MapKTUx(new String(), new Player(), HashType.DIVISION);
        // Reikšmių masyvas
        Player[] books = {k1, k2, k3, k4, k5, k6, k7};
        for (Player c : books) {
            map.put(booksId[id++], c);
        }
        map.println("Porų išsidėstymas atvaizdyje pagal raktus");
        Ks.oun("Ar egzistuoja pora atvaizdyje? " + booksId[6]);
        Ks.oun(map.contains(booksId[6]));
        Ks.oun("Ar egzistuoja pora atvaizdyje? " + booksId[7]);
        Ks.oun(map.contains(booksId[7]));
        Ks.oun("Pašalinamos poros iš atvaizdžio: " + booksId[1] + " ir " + booksId[7]);
        Ks.oun(map.remove(booksId[1]));
        Ks.oun(map.remove(booksId[7]));
        Ks.oun("Atvaizdžio papildymas pasirinkta pora: " + booksId[7] + " " + k8);
        map.put(booksId[7], k8);
        map.println("Porų išsidėstymas atvaizdyje pagal raktus");
        Ks.oun("Atliekame porų paiešką atvaizdyje: " + booksId[2] + " ir " + booksId[7]);
        Ks.oun(map.get(booksId[2]));
        Ks.oun(map.get(booksId[7]));
        Ks.oun("Išspausdiname atvaizdžio poras String eilute:");
        Ks.ounn(map);
    }
    
    //Konsoliniame režime
    private static void speedTest() {
        System.out.println("Greitaveikos tyrimas:\n");
        Greitaveika gt = new Greitaveika();
        //Šioje gijoje atliekamas greitaveikos tyrimas
        new Thread(() -> gt.pradetiTyrima(false),
                "Greitaveikos_tyrimo_gija").start();
        try {
            String result;
            while (!(result = gt.getResultsLogger().take())
                    .equals(Greitaveika.FINISH_COMMAND)) {
                System.out.println(result);
                gt.getSemaphore().release();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        gt.getSemaphore().release();
    }
    
}
