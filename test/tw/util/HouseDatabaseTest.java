package tw.util;

import org.junit.Test;
import tw.map.House;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class HouseDatabaseTest {
    @Test
    public void test_add_house() {
        int houseId = 10;
        House house = new House(houseId, 600);
        assertThat(house, equalTo(RichDatabase.getHouse(houseId)));
    }
}
