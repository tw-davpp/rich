package tw.util;

import org.junit.Before;
import org.junit.Test;
import tw.Role;
import tw.game_command.ChoosePlayer;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class RoleDatabaseTest {
    List<Role> players;

    @Before
    public void set_up() {
        ChoosePlayer cp = new ChoosePlayer("12");
        players = cp.getPlayers();
    }

    @Test
    public void test_add_role() {
        Role role1 = players.get(0);
        assertThat(RoleDatabase.getRole(1), equalTo(role1));

        Role role2 = players.get(1);
        assertThat(RoleDatabase.getRole(2), equalTo(role2));
    }

    @Test
    public void test_role_symbol() {
        assertThat(RoleDatabase.getSymble(1),equalTo('Q'));
    }
}
