package tw.game_command;

import tw.Role;

public class InitialCapital extends GameCommand {
    private static final int DEFAULT_INITIAL_CAPITAL = 10000;

    public InitialCapital(String cmd) {
        super(cmd);
    }

    @Override
    public void execute() {
        if ("".equals(cmd.trim()))
            Role.initialCapital = DEFAULT_INITIAL_CAPITAL;
        else
            Role.initialCapital = Integer.parseInt(cmd);
    }

    @Override
    public boolean inspect() {
        if ("".equals(cmd.trim()))
            return true;
        int money = Integer.parseInt(cmd);
        if (money >= 1000 && money <= 50000)
            return true;
        return false;
    }
}
