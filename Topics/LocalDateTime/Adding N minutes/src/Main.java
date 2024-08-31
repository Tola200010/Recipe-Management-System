import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        // Read the input date-time string
        String dateTimeInput = scanner.nextLine();

        // Read the number of minutes to add
        long minutesToAdd = scanner.nextLong();

        // Parse the input date-time string to a LocalDateTime object
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm[:ss]");
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeInput, formatter);

        // Add the specified number of minutes
        LocalDateTime newDateTime = dateTime.plusMinutes(minutesToAdd);

        // Prepare the output format
        DateTimeFormatter outputFormatter;
        if (newDateTime.getSecond() == 0) {
            outputFormatter = DateTimeFormatter.ofPattern("yyyy D HH:mm");
        } else {
            outputFormatter = DateTimeFormatter.ofPattern("yyyy D HH:mm:ss");
        }

        // Print the formatted result
        System.out.println(newDateTime.format(outputFormatter));

        scanner.close();
    }
}