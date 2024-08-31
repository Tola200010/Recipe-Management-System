import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        // Read the number of rows and columns
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();  // Consume the leftover newline character

        // Read the table rows as strings
        List<String> table = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            table.add(scanner.nextLine());
        }

        // Read the rotation distance
        int rotationDistance = scanner.nextInt();

        // Rotate the rows by the specified distance
        Collections.rotate(table, rotationDistance);

        // Print the rotated table
        for (String row : table) {
            System.out.println(row);
        }

        scanner.close();
    }
}