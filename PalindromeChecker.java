import java.util.*;

public class PalindromeChecker {
    public static boolean containsNumbers(String string) {
        if (string == null || string.isEmpty()) {
            return false;
        }
        for (int i = 0; i < string.length(); ++i) {
            if (Character.isDigit(string.charAt(i))) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word, wordReverse = "";

        while (true){
            System.out.print("Enter a word to see if it is palindrome or not: ");
            word = sc.next();
            if (containsNumbers(word) == true) {
                System.out.println("Palindrome is only for word, do not enter any number!");
                while (true) {
                    System.out.print("Do you want to check another word? (Y/N): ");
                    String reload = sc.next();
                    if (reload.equalsIgnoreCase("Y")) {
                        wordReverse = "";
                        break; // exit the inner while loop
                    } else if (reload.equalsIgnoreCase("N")) {
                        System.out.println("Exiting program...");
                        return;
                    } else {
                        System.out.println("Invalid input. Please enter Y or N.");
                        System.out.println("");
                    }
                }
                continue;
            }
            word = word.toLowerCase();
            Stack<Character> stack = new Stack<>();

            for (int i=0; i<word.length(); i++){
                stack.push(word.charAt(i));
            }
            while (!stack.isEmpty()) {
                wordReverse += Character.toString(stack.pop());
            }
            if (word.equals(wordReverse)) {
                System.out.println("It is palindrome.");
                System.out.println("");
            } else {
                System.out.println("It is not palindrome.");
                System.out.println("");
            }
            while (true) {
                System.out.print("Do you want to check another word? (Y/N): ");
                String reload = sc.next();
                if (reload.equalsIgnoreCase("Y")) {
                    wordReverse = ""; // Reset the wordReverse
                    break; // exit the current while loop
                } else if (reload.equalsIgnoreCase("N")) {
                    System.out.println("Exiting program...");
                    return; // exit the program
                } else {
                    System.out.println("Invalid input. Please enter Y or N."); // restart the while loop
                    System.out.println("");
                }
            }
        }
    }
}