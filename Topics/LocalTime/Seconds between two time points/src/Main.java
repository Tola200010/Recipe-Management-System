import java.sql.Time;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static long secondsBetween(LocalTime startTime, LocalTime endTime) {
        // Calculate the duration between the two times
        Duration duration = Duration.between(startTime, endTime);
        // Return the absolute value of the difference in seconds
        return Math.abs(duration.getSeconds());
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // write your code here
        String time1 = scanner.next();
        String time2 = scanner.next();
        long durationSecond = secondsBetween(LocalTime.parse(time1), LocalTime.parse(time2));
        System.out.println(durationSecond);
    }
}