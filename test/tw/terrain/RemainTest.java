package tw.terrain;

import org.junit.Test;
import tw.Role;
import tw.game_command.ChoosePlayer;
import tw.map.Map;
import tw.round.DayRound;
import tw.round.Round;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RemainTest {
    @Test
    public void test_Remain() {
        ChoosePlayer cp = new ChoosePlayer("12");
        List<Role> players = cp.getPlayers();
        Round round = new DayRound(players);
        Map map = new Map(round);

        Role role1 = players.get(0);
        Role role2 = players.get(1);
        Remain remain = new Remain(role2, 2);
        round.nextRole();
        nextRound(round);
        nextRound(round);
        assertThat(round.getPresentRole(), equalTo(role2));
        assertThat(role2.isStay(), is(true));
        round.nextRole();

        assertThat(round.getPresentRole(), equalTo(role1));
        assertThat(role2.isStay(), is(true));

        round.nextRole();
        assertThat(round.getPresentRole(), equalTo(role2));
        assertThat(role2.isStay(), is(false));
    }

    private void nextRound(Round round) {
        round.nextRole();
        round.nextRole();
    }
}
