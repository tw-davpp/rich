package tw.terrain;

import tw.God.Mascot;
import tw.Role;
import tw.map.Map;
import tw.map.House;
import tw.util.IO;

public class PayRent extends HouseReconstruction {
    private Role customer;
    private House house;

    public PayRent(Role customer, House house) {
        this.customer = customer;
        this.house = house;
    }

    @Override
    public void reconstruction() {
        int money = (house.landPrice() / 2) * (house.level() + 1);
        customer.setMoney(customer.money() - money);
        Role owner = house.owner();
        owner.setMoney(owner.money() + money);
    }

    @Override
    public void prompt() {
    }

    @Override
    public boolean matchCondition() {
        if (customer.god() instanceof Mascot) {
            godPrompt();
            return false;
        }

        if (InHospital(house.owner()) || InPrison(house.owner()))
            return false;
        else
            return true;
    }

    private void godPrompt() {
        IO.outputLine("福神附身，可免过路费");
    }

    private boolean InPrison(Role owner) {
        return owner.isStay() && owner.site() == Map.PRISON_SITE;
    }

    private boolean InHospital(Role owner) {
        return owner.isStay() && owner.site() == Map.HOSPITAL_SITE;
    }
}
