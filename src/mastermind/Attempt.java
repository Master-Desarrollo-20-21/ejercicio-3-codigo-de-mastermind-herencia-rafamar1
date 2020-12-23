package mastermind;

public class Attempt {

    private ProposedCombination proposedCombination;
    private Secret secret;
    private int blackPegs;
    private int whitePegs;

    public Attempt(Secret secret, ProposedCombination proposedCombination) {
        this.proposedCombination = proposedCombination;
        this.secret = secret;
        this.blackPegs = 0;
        this.whitePegs = 0;
        checkBlackAndWhitePegs();
    }

    public void print() {
        for (int i = 0; i < this.proposedCombination.size(); i++) {
            IO.getInstance().printTextWithoutNewLine(proposedCombination.colors.get(i).getKeyword());
        }
        IO.getInstance().printText("--> " + this.blackPegs + " blacks and " + this.whitePegs + " whites");
        if (this.blackPegs == 4) {
            IO.getInstance().printText("Congrats, You are the WINNER!!");
            IO.getInstance().printText("*- Restart game to generate a new secret -*");
        }
    }

    public int getBlackPegs() {
        return this.blackPegs;
    }

    private void checkBlackAndWhitePegs() {
        for (int i = 0; i < this.secret.size(); i++) {
            if (this.secret.colors.get(i).equals(this.proposedCombination.colors.get(i))) {
                blackPegs++;
            } else if (this.secret.colors.contains(this.proposedCombination.colors.get(i))) {
                whitePegs++;
            }
        }
    }
}
