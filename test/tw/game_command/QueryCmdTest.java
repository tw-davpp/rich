package tw.game_command;

import org.junit.Test;
import tw.Role;
import tw.map.Map;
import tw.map.House;
import tw.round.DayRound;
import tw.round.Round;
import tw.terrain.PurchaseSpace;
import tw.terrain.PurchaseTool;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class QueryCmdTest {
    @Test
    public void test_query() {
        ChoosePlayer cp = new ChoosePlayer("12");
        List<Role> players = cp.getPlayers();
        Round round = new DayRound(players);
        Map map = new Map(round);

        Role role = round.getPresentRole();
        role.setCredit(500);

        QueryCmd query = new QueryCmd(map);
        assertThat(query.money(), equalTo(10000));
        assertThat(query.credit(), equalTo(500));

        PurchaseTool pt = new PurchaseTool(role, 3);
        assertThat(query.bomb(), equalTo(1));

        for (int i = 0; i < 3; i++)
            pt = new PurchaseTool(role, 1);
        assertThat(query.block(), equalTo(3));

        for (int i = 0; i < 2; i++)
            pt = new PurchaseTool(role, 2);
        assertThat(query.robotic(), equalTo(2));

        assertThat(query.getTool(1), equalTo(3));

        PurchaseSpace ps = new PurchaseSpace(role, (House) map.getTerrain(2));
        ps.reconstruction();
        assertThat(query.space(), equalTo(1));
    }

}
