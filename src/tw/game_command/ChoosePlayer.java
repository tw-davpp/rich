package tw.game_command;

import tw.Role;
import tw.util.RoleDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChoosePlayer extends GameCommand {
    private List<Role> players;

    public ChoosePlayer(String cmd) {
        super(cmd);
    }

    public List<Role> getPlayers() {
        return players;
    }

    @Override
    public void execute() {
        RoleDatabase.clean();
        players = new ArrayList<Role>();
        char[] array = cmd.toCharArray();
        Arrays.sort(array);
        for (char c : array) {
            players.add(new Role(c - '0'));
        }
    }

    @Override
    public boolean inspect() {
        char[] array = cmd.toCharArray();
        Arrays.sort(array);
        if (inspectCount(array)) return false;
        if (inspectRepeat(array)) return false;
        if (inspectNumber(array)) return false;
        return true;
    }

    private boolean inspectNumber(char[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < '0' || array[i] > '9')
                return true;
        }
        return false;
    }

    private boolean inspectRepeat(char[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1])
                return true;
        }
        return false;
    }

    private boolean inspectCount(char[] array) {
        if (array.length < 2 || array.length > 4)
            return true;
        return false;
    }
}
