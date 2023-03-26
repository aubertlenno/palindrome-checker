import java.util.Scanner;

public class PalindromeStack {
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

    public static boolean isPalindromeWord(String word) {
        ListStack<Character> stack = new ListStack<>();
        word = word.toLowerCase();

        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }

        String wordReverse = "";
        while (!stack.isEmpty()) {
            wordReverse += Character.toString(stack.pop());
        }

        return word.equals(wordReverse);
    }

    public static boolean isPalindromeNumber(String number) {
        ListStack<Character> stack = new ListStack<>();

        for (int i = 0; i < number.length(); i++) {
            stack.push(number.charAt(i));
        }

        String numberReverse = "";
        while (!stack.isEmpty()) {
            numberReverse += Character.toString(stack.pop());
        }

        return number.equals(numberReverse);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String type = "";
        boolean checkAnotherPalindrome = true;
        while (checkAnotherPalindrome) {
            while (!(type.equalsIgnoreCase("word") || type.equalsIgnoreCase("number"))) {
                System.out.print("What kind of palindrome do you want to check (word/number)? ");
                type = sc.next();
                if (!(type.equalsIgnoreCase("word") || type.equalsIgnoreCase("number"))) {
                    System.out.println("Invalid input. Please enter either 'word' or 'number'.");
                    System.out.println("");
                }
            }
            String input = "";
            while (true) {
                System.out.print("Enter a " + type + " to see if it is palindrome or not: ");
                input = sc.next();
                if (type.equalsIgnoreCase("word")) {
                    if (containsNumbers(input)) {
                        System.out.println("Palindrome is only for words, please enter a valid word!");
                        System.out.println("");
                        continue;
                    }
                    if (isPalindromeWord(input)) {
                        System.out.println("It is a palindrome.");
                        System.out.println("");
                    } else {
                        System.out.println("It is not a palindrome.");
                        System.out.println("");
                    }
                } else {
                    try {
                        Long.parseLong(input);
                    } catch (NumberFormatException e) {
                        System.out.println("Palindrome is only for numbers, please enter a valid number!");
                        System.out.println("");
                        continue;
                    }
                    if (isPalindromeNumber(input)) {
                        System.out.println("It is a palindrome.");
                        System.out.println("");
                    } else {
                        System.out.println("It is not a palindrome.");
                        System.out.println("");
                    }
                }
                String again = "";
                while (!(again.equalsIgnoreCase("y") || again.equalsIgnoreCase("n"))) {
                    System.out.print("Do you want to check another palindrome? (Y/N): ");
                    again = sc.next();
                    if (!(again.equalsIgnoreCase("y") || again.equalsIgnoreCase("n"))) {
                        System.out.println("Invalid input. Please enter either 'Y' or 'N'.");
                        System.out.println("");
                    }
                }
                if (again.equalsIgnoreCase("n")) {
                    System.out.println("Exiting program...");
                    checkAnotherPalindrome = false;
                    break;
                } else if (again.equalsIgnoreCase("y")) {
                    type = "";
                    while (!(type.equalsIgnoreCase("word") || type.equalsIgnoreCase("number"))) {
                        System.out.print("\nWhat kind of palindrome do you want to check (word/number)? ");
                        type = sc.next();
                        if (!(type.equalsIgnoreCase("word") || type.equalsIgnoreCase("number"))) {
                            System.out.println("Invalid input. Please enter either 'word' or 'number'.");
                            System.out.println("");
                        }
                    }
                    continue;
                }
            }
        }
    }
}
