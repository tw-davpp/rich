package tw.game_command;

import tw.Role;
import tw.map.Map;
import tw.tool.PlaceBlock;

public class PlaceBlockCmd implements Command {
    private final Map map;
    private final String next;

    public PlaceBlockCmd(Map map, String next) {
        this.map = map;
        this.next = next;
    }

    @Override
    public void run() {
        int to = Integer.parseInt(next);
        Role role = map.round().getPresentRole();
        new PlaceBlock(map, role.site(), to);
    }
}
