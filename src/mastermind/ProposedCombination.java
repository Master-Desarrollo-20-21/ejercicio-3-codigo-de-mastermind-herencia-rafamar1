package mastermind;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProposedCombination extends Combination {

    String userInput;
    private static final Pattern COLORS_PATTERN = Pattern.compile("[^rbyopg]", Pattern.CASE_INSENSITIVE);

    public ProposedCombination() {
        super();
        do {
            this.userInput = IO.getInstance().readText("Propose a combination *(colors: rbygop)*: ");
        } while (!checkCorrectInput());

        for (int i = 0; i < COMBINATION_SIZE; i++) {
            this.colors.add(Color.valueOf(userInput.charAt(i)));
        }
    }

    private boolean checkCorrectInput() {
        return isCorrectLength() && isCharColors();
    }

    private boolean isCorrectLength() {
        if (userInput.length() != 4) {
            IO.getInstance().printText("Wrong proposed combination length");
            return false;
        }
        return true;
    }

    private boolean isCharColors() {
        Matcher match = COLORS_PATTERN.matcher(userInput);
        if (match.find()) {
            IO.getInstance().printText("Wrong colors, they must be: rbygop");
            return false;
        }
        return true;
    }
}
