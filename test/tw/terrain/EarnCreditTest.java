package tw.terrain;

import org.junit.Test;
import tw.Role;
import tw.game_command.ChoosePlayer;
import tw.map.Mine;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class EarnCreditTest {
    @Test
    public void test_earn_credit() {
        ChoosePlayer cp = new ChoosePlayer("12");
        List<Role> players = cp.getPlayers();
        Role role = players.get(0);
        int mineId = 10;
        Mine mine = new Mine(mineId, 50);
        EarnCredit ec = new EarnCredit(role, mine);
        assertThat(role.credit(), equalTo(50));
    }
}
