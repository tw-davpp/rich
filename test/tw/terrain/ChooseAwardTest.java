package tw.terrain;

import org.junit.Test;
import tw.Role;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ChooseAwardTest {
    @Test
    public void test_choose_award() {
        int roleId = 1;
        Role role = new Role(roleId, 10000, 100);
        ChooseAward ga = new ChooseAward(role);
        ga.reward();
        assertThat(role.money(), equalTo(12000));
    }
}
