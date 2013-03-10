package tw.game_command;

import org.junit.Test;
import tw.Role;
import tw.map.Map;
import tw.round.DayRound;
import tw.util.RoleDatabase;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class RollCmdTest {
    @Test
    public void test_roll() {
        ChoosePlayer cp = new ChoosePlayer("12");
        List<Role> players = cp.getPlayers();
        Map map = new Map(new DayRound(players));
        Role role1 = players.get(0);
        Role role2 = players.get(1);
        assertThat(role1, equalTo(RoleDatabase.getRole(1)));

        RollCmd roll = new RollCmd(map);
        roll.run();

        assertThat(role1.site(), equalTo(roll.steps()));
        assertThat(map.round().getPresentRole(), equalTo(role2));
    }
}
