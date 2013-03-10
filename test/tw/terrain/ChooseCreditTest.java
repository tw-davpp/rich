package tw.terrain;

import org.junit.Test;
import tw.Role;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ChooseCreditTest {
    @Test
    public void test_choose_credit() {
        int roleId = 1;
        Role role = new Role(roleId, 10000, 100);
        ChooseCredit cc = new ChooseCredit(role);
        cc.reward();
        assertThat(role.credit(), equalTo(300));
    }
}
