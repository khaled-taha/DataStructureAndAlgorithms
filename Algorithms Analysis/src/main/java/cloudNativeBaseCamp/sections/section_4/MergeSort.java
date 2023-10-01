package cloudNativeBaseCamp.sections.section_4;

import java.util.Arrays;


public class MergeSort {
    public static void main(String[] args) {
        Double[] arr = {9.0, 5.5, 5.0, -1.0, 1.0, 0.0, 10.0};
        mergeSort(arr, 0, arr.length - 1); // n * log(n)
        System.out.println(Arrays.toString(arr));
    }

    public static <T extends Comparable<T>> void mergeSort(T[] arr, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    private static <T extends Comparable<T>> void merge(T[] arr, int start, int mid, int end) {
        T[] tempArr = Arrays.copyOfRange(arr, start, end + 1);
        int index = start;
        int indexL = start;
        int indexR = mid + 1;

        while (indexL <= mid && indexR <= end) {
            if (tempArr[indexL - start].compareTo(tempArr[indexR - start]) <= 0)
                arr[index++] = tempArr[indexL++ - start];
            else
                arr[index++] = tempArr[indexR++ - start];
        }
        while (indexL <= mid) arr[index++] = tempArr[indexL++ - start];
        while (indexR <= end) arr[index++] = tempArr[indexR++ - start];
    }

}
