package tw.map;

import tw.terrain.GiftShopping;

public class GiftShop extends Terrain {
    public GiftShop(int id) {
        super(id);
        terrainUsage = new GiftShopping();
    }
}
