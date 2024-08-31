import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        // Read the first sequence
        String[] firstSequenceInput = scanner.nextLine().split(" ");
        int[] firstSequence = new int[firstSequenceInput.length];
        for (int i = 0; i < firstSequenceInput.length; i++) {
            firstSequence[i] = Integer.parseInt(firstSequenceInput[i]);
        }

        // Read the second sequence
        String[] secondSequenceInput = scanner.nextLine().split(" ");
        int[] secondSequence = new int[secondSequenceInput.length];
        for (int i = 0; i < secondSequenceInput.length; i++) {
            secondSequence[i] = Integer.parseInt(secondSequenceInput[i]);
        }

        // Find the first and last occurrences
        int firstOccurrence = -1;
        int lastOccurrence = -1;

        for (int i = 0; i <= firstSequence.length - secondSequence.length; i++) {
            boolean match = true;
            for (int j = 0; j < secondSequence.length; j++) {
                if (firstSequence[i + j] != secondSequence[j]) {
                    match = false;
                    break;
                }
            }
            if (match) {
                if (firstOccurrence == -1) {
                    firstOccurrence = i;
                }
                lastOccurrence = i;
            }
        }

        // Output the results
        System.out.println(firstOccurrence + " " + lastOccurrence);

        scanner.close();
    }
}