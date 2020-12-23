package mastermind;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IO {
    private final Scanner scanner = new Scanner(System.in);
    private String title;
    private static IO INSTANCE;

    public static IO getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new IO();
        }
        return INSTANCE;
    }

    private IO() {
    }

    public String readText(String title) {
        this.title = title;
        boolean ok = false;
        String text = null;
        do {
            try {
                System.out.print(this.title);
                text = scanner.nextLine();
                ok = true;
            } catch (InputMismatchException ex) {
                System.out.println("error");
                scanner.next();
            }
        } while (!ok);
        return text;
    }

    public void printText(Object object) {
        System.out.println(object);
    }

    public void printTextWithoutNewLine(Object object) {
        System.out.print(object);
    }
}