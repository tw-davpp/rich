package tw.terrain;

import org.junit.Before;
import org.junit.Test;
import tw.Role;
import tw.map.House;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HouseUsageTest {
    int houseId;
    House house;
    HouseUsage hu;
    int roleId;
    Role owner;

    @Before
    public void set_up() {
        houseId = 1;
        house = new House(houseId, 600);
        hu = new HouseUsage(house);
        roleId = 1;
        owner = new Role(roleId, 10000, 100);
    }

    @Test
    public void test_purchase_while_house_is_space() {
        hu.setRole(owner);
        assertThat(hu.reconstruction(), is(PurchaseSpace.class));
    }

    @Test
    public void test_pay_rent_while_house_belong_to_other() {
        PurchaseSpace ps = new PurchaseSpace(owner, house);
        ps.reconstruction();
        assertThat(house.owner(), equalTo(owner));

        Role customer = new Role(roleId, 10000, 100);
        hu.setRole(customer);
        assertThat(hu.reconstruction(), is(PayRent.class));
    }

    @Test
    public void test_update_house_while_house_belong_to_owner() {
        PurchaseSpace ps = new PurchaseSpace(owner, house);
        ps.reconstruction();
        assertThat(house.owner(), equalTo(owner));

        hu.setRole(owner);
        assertThat(hu.reconstruction(), is(UpdateHouse.class));
    }
}
