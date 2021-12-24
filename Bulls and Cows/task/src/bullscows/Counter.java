package bullscows;

public class Counter {
    public static final String GRADE = "Grade: ";
    private int bulls = 0;
    private int cows = 0;

    public void cowsBullsCounter(String number, String ask) {
        for (int i = 0; i < number.length(); i++) {
            if (ask.charAt(i) == number.charAt(i)) {
                bulls++;
            }
            if (number.contains(String.valueOf(ask.charAt(i)))) {
                cows++;
            }
        }
        decision(number);
    }

    private void decision(String number) {
        if (bulls == number.length()) {
            System.out.println(GRADE + bulls + " bull(s)\nCongratulations! You guessed the secret code.");
        } else if (bulls == 0 && cows == 0) {
            System.out.println("Grade: None");
            Main.caller(number);
        } else if (bulls == 0) {
            System.out.println(GRADE + cows + " cow(s)");
            Main.caller(number);
        } else if (cows == 0) {
            System.out.println(GRADE + bulls + " bull(s)");
            Main.caller(number);
        } else {
            System.out.println(GRADE + bulls + " bull(s) and " + cows + " cow(s)");
            Main.caller(number);
        }
    }
}
