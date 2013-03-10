package tw.game_command;

import org.junit.Test;
import tw.Role;
import tw.map.Map;
import tw.round.DayRound;
import tw.round.Round;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class BrokenTest {
    @Test
    public void test_broken() {
        ChoosePlayer cp = new ChoosePlayer("123");
        List<Role> players = cp.getPlayers();
        Round round = new DayRound(players);
        Map map = new Map(round);
        Role role1 = players.get(0);
        Role role2 = players.get(1);

        Broken broken = new Broken(role1, map);
        round.nextRole();
        assertThat(round.getPresentRole(), equalTo(role2));
        round.nextRole();
        round.nextRole();
        assertThat(round.getPresentRole(), equalTo(role2));
    }

}
