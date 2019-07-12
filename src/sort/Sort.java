package sort;

import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {
        int[] array = new int[]{3,1,4,13,9,5,3};
        Sort sort = new Sort();
        int[] newArray = null;
//        newArray = sort.bubbleSort(array);
//        newArray = sort.selectionSort(array);
//        newArray = sort.insertionSort(array);
//        newArray = sort.quickSort(array,0,array.length-1);
//        newArray = sort.mergeSort(array);
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + " ");
        }
    }

    private int[] bubbleSort(int[] array) {
        if (array.length == 0)
            return array;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
    private int[] selectionSort(int[] array) {
        if (array.length == 0)
            return array;
        int index;
        for (int i = 0; i < array.length; i++) {
            index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    index = j;
                }
            }
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
        return array;
    }
    private int[] insertionSort(int[] array) {
        if (array.length == 0)
            return array;
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }
    private int[] quickSort(int[] array, int l, int r) {
        if (l >= r)
            return array;
        int i = l;
        int j = r;
        int key = array[i];
        while (i < j) {
            while (i < j && array[j] >= key) {
                j--;
            }
            if (i < j) {
                array[i] = array[j];
                i++;
            }
            while (i < j && array[i] <= key) {
                i++;
            }
            if (i < j) {
                array[j] = array[i];
                j--;
            }
        }
        array[i] = key;
        quickSort(array, l, i - 1);
        quickSort(array, i + 1, r);
        return array;
    }
    private int[] mergeSort(int[] array) {
        if (array.length < 2)
            return array;
        int middle = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, middle);
        int[] right = Arrays.copyOfRange(array, middle, array.length);
        return merge(mergeSort(left), mergeSort(right));
    }
    private int[] merge(int[] left, int[] right) {
        int[] newArray = new int[left.length + right.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                newArray[k++] = left[i++];
            } else {
                newArray[k++] = right[j++];
            }
        }
        while (i < left.length) {
            newArray[k++] = left[i++];
        }
        while (j < right.length) {
            newArray[k++] = right[j++];
        }
        return newArray;
    }

}
