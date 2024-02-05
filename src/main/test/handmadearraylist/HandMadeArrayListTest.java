package handmadearraylist;

import handmadearraylist.list.HandMadeList;
import handmadearraylist.list.impl.HandMadeArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HandMadeArrayListTest {

    private final HandMadeList<Integer> list = new HandMadeArrayList<>();


    @Test
    @DisplayName("Добавление элемента в список")
    void addToList_whenElementOnly() {
        final int e = 99;
        list.add(e);

        final int actualE = list.get(0);
        final int size = list.size();

        assertEquals(e, actualE);
        assertEquals(1, size);
    }

    @Test
    @DisplayName("Добавление элемента в список по индексу")
    void addToList_whenElementAndIndex() {
        final int e = 99;
        list.add(3);
        list.add(0, 99);

        final int actualE = list.get(0);
        final int size = list.size();

        assertEquals(e, actualE);
        assertEquals(2, size);
    }

    @Test
    @DisplayName("Добавление элемента в список по несуществующему индексу")
    void addToList_whenWrongIndex_thenThrowException() {
        final int e = 99;

        assertThrows(IndexOutOfBoundsException.class,
                () -> list.add(1, e));
    }

    @Test
    @DisplayName("Обновление элемента в списке по индексу")
    void setToList_whenElementAndIndex() {
        final int e = 99;
        list.add(3);
        list.set(0, 99);

        final int actualE = list.get(0);
        final int size = list.size();

        assertEquals(e, actualE);
        assertEquals(1, size);
    }

    @Test
    @DisplayName("Обновление элемента в списке по несуществующему индексу")
    void setToList_whenWrongIndex_thenThrowException() {
        final int e = 99;

        assertThrows(IndexOutOfBoundsException.class,
                () -> list.set(1, e));
    }

    @Test
    @DisplayName("Получение размера списка")
    void getSizeOfList_whenElementAdded() {
        list.add(99);

        final int size = list.size();

        assertEquals(1, size);
    }

    @Test
    @DisplayName("Получение элемента списка по индексу")
    void getElement_whenElementAdded() {
        final int e = 99;
        list.add(99);

        final int addedE = list.get(0);

        assertEquals(e, addedE);
    }

    @Test
    @DisplayName("Получение элемента списка по не верному индексу")
    void getElement_whenWrongIndex_thenThrowException() {
        list.add(99);

        assertThrows(IndexOutOfBoundsException.class,
                () -> list.get(1));
    }

    @Test
    @DisplayName("Проверка наличия элемента в списке")
    void checkExistingElementOnList_whenElementAdded() {
        final Integer e = 99;
        list.add(99);

        final boolean result = list.contains(e);

        assertTrue(result);
        assertFalse(list.contains(e + 1));
    }

    @Test
    @DisplayName("Очистка списка")
    void clearList_whenElementAdded() {
        final int e = 99;
        list.add(99);

        list.clear();

        assertFalse(list.contains(e));
        assertEquals(0, list.size());
    }

    @Test
    @DisplayName("Удаление элемента")
    void removeElement_whenElementAdded() {
        final int e = 99;
        list.add(99);

        final boolean result = list.remove(e);

        assertTrue(result);
        assertEquals(0, list.size());
    }

    @Test
    @DisplayName("Удаление элемента которого нет в списке")
    void removeElement_whenElementNotExist() {
        final int e = 99;
        final int anotherE = 9;
        list.add(e);

        final boolean result = list.remove(anotherE);

        assertFalse(result);
        assertEquals(1, list.size());
    }

    @Test
    @DisplayName("Получение индекса элемента")
    void getElementIndex_whenElementAdded() {
        final int e = 99;
        list.add(e);

        final int index = list.indexOf(e);

        assertEquals(0, index);
    }

    @Test
    @DisplayName("Получение индекса элемента которого нет в списке")
    void getElementIndex_whenElementNotAdded() {
        final int e = 99;
        final int anotherE = 9;
        list.add(e);

        final int index = list.indexOf(anotherE);

        assertEquals(-1, index);
    }


    @Test
    @DisplayName("Быстрая сортировка списка")
    void sortList() {
        final List<Integer> sortedList = List.of(3, 9, 99);
        list.add(9);
        list.add(99);
        list.add(3);
        final int to = list.size() - 1;

        list.quickSort(0, to);

        assertEquals(sortedList.get(0), list.get(0));
        assertEquals(sortedList.get(1), list.get(1));
        assertEquals(sortedList.get(2), list.get(2));
    }

}
