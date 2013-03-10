package tw.map;

import tw.terrain.MineUsage;

public class Mine extends Terrain {
    private int credit;

    public Mine(int id, int Credit) {
        super(id);
        credit = Credit;
        terrainUsage = new MineUsage(this);
    }

    public int credit() {
        return credit;
    }
}
