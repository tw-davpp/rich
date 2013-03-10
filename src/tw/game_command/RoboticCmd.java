package tw.game_command;

import tw.map.Map;

public class RoboticCmd implements Command {
    private Map map;

    public RoboticCmd(Map map) {
        this.map = map;
    }

    @Override
    public void run() {
        QueryCmd query = new QueryCmd(map);
        if (query.robotic() > 0) {

        }
    }
}
