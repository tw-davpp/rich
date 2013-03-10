package tw.round;

import org.junit.Test;
import tw.Role;
import tw.game_command.ChoosePlayer;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class DayRoundTest {
    @Test
    public void test_round() {
        ChoosePlayer cp = new ChoosePlayer("123");
        List<Role> players = cp.getPlayers();
        Role role1 = players.get(0);
        Role role2 = players.get(1);
        Role role3 = players.get(2);
        DayRound round = new DayRound(players);
        assertThat(round.getRound(), equalTo(1));
        assertThat(round.getPresentRole(), equalTo(role1));
        round.nextRole();
        assertThat(round.getPresentRole(), equalTo(role2));
        round.nextRole();
        assertThat(round.getPresentRole(), equalTo(role3));

        round.nextRole();
        assertThat(round.getRound(), equalTo(2));
        assertThat(round.getPresentRole(), equalTo(role1));
        round.nextRole();
        assertThat(round.getPresentRole(), equalTo(role2));
        round.nextRole();
        assertThat(round.getPresentRole(), equalTo(role3));
    }

    @Test
    public void test_remove_role() {
        ChoosePlayer cp = new ChoosePlayer("123");
        List<Role> players = cp.getPlayers();
        Role role1 = players.get(0);
        DayRound round = new DayRound(players);
        round.remove(role1);
        assertThat(players.size(), equalTo(2));
    }
}
