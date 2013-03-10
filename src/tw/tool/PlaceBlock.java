package tw.tool;

import tw.map.Map;

public class PlaceBlock extends PlaceTool {
    public PlaceBlock(Map map, int from, int to) {
        super(new RoadBlock(new BlockUsage(map)), map, from, to);
    }
}
