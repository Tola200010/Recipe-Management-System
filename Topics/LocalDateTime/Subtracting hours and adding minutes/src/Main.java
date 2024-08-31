import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the input date-time and adjustments
        String dateTimeInput = scanner.nextLine();
        int hoursToSubtract = scanner.nextInt();
        int minutesToAdd = scanner.nextInt();

        // Parse the input date-time
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeInput);

        // Subtract the specified hours and add the specified minutes
        LocalDateTime adjustedDateTime = dateTime.minusHours(hoursToSubtract).plusMinutes(minutesToAdd);

        // Format the output as "year-month-dayThours:minutes"
        DateTimeFormatter outputFormatter;
        if (dateTimeInput.length() > 16) { // if seconds were in the input
            outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        } else { // if no seconds were in the input
            outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        }
        String formattedDateTime = adjustedDateTime.format(outputFormatter);

        // Output the adjusted date-time
        System.out.println(formattedDateTime);
    }
}