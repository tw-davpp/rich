package tw.game_command;

import org.junit.Test;
import tw.Role;
import tw.map.House;
import tw.map.Map;
import tw.round.DayRound;
import tw.round.Round;
import tw.terrain.PurchaseSpace;
import tw.terrain.UpdateHouse;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class SellHouseCmdTest {
    @Test
    public void test_sell_house() {
        ChoosePlayer cp = new ChoosePlayer("12");
        Round round = new DayRound(cp.getPlayers());
        Map map = new Map(round);
        Role owner = round.getPresentRole();
        int houseId = 2;
        House house = (House) map.getTerrain(houseId);
        PurchaseSpace ps = new PurchaseSpace(owner, house);
        ps.reconstruction();
        UpdateHouse uh = new UpdateHouse(house);
        uh.reconstruction();

        SellHouseCmd sh = new SellHouseCmd(map, houseId + "");
        sh.run();

        int price = house.landPrice();
        assertThat(owner.money(), equalTo(10000 - price * 2 + price * 2 * 2));
        assertThat(house.owner(), equalTo(null));
        assertThat(house.level(), equalTo(0));
    }
}
