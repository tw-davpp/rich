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

public class CleanObstacleTest {
    @Test
    public void test_robotic_usage() {
        ChoosePlayer cp = new ChoosePlayer("12");
        List<Role> players = cp.getPlayers();
        Round round = new DayRound(players);
        Map map = new Map(round);

        Role role = players.get(0);
        int site = 10;
        int from = role.site();
        PlaceBlock pb = new PlaceBlock(map, from, site);
        assertThat(map.isEmpty(site), is(false));

        CleanObstacle ru = new CleanObstacle(from, map);
        assertThat(map.isEmpty(site), is(true));
    }
}
