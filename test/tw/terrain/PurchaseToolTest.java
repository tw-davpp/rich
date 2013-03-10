package tw.terrain;

import org.junit.Before;
import org.junit.Test;
import tw.Role;
import tw.tool.RoadBlock;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PurchaseToolTest {
    int roleId;
    Role role;

    @Before
    public void set_up() {
        roleId = 1;
        role = new Role(roleId, 10000, 1000);
    }

    @Test
    public void test_purchase_tool() {
        int toolId = 1;
        PurchaseTool pt = new PurchaseTool(role, toolId);
        assertThat(role.tools().size(), equalTo(1));
        assertThat(role.tools().get(0), is(RoadBlock.class));
        assertThat(role.credit(), equalTo(1000 - 50));
    }
}
