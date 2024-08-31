import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        // Read the input datetime string
        String inputDateTime1 = scanner.nextLine();
        String inputDateTime2 = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime startDate = LocalDateTime.parse(inputDateTime1,formatter);
        LocalDateTime endedDate = LocalDateTime.parse(inputDateTime2,formatter);
        Duration duration = Duration.between(startDate,endedDate);
        long hoursBetween = duration.toHours();
        System.out.println(hoursBetween);
    }
}