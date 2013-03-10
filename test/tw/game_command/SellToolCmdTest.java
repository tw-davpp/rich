package tw.game_command;

import org.junit.Test;
import tw.Role;
import tw.map.Map;
import tw.round.DayRound;
import tw.terrain.PurchaseTool;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class SellToolCmdTest {
    @Test
    public void test_sell_tool() {
        ChoosePlayer cp = new ChoosePlayer("12");
        List<Role> players = cp.getPlayers();
        DayRound round = new DayRound(players);
        Map map = new Map(round);
        Role role = round.getPresentRole();
        role.setCredit(500);

        for (int i = 0; i < 3; i++)
            new PurchaseTool(role, 1);
        QueryCmd query = new QueryCmd(map);
        assertThat(query.block(), equalTo(3));

        SellToolCmd st = new SellToolCmd(map, "1");
        st.run();
        assertThat(query.block(), equalTo(2));
    }


}
