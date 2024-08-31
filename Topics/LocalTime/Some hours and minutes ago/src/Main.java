import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        // Read the input time in "HH:mm" format
        String timeInput = scanner.nextLine();
        // Read the input for hours and minutes to subtract
        int hoursToSubtract = scanner.nextInt();
        int minutesToSubtract = scanner.nextInt();

        // Parse the input time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime currentTime = LocalTime.parse(timeInput, formatter);

        // Subtract the specified hours and minutes
        LocalTime timeBefore = currentTime.minusHours(hoursToSubtract).minusMinutes(minutesToSubtract);

        // Print the result in the same format
        System.out.println(timeBefore.format(formatter));
    }
}