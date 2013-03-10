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

public class ArrestTest {
    @Test
    public void test_arrest() {
        ChoosePlayer cp = new ChoosePlayer("12");
        List<Role> players = cp.getPlayers();
        Round round = new DayRound(players);
        Map map = new Map(round);

        Role role1 = players.get(0);
        Arrest arrest = new Arrest(role1);
        assertThat(role1.site(), equalTo(map.PRISON_SITE));
        assertThat(role1.isStay(), is(true));
        nextRound(round);
        assertThat(role1.isStay(), is(true));
        nextRound(round);
        assertThat(role1.isStay(), is(true));
        nextRound(round);
        assertThat(role1.isStay(), is(false));
    }

    private void nextRound(Round round) {
        round.nextRole();
        round.nextRole();
    }
}
