package mastermind;

public class Secret extends Combination {

    public Secret() {
        super();
        this.getRandom();
    }

    private Combination getRandom() {
        for (int i = 0; i < COMBINATION_SIZE; i++) {
            this.colors.add(Color.getRandomColor());
        }
        return this;
    }
}
