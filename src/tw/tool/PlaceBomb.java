package tw.tool;

import tw.map.Map;

public class PlaceBomb extends PlaceTool {
    public PlaceBomb(Map map, int from, int to) {
        super(new Bomb(new BombUsage(map)), map, from, to);
    }
}
