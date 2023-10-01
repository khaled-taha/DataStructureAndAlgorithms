package cloudNativeBaseCamp.sections.section_5;


public class BinarySearch {
    public static void main(String[] args) {
        Student[] students = {
                new Student(100, "Alice"),
                new Student(101, "Bob"),
                new Student(102, "Charlie"),
                new Student(103, "David"),
                new Student(104, "Eve")
        };
        boolean found = binarySearch(students, new Student(102, "Charlie"));
        System.out.println(found);
    }

    /**
     * T(n) = O(log(n))
     * S(n) = O(1) ==>  It uses constant space regardless of the size of the input data.
     * @param arr
     * @param element
     * @return true or false
     * @param <T>
     */
    public static <T extends Comparable<T>> boolean binarySearch(T[] arr, T element) {
        int start = 0;
        int end = arr.length - 1;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;
            int compare = arr[mid].compareTo(element);

            if (compare == 0) return true;
            if (compare < 0) start = mid + 1;
            else end = mid - 1;

        }
        return false;
    }
}

