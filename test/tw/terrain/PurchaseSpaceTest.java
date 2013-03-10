package tw.terrain;

import org.junit.Test;
import tw.Role;
import tw.map.House;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class PurchaseSpaceTest {
    @Test
    public void test_purchase_space() {
        int houseId = 10;
        House house = new House(houseId, 600);
        int roleId = 1;
        Role role = new Role(roleId, 10000, 100);
        PurchaseSpace ps = new PurchaseSpace(role, house);
        ps.reconstruction();
        assertThat(house.owner(), equalTo(role));
        assertThat(role.money(), equalTo(9400));
    }
}
