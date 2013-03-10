package tw.map;

import org.junit.Test;
import tw.Role;
import tw.game_command.ChoosePlayer;
import tw.game_command.Walk;
import tw.round.DayRound;
import tw.round.Round;
import tw.terrain.PurchaseSpace;
import tw.terrain.UpdateHouse;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ShowMapTest {
    @Test
    public void test_show_map() {
        ChoosePlayer cp = new ChoosePlayer("12");
        List<Role> players = cp.getPlayers();
        Round round = new DayRound(players);
        Map map = new Map(round);

        Role role = players.get(0);
        PurchaseSpace ps = new PurchaseSpace(role, (House) map.getTerrain(1));
        ps.reconstruction();
        UpdateHouse uh = new UpdateHouse((House) map.getTerrain(1));
        uh.reconstruction();

        Walk walk = new Walk(role, map, 2);

        String mapStr = "A1Q00000000000H0000000000000T\n" +
                        "$                           0\n" +
                        "$                           0\n" +
                        "$                           0\n" +
                        "$                           0\n" +
                        "$                           0\n" +
                        "$                           0\n" +
                        "M0000000000000P0000000000000G\n";

        ShowMap showMap = new ShowMap(map);
        assertThat(showMap.change(), equalTo(mapStr));
    }
}
