package cloudNativeBaseCamp.sections.section_3;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        Number[] arr = {9, 5.5, 5, -1, 1, 0, 10};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static <T extends Number> void insertionSort(T[] arr){
        T temp;
        int j;
        for (int i = 1; i < arr.length; i++) { // n
            j = i - 1; // 1
            temp = arr[i]; // 1
            while (j > -1){ // n * n
                if(arr[j].doubleValue() > temp.doubleValue()) arr[j + 1] = arr[j]; // 1
                else break;
                j--; // 1
            }
            arr[j + 1] = temp; // 1
        }
        // T(n) = n + n2 + 5 => O(n^2)
    }
}


