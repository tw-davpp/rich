package tw.game_command;

import tw.Role;
import tw.map.Map;
import tw.tool.PlaceBomb;

public class PlaceBombCmd implements Command {
    private final Map map;
    private final String next;

    public PlaceBombCmd(Map map, String next) {
        this.map = map;
        this.next = next;
    }

    @Override
    public void run() {
        int to = Integer.parseInt(next);
        Role role = map.round().getPresentRole();
        new PlaceBomb(map, role.site(), to);
    }
}
