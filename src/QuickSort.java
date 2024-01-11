import java.util.Arrays;

public class QuickSort {
    static int counter = 0;

    // Sorts the given array by calling the recursive sort method with start and end indices
    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    // Recursive method that partitions the array and sorts its sub-arrays
    static void sort(int[] numbers, int start, int end) {
        // Base case: if start index is greater than or equal to end index, array is sorted
        if (start < end) {
            // Partition the array around a pivot, and recursively sort the sub-arrays
            int p = partition(numbers, start, end);
            sort(numbers, start, p - 1); // Sort left sub-array
            sort(numbers, p + 1, end); // Sort right sub-array
        }
    }

    // Partitions the array around a pivot, and returns the pivot index
    static int partition(int[] numbers, int start, int end) {
        // Choose the last element as the pivot
        int pivot = numbers[end];
        int x = start - 1; // Index of smaller element
        // Traverse the array from start to end-1, and move elements smaller than pivot to the left side
        for (int i = start; i < end; i++) {
            counter++; // increment the counter for each comparison
            if (numbers[i] < pivot) {
                // Increment index of smaller element, and swap the current element with it
                x++;
                int temp = numbers[x];
                numbers[x] = numbers[i];
                numbers[i] = temp;
            }
        }
        // Swap the pivot with the element at the next index of the smaller element, so that the pivot is in its correct position
        int temp = numbers[x+1];
        numbers[x + 1] = numbers[end];
        numbers[end] = temp;
        counter++; // increment the counter for each swap
        // Return the pivot index
        return x + 1;
    }

    public static void main(String[] args) {
        int[] array = {10,9,8,7,6,5,4,3,2,1};

        System.out.println("Before: ");
        System.out.println(Arrays.toString(array));

        // Sort the array using QuickSort
        sort(array);

        System.out.println("After: ");
        System.out.println(Arrays.toString(array));
        System.out.println("Number of actions: " + counter);
    }
}
