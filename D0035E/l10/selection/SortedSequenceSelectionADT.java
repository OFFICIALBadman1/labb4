package l10.selection;

/**
 * @author Håkan Jonsson
 */
public interface SortedSequenceSelectionADT<E extends Comparable<E>> {

    public boolean isEmpty();

    public void insert(E element);

    public E extract();

}
