import java.lang.Math;

public class DecimalToBinary {
    public static void main(String[] args) {
        int[] numbers = {900,500, 592, 893};
        for (int num : numbers) {
            long ans = 0;
            int i = 0;

            // Convert the number to binary
            while (num != 0) {
                int bit = num & 1; // Get the last bit
                ans = bit * (int) Math.pow(10, i) + ans; // Place the bit correctly
                num = num >> 1; // Shift right by 1 to process the next bit
                i++;
            }

            // Print the binary result
            basic.output.print(ans+"\n");
        }
    }
}
