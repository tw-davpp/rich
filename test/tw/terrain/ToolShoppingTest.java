package tw.terrain;

import org.junit.Before;
import org.junit.Test;
import tw.Role;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ToolShoppingTest {
    int roleId;
    Role role;

    @Before
    public void set_up() {
        roleId = 1;
        role = new Role(roleId, 10000, 1000);
    }

    @Test
    public void test_could_not_purchase_when_role_have_more_than_ten_tools() {
        int toolId = 1;
        PurchaseTool pt = new PurchaseTool(role, toolId);
        for (int toolAmount = 0; toolAmount < 10; toolAmount++) {
            pt = new PurchaseTool(role, toolId);
        }
        ToolShopping ts = new ToolShopping();
        ts.setRole(role);
        assertThat(ts.isLessThanLimitTools(), equalTo(false));
    }

    @Test
    public void test_quit_when_role_have_enough_credit_to_buy_the_tool() {
        role = new Role(roleId, 10000, 20);
        ToolShopping ts = new ToolShopping();
        ts.setRole(role);
        assertThat(ts.isLessThanCheapestTool(), equalTo(true));
    }
}
