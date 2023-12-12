package l10.generellsort;

import java.util.ArrayList;
import java.util.Arrays;

public class SortedIntegerSequenceMain {

    public static void main(String[] args) {
        SortedSequence<Integer> s = new SortedSequence<Integer>();
        Integer[] ia = { 3, 6, 1, 4, 7, 10, 5, 8, 2, 9 };
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(ia));

        s.insertArrayList(list);
        s.print();
        s.getLowest();
        s.print();
        s.getLowest();
        s.print();
        ArrayList<Integer> ir = s.getArrayList();
        System.out.println(ir.toString());
    }
}
