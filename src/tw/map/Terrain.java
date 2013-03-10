package tw.map;

import tw.terrain.TerrainUsage;

public abstract class Terrain {
    protected int id;
    protected TerrainUsage terrainUsage;

    public Terrain(int id) {
        this.id = id;
    }

    public TerrainUsage usage() {
        return terrainUsage;
    }
}
