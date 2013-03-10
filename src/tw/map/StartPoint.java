package tw.map;

import tw.terrain.Starting;

public class StartPoint extends Terrain {
    public StartPoint(int id) {
        super(id);
        terrainUsage = new Starting();

    }
}
