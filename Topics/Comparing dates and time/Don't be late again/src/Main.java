import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of stores
        int n = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        // Define the time you leave the house
        int leaveHour = 19;
        int leaveMinute = 30;
        int timeToReach = 30; // time to reach any store in minutes

        // Calculate the time when you will reach the store
        int reachHour = leaveHour;
        int reachMinute = leaveMinute + timeToReach;

        // Handle minute overflow (e.g., 19:30 + 30 minutes = 20:00)
        if (reachMinute >= 60) {
            reachHour += 1;
            reachMinute -= 60;
        }

        // Loop through each store to check if it's reachable
        for (int i = 0; i < n; i++) {
            // Read the store name and closing time
            String storeInfo = scanner.nextLine();
            String[] parts = storeInfo.split(" ");
            String storeName = parts[0];
            String[] closingTime = parts[1].split(":");
            int closeHour = Integer.parseInt(closingTime[0]);
            int closeMinute = Integer.parseInt(closingTime[1]);

            // Determine if the store will still be open after you arrive
            if (reachHour < closeHour || (reachHour == closeHour && reachMinute < closeMinute)) {
                System.out.println(storeName);
            }
        }

        scanner.close();
    }
}