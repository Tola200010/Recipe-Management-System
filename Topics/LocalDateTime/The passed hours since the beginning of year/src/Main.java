import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        // Read the input datetime string
        String inputDateTime = scanner.nextLine();

        // Parse the input string into a LocalDateTime object
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime dateTime = LocalDateTime.parse(inputDateTime, formatter);

        // Get the start of the year (1st January, 00:00) of the same year
        LocalDateTime startOfYear = LocalDateTime.of(dateTime.getYear(), 1, 1, 0, 0, 0);

        // Calculate the difference in hours between the given datetime and the start of the year
        Duration duration = Duration.between(startOfYear, dateTime);
        long hoursPassed = duration.toHours();

        // Print the result
        System.out.println(hoursPassed);

        scanner.close();
    }
}