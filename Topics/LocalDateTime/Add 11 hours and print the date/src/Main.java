import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String dateInput = scanner.nextLine();
        LocalDateTime localDateTime = LocalDateTime.parse(dateInput);
        localDateTime = localDateTime.plusHours(11);
        System.out.println(localDateTime.toLocalDate());
    }
}