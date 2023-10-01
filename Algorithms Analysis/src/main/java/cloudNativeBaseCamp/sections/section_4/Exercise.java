package cloudNativeBaseCamp.sections.section_4;

import java.util.Arrays;

/**
 * Segregate Positive and Negative Numbers
 * problem: [9, -3, 5, -2, -8, -6, 1, 3]
 * solution using merge sort: [-3, -2, -8, -6, 9, 5, 1, 3]
 */
public class Exercise {
    public static void main(String[] args) {
        Number[] numbers = {9, -3, 5, -2, -8, -6, 1, 3};
        //segregateByMergeSort(numbers, 0, numbers.length - 1);
        // segregate(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    public static <T extends Number> void segregate(T[] arr){ // T(n) = O(n) | S(n) = O(n)
        T[] temp = Arrays.copyOf(arr, arr.length);
        int index = 0;
        for (int i = 0; i < temp.length; i++) {
            if(temp[i].doubleValue() <= 0) arr[index++] = temp[i];
        }
        for (int i = 0; i < temp.length; i++) {
            if(temp[i].doubleValue() > 0) arr[index++] = temp[i];
        }
    }

    public static <T extends Number> void segregateByMergeSort(T[] arr, int start, int end){ // n log n
        if(start >= end) return;
        int mid = (start + end) / 2;
        segregateByMergeSort(arr, start, mid);
        segregateByMergeSort(arr,mid + 1, end);
        merge(arr, start, mid, end);
    }

    public static <T extends Number> void merge(T[] arr, int start, int mid, int end){
        T[] temp = Arrays.copyOfRange(arr, start, end + 1);
        int index = start;
        int indexL = start;
        int indexR = mid + 1;

        while(indexL <= mid && temp[indexL - start].doubleValue() <= 0){
            arr[index++] = temp[indexL - start];
            indexL++;
        }

        while(indexR <= end && temp[indexR - start].doubleValue() <= 0){
            arr[index++] = temp[indexR - start];
            indexR++;
        }

        while (indexL <= mid) arr[index++] = temp[indexL++ - start];
        while (indexR <= end) arr[index++] = temp[indexR++ - start];
    }
}
