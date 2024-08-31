import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        // Read the input time
        String timeInput = scanner.nextLine();

        LocalTime time = LocalTime.parse(timeInput);

        // Use the withSecond(0) method to set seconds to 0 and withNano(0) to remove nano adjustments
        LocalTime timeWithoutSeconds = time.withSecond(0).withNano(0);

        // Format the time without seconds using DateTimeFormatter
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("HH:mm");
        String formattedTime = timeWithoutSeconds.format(outputFormatter);
        // Output the formatted time
        System.out.println(formattedTime);
    }
}