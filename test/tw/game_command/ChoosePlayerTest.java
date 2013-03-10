package tw.game_command;

import org.junit.Test;
import tw.Role;
import tw.util.RoleDatabase;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ChoosePlayerTest {
    @Test
    public void test_choose_player() {
        ChoosePlayer cp = new ChoosePlayer("21");
        List<Role> players = cp.getPlayers();
        assertThat(players.get(0), equalTo(RoleDatabase.getRole(1)));
        assertThat(players.get(1), equalTo(RoleDatabase.getRole(2)));
    }
}
