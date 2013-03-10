package tw.tool;

import org.junit.Test;
import tw.Role;
import tw.game_command.ChoosePlayer;
import tw.map.Map;
import tw.round.DayRound;
import tw.round.Round;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PlaceBombTest {
    @Test
    public void test_plce_bomb() {
        ChoosePlayer cp = new ChoosePlayer("12");
        List<Role> players = cp.getPlayers();
        Round round = new DayRound(players);
        Map map = new Map(round);
        int site = map.LIMIT;
        int from = 0;
        int to = -1;
        PlaceBomb pt = new PlaceBomb(map, from, to);
        assertThat(map.getTool(site), is(Bomb.class));
    }
}
