package tw.terrain;

import tw.map.House;

public class HouseUsage extends TerrainUsage {
    private House house;

    public HouseUsage(House house) {
        this.house = house;
    }

    @Override
    public void usage() {
        HouseReconstruction hr = reconstruction();
        hr.execute();
    }

    public HouseReconstruction reconstruction() {
        if (house.owner() == null)
            return new PurchaseSpace(role, house);
        else if (house.owner() != role) {
            return new PayRent(role, house);
        } else {
            return new UpdateHouse(house);
        }
    }
}
