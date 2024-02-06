package laborai.demo;

import laborai.studijos.ktu.BstSetKTU;
import laborai.studijos.ktu.SetADT;

public class AutoApskaita {

    public static SetADT<String> automobiliuMarkes(Automobilis[] auto) {
        SetADT<Automobilis> uni = new BstSetKTU<>(Automobilis.pagalMarke);
        SetADT<String> kart = new BstSetKTU<>();
        for (Automobilis a : auto) {
            int sizeBefore = uni.size();
            uni.add(a);

            if (sizeBefore == uni.size()) {
                kart.add(a.getMarkė());
            }
        }
        return kart;
    }
}
