package mastermind;

import java.util.ArrayList;
import java.util.List;

public class Combination {

    List<Color> colors;
    protected static final int COMBINATION_SIZE = 4;

    public Combination() {
        this.colors = new ArrayList<>();
    }

    protected int size() {
        return this.colors.size();
    }
}
