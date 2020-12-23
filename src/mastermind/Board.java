package mastermind;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Attempt> attempts;
    private Secret secret;
    private static final int MAX_ATTEMPTS = 10;

    public Board() {
        this.attempts = new ArrayList<>();
        this.secret = new Secret();

        for (int i = 0; i < this.secret.size(); i++) {
            IO.getInstance().printTextWithoutNewLine(secret.colors.get(i).getKeyword());
        }
    }

    public void play() {
        Attempt attempt;
        printAttemptsHeader(0);
        do {
            attempt = new Attempt(secret, new ProposedCombination());
            attempts.add(attempt);
            printAttemptsHeader(attempts.size());
            this.printPreviousAttempts();
            if (attempts.size() == MAX_ATTEMPTS) IO.getInstance().printText("You have lost!! :(");
        } while (isNotGameOver(attempt));
    }

    private void printAttemptsHeader(int attemptCounter) {
        IO.getInstance().printText("\n" + attemptCounter + " attempt(s):");
        showSeparator();
    }

    private boolean isNotGameOver(Attempt attempt) {
        return attempts.size() <= MAX_ATTEMPTS && attempt.getBlackPegs() != 4;
    }

    private void showSeparator() {
        IO.getInstance().printText("xxxx");
    }

    private void printPreviousAttempts() {
        attempts.forEach(Attempt::print);
    }
}
