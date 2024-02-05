package handmadearraylist.list;

/**
 * Собственный вариант интерфейса List, в урезанном виде.
 * Сохранены основные свойства упорядоченной коллекции, разница лишь в наборе методов.
 *
 * @param <T> - тип элементов в этом списке;
 */

public interface HandMadeList<T> {

    /**
     * Возвращает количество элементов в этом списке
     */
    int size();

    /**
     * Добавляет указанный элемент в конец этого списка.
     *
     * @param newElement - элемент, который нужно вставить;
     */
    void add(T newElement);

    /**
     * Вставляет указанный элемент в указанную позицию в этом списке.
     * Смещает элемент, находящийся в данный момент в этой позиции (если есть),
     * и любые последующие элементы вправо (добавляет единицу к их индексам).
     *
     * @param index      - индекс, в который должен быть вставлен указанный элемент;
     * @param newElement - элемент, который нужно вставить;
     */
    void add(int index, T newElement);

    /**
     * Заменяет элемент в указанной позиции в этом списке указанным элементом.
     *
     * @param index   - индекс элемента для замены;
     * @param element - элемент, который будет сохранен в указанной позиции;
     * @return элемент, ранее находившийся в указанной позиции
     */
    Object set(int index, T element);

    /**
     * Возвращает элемент в указанной позиции в этом списке.
     *
     * @param index - индекс возвращаемого элемента;
     * @return элемент в указанной позиции в этом списке
     */
    T get(int index);

    /**
     * Удаляет все элементы из этого списка.
     * Список будет пуст после возврата этого вызова.
     */
    void clear();

    /**
     * Удаляет первое вхождение указанного элемента из этого списка, если он присутствует.
     * Если этот список не содержит элемента, он не изменяется.
     *
     * @param o - объект, который предполагается удалить из списка;
     * @return булево значение результата операции;
     */
    boolean remove(Object o);

    /**
     * Возвращает true, если этот список содержит указанный элемент.
     *
     * @param o - элемент, присутствие которого в этом списке необходимо проверить;
     * @return true, если этот список содержит указанный элемент
     */
    boolean contains(Object o);

    /**
     * Возвращает индекс первого вхождения указанного элемента в этом списке или -1,
     * если этот список не содержит этот элемент.
     *
     * @param o - элемент для поиска;
     * @return индекс первого вхождения указанного элемента в этом списке или -1,
     * если этот список не содержит элемент
     */
    int indexOf(Object o);

    /**
     * Сортирует этот список в алгоритмом быстрой сортироки.
     *
     * @param from - индекс елемента с которого начнется сортировка
     * @param to   - индекс последнего элемента для сортироки
     */
    void quickSort(int from, int to);
}
