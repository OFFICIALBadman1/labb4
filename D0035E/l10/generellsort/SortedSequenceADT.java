package l10.generellsort;

import java.util.ArrayList;

/* 
 * Håkan Jonsson, LTU
 */
public interface SortedSequenceADT<E extends Comparable<E>> {

    public void insert(E n);

    default void insertArrayList(ArrayList<E> ia) {
        for (int i = 0; i < ia.size(); i++) {
            insert(ia.get(i));
        }
    }

    public E getLowest();

    public ArrayList<E> getArrayList();

    public int size();

    public int maxSize();

    public void print();

    default boolean isFull() {
        return size() == maxSize();
    }
}
