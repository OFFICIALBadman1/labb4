package l10.selection;

import java.util.Arrays;

/**
 * @author Håkan Jonsson
 */
public class SortedSequenceLinkedSelection<E extends Comparable<E>>
        implements SortedSequenceSelectionADT<E> {

    private Node start = new Node();

    private class Node {
        E element;
        Node next = null;
    }

    public SortedSequenceLinkedSelection(E[] array) {
        for (E e : array) {
            this.insert(e);
        }
    }

    @Override
    public boolean isEmpty() {
        return start.next == null;
    }

    @Override
    public void insert(E element) {
        Node newNode = new Node();
        newNode.element = element;
        newNode.next = start.next;
        start.next = newNode;
    }

    @Override
    public E extract() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        Node ptr = start;  // pre-pointer
        Node best = start; // pre-pointer
        while (ptr.next != null) {
            if (ptr.next.element.compareTo(best.next.element) < 0) {
                best = ptr;
            }
            ptr = ptr.next;
        }
        E element = best.next.element;
        best.next = best.next.next;
        return element;
    }

    public String toString() {
        String result = "";
        Node p = start;
        while (p.next != null) {
            result += p.next.element + " ";
            p = p.next;
        }
        return result;
    }

    public static void main(String[] args) {

        Integer[] ints = { 3, 5, 4, 1, 2, 6, 7 };
        System.out.println(Arrays.toString(ints));

        SortedSequenceLinkedSelection<Integer> intseq 
        = new SortedSequenceLinkedSelection<>(ints);
        System.out.println(intseq);

        while (!intseq.isEmpty()) {
            System.out.print(intseq.extract() + " ");
        }
        System.out.println();
    }
}
