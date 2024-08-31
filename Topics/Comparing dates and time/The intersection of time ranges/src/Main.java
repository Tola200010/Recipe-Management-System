import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        // Read the first time range
        String[] firstRange = scanner.nextLine().split(" ");
        String[] startTime1 = firstRange[0].split(":");
        String[] endTime1 = firstRange[1].split(":");

        // Read the second time range
        String[] secondRange = scanner.nextLine().split(" ");
        String[] startTime2 = secondRange[0].split(":");
        String[] endTime2 = secondRange[1].split(":");

        // Convert the times to minutes from midnight for easier comparison
        int start1 = Integer.parseInt(startTime1[0]) * 60 + Integer.parseInt(startTime1[1]);
        int end1 = Integer.parseInt(endTime1[0]) * 60 + Integer.parseInt(endTime1[1]);
        int start2 = Integer.parseInt(startTime2[0]) * 60 + Integer.parseInt(startTime2[1]);
        int end2 = Integer.parseInt(endTime2[0]) * 60 + Integer.parseInt(endTime2[1]);

        // Check if the ranges intersect
        boolean intersect = (start1 <= end2 && start2 <= end1);

        // Output the result
        System.out.println(intersect);

        scanner.close();
    }
}