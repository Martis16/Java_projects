package laborai.studijos.ktu;

/**
 * Interfeisu aprašomas Aibės ADT.
 *
 * @param <E> Aibės elemento duomenų tipas
 */
public interface SetADT<E> extends Iterable<E> {

    //Patikrinama ar aibė tuščia.
    boolean isEmpty();

    // Grąžinamas aibėje esančių elementų kiekis.
    int size();

    // Išvaloma aibė.
    void clear();

    // Aibė papildoma nauju elementu.
    void add(E element);

    // Pašalinamas elementas iš aibės.
    void remove(E element);

    // Patikrinama ar elementas egzistuoja aibėje.
    boolean contains(E element);

    // Grąžinamas aibės elementų masyvas.
    Object[] toArray();
}
