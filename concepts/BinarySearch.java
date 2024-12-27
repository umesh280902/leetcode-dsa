import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 56, 76, 7, 8, 845, 546, 46, 43, 4564, 4};
        Arrays.sort(arr); // Sorting the array to ensure binary search works
        int start = 0;
        int end = arr.length - 1;
        int key = 8;
        boolean found = false;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == key) {
                System.out.println("The index is " + mid);
                found = true;
                break;
            }
            if (arr[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (!found) {
            System.out.println("Key not found, returning -1");
        }
    }
}
