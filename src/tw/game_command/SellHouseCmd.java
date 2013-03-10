package tw.game_command;

import tw.Role;
import tw.game_command.Command;
import tw.map.House;
import tw.map.Map;
import tw.map.Terrain;
import tw.util.RichDatabase;

public class SellHouseCmd implements Command {
    public static final int DOUBLE = 2;
    private int houseId;
    private Map map;

    public SellHouseCmd(Map map, String houseId) {
        this.map = map;
        this.houseId = Integer.parseInt(houseId);
    }

    public void sell() {
        Terrain terrain = map.getTerrain(houseId);
        if (terrain instanceof House) {
            House house = (House) terrain;
            Role owner = house.owner();
            int money = house.landPrice() * DOUBLE * (house.level() + 1);
            owner.setMoney(owner.money() + money);
            house.setOwner(null);
            house.setLevel(house.SPACE);
        }
    }

    @Override
    public void run() {
        sell();
    }
}
