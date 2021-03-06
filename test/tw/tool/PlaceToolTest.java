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

public class PlaceToolTest {
    @Test
    public void test_place_tool() {
        ChoosePlayer cp = new ChoosePlayer("12");
        List<Role> players = cp.getPlayers();
        Round round = new DayRound(players);
        Map map = new Map(round);
        int site = map.LIMIT - 2;
        int from = 0;
        int to = -3;
        Tool tool = new Bomb();
        PlaceTool pt = new PlaceTool(tool, map, from, to);
        assertThat(map.getTool(site), is(Tool.class));
    }
}
