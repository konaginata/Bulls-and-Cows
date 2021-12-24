package bullscows;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the secret code's length:");
        String input = scanner.nextLine();
        if (!isNumeric(input) || Integer.parseInt(input) < 1) {
            System.out.println("Error: " + input + " isn't a valid number.");
        } else {
            runner(scanner, input);
        }
    }

    private static void runner(Scanner scanner, String input) {
        int length = Integer.parseInt(input);
        System.out.println("Input the number of possible symbols in the code:");
        int range = scanner.nextInt();
        if (range < length) {
            System.out.println("Error: it's not possible to generate a code with a length of " + length + " with "
                + range + " unique symbols.");
        } else if (range > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
        } else {
            generator(length, range);
        }
    }

    private static void generator(int length, int range) {
        String secret = Generator.getNumber(length, range);
        System.out.print("The secret is prepared: ");
        for (int i = 0; i < length; i++) {
            System.out.print('*');
        }
        System.out.print(" (0-9, a-" + Generator.getAllCharactersList().get(range - 1) + ").\n");
        System.out.println("Okay, let's start a game!");
        caller(secret);
    }

    public static void caller(String number) {
        int turn = 1;
        Scanner scanner = new Scanner(System.in);
        Counter counter = new Counter();
        System.out.println("Turn " + turn++ + ":");
        if (scanner.hasNext()) {
            counter.cowsBullsCounter(number, scanner.nextLine());
        }
    }

    public static boolean isNumeric(String strNum) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        return strNum != null && pattern.matcher(strNum).matches();
    }
}
