package tw.tool;

import tw.map.Map;

public class CleanObstacle {
    private static final int ROBOTIC_STEPS = 10;

    public CleanObstacle(int from, Map map) {
        clean(from, map);
    }

    private void clean(int from, Map map) {
        for (int step = 1; step <= ROBOTIC_STEPS; step++) {
            map.setTool(null, from + step);
        }
    }
}
