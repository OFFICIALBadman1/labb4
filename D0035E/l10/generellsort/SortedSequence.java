package l10.generellsort;

import java.util.ArrayList;


/* 
 * Håkan Jonsson, LTU
 */
public class SortedSequence<E extends Comparable<E>>
        implements SortedSequenceADT<E> {
    public static final int MAX = 20;
    private ArrayList<E> values = new ArrayList<E>();
    private int size = 0;

    @Override
    public void insert(E n) {
        if (isFull()) {
            throw new RuntimeException(
                    "max already reached (size=" + this.size + ")");
        }
        values.add(this.size(), n);
        this.size = this.size + 1;
        for (int i = this.size - 2; i >= 0; i--) {
            if (values.get(i).compareTo(n) > 0) {
                E tmp = values.get(i); // swap ints[i] and ints[i+1]
                values.set(i, values.get(i + 1));
                values.set(i + 1, tmp);
            } else {
                break; // found the right position
            }
        }
    }

    @Override
    public E getLowest() {
        if (this.size() == 0) {
            throw new RuntimeException();
        }
        E answer = values.get(0);
        for (int i = 0; i < this.size() - 1; i++) {
            values.set(i, values.get(i + 1));
        }
        values.set(size - 1, null); // not needed
        this.size = this.size - 1;
        return answer;
    }

    public ArrayList<E> getArrayList() {
        ArrayList<E> other = new ArrayList<E>();
        for (int i = 0; i < this.size(); i++) {
            other.add(values.get(i));
        }
        return other;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int maxSize() {
        return MAX;
    }

    public void print() {
        System.out.println("size=" + this.size());
        System.out.println(values);
    }
}
