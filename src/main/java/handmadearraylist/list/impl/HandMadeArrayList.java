package handmadearraylist.list.impl;

import handmadearraylist.list.HandMadeList;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class HandMadeArrayList<T extends Comparable<T>> implements HandMadeList<T> {
    private int size = 0;
    private Object[] elements;
    private static final int DEFAULT_CAPACITY = 10;

    public HandMadeArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T newElement) {
        if (size == elements.length) {
            grow();
        }
        elements[size] = newElement;
        size += 1;
    }

    @Override
    public void add(int index, T newElement) {
        if (size == elements.length) {
            grow();
        }
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = newElement;
        size += 1;
    }

    @Override
    public Object set(int index, T element) {
        Objects.checkIndex(index, size);
        Object oldValue = elements[index];
        elements[index] = element;
        return oldValue;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Element with index " + index + " does not exist");
        }
        return (T) this.elements[index];
    }

    @Override
    public void clear() {
        final Object[] es = elements;
        for (int to = size, i = size = 0; i < to; i++) {
            es[i] = null;
        }
    }

    @Override
    public boolean remove(Object o) {
        if (!contains(o)) {
            return false;
        } else {
            final Object[] es = elements;
            final int index = indexOf(o);
            final int newSize;
            if ((newSize = size - 1) > index) {
                System.arraycopy(es, index + 1, es, index, newSize - index);
            }
            es[size = newSize] = null;
            return true;
        }
    }

    private Iterator<T> iterator() {
        return new Iterator<T>() {
            int next;
            int lastRet = -1;

            @Override
            public boolean hasNext() {
                return next != size;
            }

            @Override
            public T next() {
                int i = next;
                if (next == size) {
                    throw new NoSuchElementException();
                }
                next = i + 1;
                return (T) elements[lastRet = i];
            }
        };
    }

    @Override
    public boolean contains(Object o) {
        Iterator<T> it = iterator();
        if (o == null) {
            while (it.hasNext()) {
                if (it.next() == null) {
                    return true;
                }
            }
        } else {
            while (it.hasNext()) {
                if (o.equals(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object o) {
        if (contains(o)) {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    private void grow() {
        Object[] newArray = new Object[elements.length + elements.length / 2];
        for (int i = 0; i < elements.length; i++) {
            newArray[i] = elements[i];
        }
        this.elements = newArray;
    }

    @Override
    public void quickSort(int from, int to) {
        if (from < to) {
            int divideIndex = partition(from, to);
            quickSort(from, divideIndex - 1);
            quickSort(divideIndex, to);
        }
    }

    private int partition(int from, int to) {
        T pivot = get(to);
        int i = from - 1;

        for (int j = from; j < to; j++) {
            if (get(j).compareTo(pivot) <= 0) {
                i++;
                swap(i, j);
            }
        }

        swap(i + 1, to);
        return i + 1;
    }

    private void swap(int i, int j) {
        T temp = get(i);
        set(i, get(j));
        set(j, temp);
    }

    @Override
    public String toString() {
        if (elements == null) {
            return "null";
        }
        int iMax = elements.length - 1;
        if (iMax == -1) {
            return "[]";
        }
        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(elements[i]);
            if (i == iMax) {
                return b.append(']').toString();
            }
            b.append(", ");
        }
    }
}

