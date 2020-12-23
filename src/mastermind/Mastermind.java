package mastermind;

public class Mastermind {

    private Board board;

    public Mastermind() {
        this.board = new Board();
    }

    private void play() {
        do {
            this.board.play();
        } while (this.isResumed());
    }

    private boolean isResumed() {
        String answer;
        do {
            answer = IO.getInstance().readText("\nRESUME? (y/n): ");
        } while (!answer.equals("y") && !answer.equals("n"));
        return answer.equals("y");
    }

    public static void main(String[] args) {
        new Mastermind().play();
    }

}