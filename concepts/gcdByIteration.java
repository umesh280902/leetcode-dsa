public class gcdByIteration {

    public static void main(String[] args) {
        int a = 24;
        int b = 72;

        // Handle edge cases
        if (a == 0) {
            System.out.println("GCD: " + b);
            return;
        }
        if (b == 0) {
            System.out.println("GCD: " + a);
            return;
        }

        // Iterative subtraction method
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }

        // Print the result
        System.out.println("GCD: " + a);
    }
}
