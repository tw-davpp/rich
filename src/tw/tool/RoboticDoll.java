package tw.tool;

import tw.Role;
import tw.map.Map;

public class RoboticDoll extends Tool {
    private Map map;

    public RoboticDoll() {
        id = 2;
        value = 30;
        name = "机器娃娃";
    }

    public RoboticDoll(Map map) {
        this.map = map;
    }

    @Override
    public void usage(Role role) {
        new CleanObstacle(role.site(), map);
    }
}
