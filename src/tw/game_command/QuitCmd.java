package tw.game_command;

public class QuitCmd implements Command {
    @Override
    public void run() {
        System.exit(0);
    }
}
