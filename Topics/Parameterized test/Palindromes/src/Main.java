import java.util.stream.Collectors;

class StringUtils {
    public static boolean isPalindrome(String string) {
        if (string == null || string.isEmpty()) {
            return false;
        }

        // Normalize the string: remove non-alphanumeric characters and convert to lowercase
        String normalizedString = string.chars()
                .filter(Character::isLetterOrDigit)
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining())
                .toLowerCase();

        // Return false if normalization results in an empty string
        if (normalizedString.isEmpty()) {
            return false;
        }

        // Check if the normalized string is a palindrome
        int length = normalizedString.length();
        for (int i = 0; i < length / 2; i++) {
            if (normalizedString.charAt(i) != normalizedString.charAt(length - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}