import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
       int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        // int[] array = {1,2,3,4,5,6,7,9,10};

        int counter = 0;

        /*********** Task 2.A *************************/
//
//        int min,i,k;
//
//        min = i = 0;
//        for (k=i+1;k<array.length;k++){
//            if (array[k]<array[min]){
//                min=k;
//            }
//            i++;
//        }
//
//        System.out.println("In array: ");
//        System.out.println(Arrays.toString(array));
//        System.out.println("The minimum value is on the index: " + min);


        /*********** Task 2.B *************************/

//        System.out.println("Before: ");
//        System.out.println(Arrays.toString(array));
//
//        int min,i,k, temp;
//
//        for (i=0;i<array.length-1;i++)  {
//            counter++;
//            min=i;
//            for (k=i+1;k<array.length;k++){
//                counter++;
//                if (array[k]<array[min]){
//                    counter++;
//                    min=k;
//                }
//            }
//            temp=array[min];
//            array[min]=array[i];
//            array[i]=temp;
//        }
//
//        System.out.println("After: ");
//        System.out.println(Arrays.toString(array));
//        System.out.println("Number of actions: " + counter);

        /*********** Task 2.C *************************/

        System.out.println("Before: ");
        System.out.println(Arrays.toString(array));

        int minIndex, maxIndex;

        // now since we are sorting by both minimum and maximum elements
        for (int i = 0; i < array.length / 2; i++) {
            // Set the minimum and maximum indices to the current index
            minIndex = i;
            maxIndex = i;
            // Find the indices of the minimum and maximum elements in the
            // unsorted portion of the array
            for (int j = i + 1; j < array.length - i; j++) {
                counter++;
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                } else if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }
            // If the minimum element is not already in its correct position,
            // swap it with the first unsorted element
            if (minIndex != i) {
                counter++;
                swap(array, i, minIndex);
            }
            // If the maximum element is in the position of the minimum element,
            // update its index to the new position of the minimum element
            if (maxIndex == i) {
                counter++;
                maxIndex = minIndex;
            }
            // If the maximum element is not already in its correct position,
            // swap it with the last unsorted element
            if (maxIndex != array.length - i - 1) {
                counter++;
                swap(array, array.length - i - 1, maxIndex);
            }
        }
        System.out.println("After: ");
        System.out.println(Arrays.toString(array));
        System.out.println("Number of actions: " + counter);
    }

    static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        temp = array[j];
    }
}
