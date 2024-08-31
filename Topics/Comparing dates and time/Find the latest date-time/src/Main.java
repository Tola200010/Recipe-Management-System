import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        // Read the number of date-time pairs
        int n = scanner.nextInt();
        scanner.nextLine();  // Consume the remaining newline

        LocalDateTime latestDateTime = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

        // Iterate over each date-time pair
        for (int i = 0; i < n; i++) {
            String dateTimeString = scanner.nextLine();
            LocalDateTime currentDateTime = LocalDateTime.parse(dateTimeString, formatter);

            // Check if the current date-time is the latest
            if (latestDateTime == null || currentDateTime.isAfter(latestDateTime)) {
                latestDateTime = currentDateTime;
            }
        }

        // Print the latest date-time
        System.out.println(latestDateTime.format(formatter));

        scanner.close();
    }
}