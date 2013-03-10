package tw.terrain;

import org.junit.Before;
import org.junit.Test;
import tw.Role;
import tw.game_command.ChoosePlayer;
import tw.game_command.Walk;
import tw.map.Map;
import tw.map.House;
import tw.round.DayRound;
import tw.round.Round;
import tw.tool.BombUsage;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PayRentTest {
    House house;
    Role owner;
    Role customer;
    int houseId;
    private Map map;
    private Round round;
    List<Role> players;
    int landPrice;

    @Before
    public void set_up() {
        ChoosePlayer cp = new ChoosePlayer("12");
        players = cp.getPlayers();
        owner = players.get(0);
        customer = players.get(1);
        round = new DayRound(players);
        map = new Map(round);

        houseId = 2;
        house = (House) map.getTerrain(houseId);
        landPrice = house.landPrice();

        PurchaseSpace ps = new PurchaseSpace(owner, house);
        ps.reconstruction();
    }

    @Test
    public void test_pay_rent() {
        PayRent pr = new PayRent(customer, house);
        pr.reconstruction();
        assertThat(customer.money(), equalTo(10000 - landPrice / 2));
        assertThat(owner.money(), equalTo(10000 - landPrice + landPrice / 2));
    }

    @Test
    public void test_pay_rent_when_house_level_up() {
        UpdateHouse uh = new UpdateHouse(house);
        uh.reconstruction();

        PayRent pr = new PayRent(customer, house);
        pr.reconstruction();

        assertThat(customer.money(), equalTo(10000 - (landPrice / 2) * 2));
        assertThat(owner.money(), equalTo(10000 - landPrice * 2 + (landPrice / 2) * 2));
    }

    @Test
    public void test_free_when_owner_in_hospital() {
        BombUsage bu = new BombUsage(map);
        bu.usage(owner);
        assertThat(owner.isStay(), is(true));

        Walk walk = new Walk(customer, map, houseId);
        walk.terrainUsage();
        assertThat(customer.money(), equalTo(10000));
        assertThat(owner.money(), equalTo(10000 - landPrice));
    }

    @Test
    public void test_free_when_owner_in_prison() {
        Arrest arrest = new Arrest(owner);
        assertThat(owner.isStay(), is(true));

        Walk walk = new Walk(customer, map, houseId);
        walk.terrainUsage();
        assertThat(customer.money(), equalTo(10000));
        assertThat(owner.money(), equalTo(10000 - landPrice));
    }

    @Test
    public void test_free_when_custom_has_mascot() {
        ChooseMascot cm = new ChooseMascot(customer);
        cm.reward();

        Walk walk = new Walk(customer, map, houseId);
        walk.terrainUsage();
        assertThat(customer.money(), equalTo(10000));
        assertThat(owner.money(), equalTo(10000 - landPrice));
    }
}
