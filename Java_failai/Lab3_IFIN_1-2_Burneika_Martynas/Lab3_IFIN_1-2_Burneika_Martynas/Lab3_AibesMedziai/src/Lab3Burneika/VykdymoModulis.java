package Lab3Burneika;

import laborai.gui.swing.Lab3Window;
import java.util.Locale;

/*
 * Darbo atlikimo tvarka - čia yra pradinė klasė.
 */
public class VykdymoModulis {

    public static void main(String[] args) throws CloneNotSupportedException {
        Locale.setDefault(Locale.US); // Suvienodiname skaičių formatus
        PlayerTestai.aibesTestas();
        Lab3Window.createAndShowGUI();
    }
}
