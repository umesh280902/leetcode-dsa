public class BubbleSort {
    private static void implementation(int arr[]) {
        for (int x = 1; x < arr.length; x++) { // Fix loop condition
            boolean swapped = false;
            for (int y = 0; y < arr.length - x; y++) { // Correct inner loop
                if (arr[y] > arr[y + 1]) {
                    swap(arr, y, y + 1); // Pass array and indices to swap
                    swapped = true;
                }
            }
            if (!swapped) { // If no elements were swapped, the array is sorted
                break;
            }
        }
    }

    private static void swap(int[] arr, int a, int b) { // Swap elements in the array
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int arr[] = {5, 41, 324, 234, 234, 54, 123, 12, 6, 6, 8, 56, 7};
        implementation(arr);
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }
}
