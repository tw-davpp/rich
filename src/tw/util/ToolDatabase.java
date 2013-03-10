package tw.util;

import tw.tool.Bomb;
import tw.tool.RoadBlock;
import tw.tool.RoboticDoll;
import tw.tool.Tool;

import java.util.TreeMap;

public class ToolDatabase {
    private static TreeMap<Integer, Tool> map = new TreeMap<Integer, Tool>();

    static {
        map.put(1, new RoadBlock());
        map.put(2, new RoboticDoll());
        map.put(3, new Bomb());
    }

    public static Tool getTool(int toolId) {
        return map.get(toolId);
    }

    public static int getCheapestValue() {
        int min = Integer.MAX_VALUE;
        for (Tool tool : map.values()) {
            min = Math.min(min, tool.value());
        }
        return min;
    }
}
