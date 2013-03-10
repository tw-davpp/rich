package tw.tool;

import tw.map.Map;

public class PlaceTool {
    protected Tool tool;
    protected Map map;

    public PlaceTool(Tool tool, Map map, int from, int to) {
        this.map = map;
        int destination = from + to;
        destination = getDestination(map, destination);
        if (inMap(destination) && isEmpty(destination))
            place(tool, destination);
    }

    private int getDestination(Map map, int destination) {
        if (destination < 0)
            destination = map.LIMIT + destination + 1;
        else
            destination = destination % map.LIMIT;
        return destination;
    }

    private boolean inMap(int destination) {
        return destination >= 0 && destination <= map.LIMIT;
    }

    private void place(Tool tool, int destination) {
        map.setTool(tool, destination);
    }

    private boolean isEmpty(int destination) {
        return map.isEmpty(destination);
    }
}
