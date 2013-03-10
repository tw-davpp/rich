package tw.map;

import tw.terrain.MagicShopping;

public class MagicShop extends Terrain {
    public MagicShop(int id) {
        super(id);
        terrainUsage = new MagicShopping();
    }
}
