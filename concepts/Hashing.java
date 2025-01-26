import java.util.function.BiFunction;
import java.util.function.Function;

public class Hashing {
    private static int[] hash;
    private static final int HASH_SIZE = 20;

    public static Function<Integer, Integer> divisionHash(int prime) {
        return number -> number % prime;
    }

    public static BiFunction<Integer, Integer, Integer> kFoldHash(int prime) {
        return (number, kparts) -> {
            String numStr = String.valueOf(number);
            int partLength = numStr.length() / kparts;
            int sum = 0;
            for (int i = 0; i < kparts; i++) {
                int start = i * partLength;
                int end = Math.min(start + partLength, numStr.length());
                sum += Integer.parseInt(numStr.substring(start, end));
            }
            return sum % prime;
        };
    }

    public static Function<Integer, Integer> midSquareHash(int prime) {
        return number -> {
            int square = number * number;
            String squareStr = String.valueOf(square);
            int mid = squareStr.length() / 2;
            String middlePart = squareStr.substring(Math.max(0, mid - 1), Math.min(squareStr.length(), mid + 1));
            return Integer.parseInt(middlePart) % prime;
        };
    }

    private static void applyHashing(int[] array, Function<Integer, Integer> hashFunction) {
        for (int number : array) {
            int index = hashFunction.apply(number);
            if (index < HASH_SIZE) {
                hash[index] = number;
            } else {
                System.out.println("Index out of bounds for number: " + number);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {15, 25, 35, 45, 55};
        int prime = 7;
        int kparts = 2;

        // Initialize hash array
        hash = new int[HASH_SIZE];

        // Test Division Method
        System.out.println("Division Method:");
        applyHashing(array, divisionHash(prime));
        printHashArray();

        // Reset hash array
        resetHashArray();

        // Test K-Fold Method
        System.out.println("K-Fold Method:");
        applyHashing(array, number -> kFoldHash(prime).apply(number, kparts));
        printHashArray();

        // Reset hash array
        resetHashArray();

        // Test Mid-Square Method
        System.out.println("Mid-Square Method:");
        applyHashing(array, midSquareHash(prime));
        printHashArray();
    }

    private static void resetHashArray() {
        hash = new int[HASH_SIZE];
    }

    private static void printHashArray() {
        for (int i : hash) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
