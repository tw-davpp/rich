package tw.terrain;

import org.junit.Before;
import org.junit.Test;
import tw.Role;
import tw.map.House;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class UpdateHouseTest {
    House house;
    int roleId;
    Role role;
    private int houseId;

    @Before
    public void set_up() {
        houseId = 10;
        house = new House(houseId, 600);
        roleId = 1;
        role = new Role(roleId, 10000, 100);
        PurchaseSpace ps = new PurchaseSpace(role, house);
        ps.reconstruction();
    }

    @Test
    public void test_update_house() {
        UpdateHouse updateHouse = new UpdateHouse(house);
        updateHouse.reconstruction();
        assertThat(house.level(), equalTo(1));
        int money = 10000 - 600 * 2;
        assertThat(role.money(), equalTo(money));
    }

    @Test
    public void test_could_not_update_when_the_house_level_more_than_three() {
        for (int level = 0; level < 10; level++) {
            UpdateHouse updateHouse = new UpdateHouse(house);
            updateHouse.reconstruction();
        }
        assertThat(house.level(), equalTo(3));
        int money = 10000 - 4 * 600;
        assertThat(role.money(), equalTo(money));
    }
}
