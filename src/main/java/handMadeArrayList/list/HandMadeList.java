package handMadeArrayList.list;

import java.util.Iterator;

/**
 * Собственный вариант интерфейса List, в урезанном виде.
 *
 * @param <T>
 */

public interface HandMadeList<T> {

    int size();
    void add(T newElement);
    void add(int index, T newElement);
    Object set(int index, T element);
    T get(int index);

    void clear();

    boolean remove(Object o);

    boolean contains(Object o);

    int indexOf(Object o);

    void quickSort(int from, int to);
}
