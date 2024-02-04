/*
package handMadeArrayList.Class;

import handMadeArrayList.list.HandMadeList;

public abstract class QuickSort<T> {

    public void quickSort(HandMadeList<T> list, int from, int to) {
        if (from < to) {
            int divideIndex = partition(arr, from, to);
            quickSort(arr, from, divideIndex - 1);
            quickSort(arr, divideIndex, to);
        }
    }

    private int partition (HandMadeList<T> list, int from, int to) {
        if (T instanceof Integer) {
            int rightIndex = to;
            int leftIndex = from;

            var pivot = list.get(from);
            while (leftIndex <= rightIndex) {

                while (list.get(leftIndex) < pivot) {
                    leftIndex++;
                }
                while (arr[rightIndex] > pivot) {
                    rightIndex--;
                }

                if (leftIndex <= rightIndex) {
                    swap(arr, rightIndex, leftIndex);
                    leftIndex++;
                    rightIndex--;
                }
            }
        }


        return leftIndex;
    }

    private void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
*/
