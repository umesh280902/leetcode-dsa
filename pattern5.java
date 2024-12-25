import basic.output;

public class pattern5 {
    public static void main(String args[]) {
        int row = 4; // Start from 4 because you need the maximum stars on the first row
        while (row >= 1) { // Decrease the row number to reduce the number of stars
            int space = 4 - row; // Calculate spaces
            while (space > 0) {
                output.print(" ");
                space--;
            }
            int col = 1;
            while (col <= row) { // Print stars based on the current row number
                output.print("*");
                col++;
            }
            output.print("\n"); // Move to the next line after printing stars
            row--; // Decrement row to reduce the number of stars in the next row
        }
    }
}
