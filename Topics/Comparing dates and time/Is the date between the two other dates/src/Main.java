import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        // Read the input line
        String input = scanner.nextLine();

        // Split the input into the three dates
        String[] parts = input.split(" ");
        LocalDate dateX = LocalDate.parse(parts[0], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate dateM = LocalDate.parse(parts[1], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate dateN = LocalDate.parse(parts[2], DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // Ensure dateM is the earlier and dateN is the later date
        if (dateM.isAfter(dateN)) {
            LocalDate temp = dateM;
            dateM = dateN;
            dateN = temp;
        }

        // Check if dateX is between dateM and dateN (excluding dateM and dateN)
        boolean isBetween = dateX.isAfter(dateM) && dateX.isBefore(dateN);

        // Print the result
        System.out.println(isBetween);

        scanner.close();
    }
}