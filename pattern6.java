import basic.output;

class pattern6 {
    public static void main(String args[]) {
        int rows = 3;  // Number of rows in the pyramid
        for (int i = 1; i <= rows; i++) {
            // Print leading spaces for alignment
            for (int space = 1; space <= rows - i; space++) {
                output.print("  ");
            }

            // Print increasing numbers
            for (int j = 1; j <= i; j++) {
                output.print(j + " ");
            }

            // Print decreasing numbers
            for (int j = i - 1; j >= 1; j--) {
                output.print(j + " ");
            }

            output.print("\n");  // Move to the next line
        }
    }
}
