/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab2Burneika;

import java.util.Iterator;
import studijosKTU.*;
/**
 *
 * @author Martynas
 */
public class Metodai {
    
    public ListKTUx<Player> visiZaid = new ListKTUx<>(new Player());
    private static final Player Zaidejas = new Player();
    
    public ListKTUx<Player> atrinktiPagalUgi(int riba1, int riba2) {
	ListKTUx<Player> vidutiniaiZaidejai = new ListKTUx(Zaidejas);
	for (Player a : visiZaid) {
		if (a.getUgis() >= riba1 && a.getUgis() <= riba2) {
                                                vidutiniaiZaidejai.add(a);
		}
	}
	return vidutiniaiZaidejai;
    }
    public ListKTUx<Player> atrinktiPagalMetus(int metai1, int metai2) {
	ListKTUx<Player> ZaidejaiPagalMetus = new ListKTUx(Zaidejas);
	for (Player f : visiZaid) {
		if (f.getMetai() >= metai1 && f.getMetai() <= metai2) {
			ZaidejaiPagalMetus.add(f);
		}
	}
	return ZaidejaiPagalMetus;
    }
    public ListKTUx<Player> atrinktiPagalNaudingumoBala(double Balas) {
	ListKTUx<Player> ZaidejaiPagalBala = new ListKTUx(Zaidejas);
	for (Player f : visiZaid) {
		if (f.getNaudBal() > Balas) {
			ZaidejaiPagalBala.add(f);
		}
	}
	return ZaidejaiPagalBala;
    }
}
