package handMadeArrayList;


import handMadeArrayList.list.HandMadeList;
import handMadeArrayList.list.impl.HandMadeArrayList;


public class Main {
    public static void main(String[] args) {

        var ar = new HandMadeArrayList<Integer>();
        ar.add(5);
        ar.add(99);
        ar.add(13);
        ar.add(34);
        ar.add(1);
        ar.add(17);
        ar.add(56);

        System.out.println(ar);

        ar.quickSort(0, ar.size() - 1);

        System.out.println(ar);
    }

    private static void quickSort(HandMadeList<Integer> list, int from, int to) {
        if (from < to) {
            int divideIndex = partition(list, from, to);
            quickSort(list, from, divideIndex - 1);
            quickSort(list, divideIndex, to);
        }
    }

    private static int partition (HandMadeList<Integer> list, int from, int to) {
        int rightIndex = to;
        int leftIndex = from;

        int pivot = list.get(from);
        while (leftIndex <= rightIndex) {

            while (list.get(leftIndex) < pivot) {
                leftIndex++;
            }
            while (list.get(rightIndex) > pivot) {
                rightIndex--;
            }

            if (leftIndex <= rightIndex) {
                swap(list, rightIndex, leftIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    private static void swap(HandMadeList<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
