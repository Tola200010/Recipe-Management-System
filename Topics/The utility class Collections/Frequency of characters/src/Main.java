import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        // Read the sequence of characters
        String sequence = scanner.nextLine();

        // Read the character to count
        char characterToCount = scanner.next().charAt(0);

        // Remove spaces from the sequence
        sequence = sequence.replace(" ", "");

        // Count occurrences of the character
        int count = 0;
        for (int i = 0; i < sequence.length(); i++) {
            if (sequence.charAt(i) == characterToCount) {
                count++;
            }
        }

        // Output the count
        System.out.println(count);

        scanner.close();
    }
}