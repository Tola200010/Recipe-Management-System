import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        // Read the elements of the list as a single line and split into an array
        String[] elements = scanner.nextLine().split(" ");

        // Convert the array to a list of integers
        List<String> list = new ArrayList<>();
        Collections.addAll(list, elements);

        // Read the number of swaps
        int numberOfSwaps = scanner.nextInt();

        // Perform each swap
        for (int i = 0; i < numberOfSwaps; i++) {
            int index1 = scanner.nextInt();
            int index2 = scanner.nextInt();
            // Swap the elements at the specified indices
            Collections.swap(list, index1, index2);
        }

        // Print the modified list
        for (String element : list) {
            System.out.print(element + " ");
        }

        scanner.close();
    }
}