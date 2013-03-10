package tw.terrain;

import tw.Role;
import tw.map.House;
import tw.util.IO;

public class PurchaseSpace extends HouseReconstruction {
    private final Role role;
    private final House house;

    public PurchaseSpace(Role role, House house) {
        this.role = role;
        this.house = house;
    }

    private void deduct() {
        role.setMoney(role.money() - house.landPrice());
    }

    @Override
    public void reconstruction() {
        deduct();
        house.setOwner(role);
    }

    @Override
    public void prompt() {
        IO.outputLine("是否购买该处空地，" + house.landPrice() + "元（Y/N）");
    }

    @Override
    public boolean matchCondition() {
        String line = IO.readLine();
        return "y".equals(line.trim().toLowerCase());
    }
}
