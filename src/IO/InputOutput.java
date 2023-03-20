package IO;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputOutput {
    public InputOutput() {

    }
    public static void println(String s) {
        System.out.println(s);
    }

    public static int printAndScanInt(String s) {
        Scanner scanner = new Scanner(System.in);
        int result;
        while (true) {
            System.out.print(s);
            try {
                scanner.reset();
                result = scanner.nextInt();
                break;
            }
            catch (InputMismatchException e) {
                System.out.println("Input invalid. Try again.");
                scanner.next();
            }
        }
     return result;
    }

    public static String printAndScanStringAndCompareWith(String message, String stringToCompare) {
        System.out.print(message);
        Scanner scanner = new Scanner(System.in);
        String result = scanner.next();
        while (result.equals(stringToCompare)) {
            System.out.println("Is identical with other String. Try again.");
            System.out.print(message);
            result = scanner.next();
        }
        return result;
    }

    public static char printAndScanCharAndCompareWith(String message, char charToCompare) {
        Scanner scanner = new Scanner(System.in);
        char chosenChar;
        while (true) {
            System.out.print(message);
            String c = scanner.next();
            if (c.length() == 1) {
                chosenChar = c.charAt(0);
                if (chosenChar == charToCompare)
                {
                    System.out.println("This Symbol is already taken. Try again.");
                }
                else {
                    return chosenChar;
                }
            }
            else {
                System.out.println("Input is invalid. Try again");
            }

        }
    }
}
