/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab3Burneika;

/**
 *
 * @author Martynas
 */

import laborai.studijos.ktu.BstSetKTU;
import laborai.studijos.ktu.SetADT;

public class PlayerApskaita {

    public static SetADT<String> PlayerNamesz(Player[] Plr) {
        SetADT<Player> uni = new BstSetKTU<>(Player.pagalUgi);
        SetADT<String> kart = new BstSetKTU<>();
        for (Player a : Plr) {
            int sizeBefore = uni.size();
            uni.add(a);

            if (sizeBefore == uni.size()) {
                kart.add(a.getVardas());
            }
        }
        return kart;
    }
}
