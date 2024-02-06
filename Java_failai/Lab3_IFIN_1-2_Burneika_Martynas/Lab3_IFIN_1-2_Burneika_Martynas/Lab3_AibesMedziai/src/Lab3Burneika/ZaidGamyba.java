package Lab3Burneika;


import laborai.gui.MyException;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class ZaidGamyba {

    private static Player[] zaid;
    private static int pradinisIndeksas = 0, galinisIndeksas = 0;
    private static boolean arPradzia = true;

    public static Player[] generuoti(int kiekis) {
        zaid = new Player[kiekis];
        for (int i = 0; i < kiekis; i++) {
            zaid[i] = new Player.Builder().buildRandom();
        }
        return zaid;
    }

    public static Player[] generuotiIrIsmaisyti(int aibesDydis,
            double isbarstymoKoeficientas) throws MyException {
        return generuotiIrIsmaisyti(aibesDydis, aibesDydis, isbarstymoKoeficientas);
    }

    /**
     *
     * @param aibesDydis
     * @param aibesImtis
     * @param isbarstymoKoeficientas
     * @return Gražinamas aibesImtis ilgio masyvas
     * @throws MyException
     */
    public static Player[] generuotiIrIsmaisyti(int aibesDydis,
            int aibesImtis, double isbarstymoKoeficientas) throws MyException {
        zaid = generuoti(aibesDydis);
        return ismaisyti(zaid, aibesImtis, isbarstymoKoeficientas);
    }

    // Galima paduoti masyvą išmaišymui iš išorės
    public static Player[] ismaisyti(Player[] autoBaze,
            int kiekis, double isbarstKoef) throws MyException {
        if (autoBaze == null) {
            throw new IllegalArgumentException("AutoBaze yra null");
        }
        if (kiekis <= 0) {
            throw new MyException(String.valueOf(kiekis), 1);
        }
        if (autoBaze.length < kiekis) {
            throw new MyException(autoBaze.length + " >= " + kiekis, 2);
        }
        if ((isbarstKoef < 0) || (isbarstKoef > 1)) {
            throw new MyException(String.valueOf(isbarstKoef), 3);
        }

        int likusiuKiekis = autoBaze.length - kiekis;
        int pradziosIndeksas = (int) (likusiuKiekis * isbarstKoef / 2);

        Player[] pradineAutomobiliuImtis = Arrays.copyOfRange(autoBaze, pradziosIndeksas, pradziosIndeksas + kiekis);
        Player[] likusiAutomobiliuImtis = Stream
                .concat(Arrays.stream(Arrays.copyOfRange(autoBaze, 0, pradziosIndeksas)),
                        Arrays.stream(Arrays.copyOfRange(autoBaze, pradziosIndeksas + kiekis, autoBaze.length)))
                .toArray(Player[]::new);

        Collections.shuffle(Arrays.asList(pradineAutomobiliuImtis)
                .subList(0, (int) (pradineAutomobiliuImtis.length * isbarstKoef)));
        Collections.shuffle(Arrays.asList(likusiAutomobiliuImtis)
                .subList(0, (int) (likusiAutomobiliuImtis.length * isbarstKoef)));

        ZaidGamyba.pradinisIndeksas = 0;
        galinisIndeksas = likusiAutomobiliuImtis.length - 1;
        ZaidGamyba.zaid = likusiAutomobiliuImtis;
        return pradineAutomobiliuImtis;
    }

    public static Player gautiIsBazes() throws MyException {
        if ((galinisIndeksas - pradinisIndeksas) < 0) {
            throw new MyException(String.valueOf(galinisIndeksas - pradinisIndeksas), 4);
        }
        // Vieną kartą Player imamas iš masyvo pradžios, kitą kartą - iš galo.     
        arPradzia = !arPradzia;
        return zaid[arPradzia ? pradinisIndeksas++ : galinisIndeksas--];
    }
}
