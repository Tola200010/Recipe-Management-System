import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String date = scanner.next();
        String dayToAdd = scanner.next();
        String hourToSubtract = scanner.next();
        LocalDateTime localDateTime = LocalDateTime.parse(date);
        localDateTime = localDateTime.plusDays(Integer.parseInt(dayToAdd)).minusHours(Integer.parseInt(hourToSubtract));
        System.out.println(localDateTime);
    }
}