import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        // Read the input line
        String input = scanner.nextLine();

        // Split the input into date and the number of days
        String[] parts = input.split(" ");
        String dateInput = parts[0];
        int daysToAdd = Integer.parseInt(parts[1]);

        // Parse the input date
        LocalDate date = LocalDate.parse(dateInput, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // Add the specified number of days to the date
        LocalDate targetDate = date.plusDays(daysToAdd);

        // Determine if the target date is January 1st of the next year
        boolean isNewYear = targetDate.equals(LocalDate.of(date.getYear() + 1, 1, 1));

        // Print the result
        System.out.println(isNewYear);
    }
}