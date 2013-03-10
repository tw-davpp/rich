package tw.tool;

import org.junit.Test;
import tw.Role;
import tw.game_command.ChoosePlayer;
import tw.map.Map;
import tw.round.DayRound;
import tw.round.Round;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BombUsageTest {
    @Test
    public void test_bomb_usage() {
        ChoosePlayer cp = new ChoosePlayer("12");
        List<Role> players = cp.getPlayers();
        Round round = new DayRound(players);
        Map map = new Map(round);
        Role role = players.get(0);

        BombUsage bu = new BombUsage(map);
        bu.usage(role);
        assertThat(role.site(), equalTo(map.HOSPITAL_SITE));
        assertThat(role.isStay(), is(true));
        nextRound(round);
        assertThat(role.isStay(), is(true));
        nextRound(round);
        assertThat(role.isStay(), is(true));
        nextRound(round);
        assertThat(role.isStay(), is(true));
        nextRound(round);
        assertThat(role.isStay(), is(false));
    }

    private void nextRound(Round round) {
        round.nextRole();
        round.nextRole();
    }
}
