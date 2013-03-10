package tw.map;

import tw.Role;
import tw.map.Terrain;
import tw.terrain.HouseUsage;
import tw.util.RichDatabase;

public class House extends Terrain {
    public static final int SPACE = 0;
    public static final int HUT = 1;
    public static final int BUNGALOW = 2;
    public static final int SKYSCRAPER = 3;
    private int landPrice;
    private Role owner;
    private int level;

    public House(int houseId, int landPrice) {
        super(houseId);
        this.landPrice = landPrice;
        terrainUsage = new HouseUsage(this);
        RichDatabase.addHouse(houseId, this);
    }

    public Role owner() {
        return owner;
    }

    public int landPrice() {
        return landPrice;
    }

    public void setOwner(Role owner) {
        this.owner = owner;
    }

    public int level() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}
