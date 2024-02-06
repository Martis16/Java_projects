/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab4burn;

import java.util.Locale;

/**
 *
 * @author Martynas
 */
public class VykdymoModulis {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("LT")); // Suvienodiname skaičių formatus
        PlayerTestai.mapTest();
        Lab4Window.createAndShowGUI();
    }
}
