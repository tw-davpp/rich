package tw.terrain;

import tw.Role;
import tw.map.House;
import tw.util.IO;

public class UpdateHouse extends HouseReconstruction {
    private static final int TOP_LEVEL = 3;
    private House house;

    public UpdateHouse(House house) {
        this.house = house;
    }

    @Override
    public void reconstruction() {
        if (house.level() < TOP_LEVEL) {
            house.setLevel(house.level() + 1);
            deduct();
        }
    }

    @Override
    public void prompt() {
        System.out.println("是否升级该处地产，" + house.landPrice() + "元（Y/N）");
    }

    @Override
    public boolean matchCondition() {
        String line = IO.readLine();
        return "y".equals(line.trim().toLowerCase());
    }

    private void deduct() {
        Role role = house.owner();
        role.setMoney(role.money() - house.landPrice());
    }
}
