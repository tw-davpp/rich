package tw.map;


import tw.terrain.ToolShopping;

public class ToolShop extends Terrain {
    public ToolShop(int id) {
        super(id);
        terrainUsage = new ToolShopping();
    }
}
