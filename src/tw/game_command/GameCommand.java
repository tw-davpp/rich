package tw.game_command;

public abstract class GameCommand {
    protected String cmd;

    public GameCommand(String cmd) {
        this.cmd = cmd;
        if (inspect())
            execute();
    }

    public abstract void execute();

    public abstract boolean inspect();
}
