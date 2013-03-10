package tw.terrain;

import org.junit.Test;
import tw.God.Mascot;
import tw.Role;
import tw.game_command.ChoosePlayer;
import tw.map.Map;
import tw.round.DayRound;
import tw.round.Round;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ChooseMascotTest {
    @Test
    public void test_choose_mascot() {
        ChoosePlayer cp = new ChoosePlayer("12");
        List<Role> players = cp.getPlayers();
        Round round = new DayRound(players);
        Map map = new Map(round);
        Role role = players.get(0);

        ChooseMascot cm = new ChooseMascot(role);
        cm.reward();
        assertThat(role.hasGod(), is(true));
        assertThat(role.god(), is(Mascot.class));
        for (int r = 0; r < 5; r++)
            nextRound(round);
        assertThat(round.getPresentRole(), equalTo(role));
        assertThat(role.hasGod(), is(true));
        nextRound(round);
        assertThat(role.hasGod(), is(false));
        assertThat(role.god(), equalTo(null));
    }

    private void nextRound(Round round) {
        round.nextRole();
        round.nextRole();
    }
}
