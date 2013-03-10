package tw.map;

import org.junit.Test;
import tw.Role;
import tw.game_command.ChoosePlayer;
import tw.round.DayRound;
import tw.round.Round;
import tw.terrain.Hospital;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MapTest {
    @Test
    public void test_map() {
        ChoosePlayer cp = new ChoosePlayer("1");
        List<Role> players = cp.getPlayers();
        Round round = new DayRound(players);
        Map map = new Map(round);

        assertThat(map.getTerrain(0), is(StartPoint.class));
        assertThat(map.getTerrain(1), is(House.class));
        assertThat(map.getTerrain(13), is(House.class));
        assertThat(map.getTerrain(14), is(Hospital.class));
        assertThat(map.getTerrain(27), is(House.class));
        assertThat(map.getTerrain(28), is(ToolShop.class));
        assertThat(map.getTerrain(34), is(House.class));
        assertThat(map.getTerrain(35), is(GiftShop.class));
        assertThat(map.getTerrain(48), is(House.class));
        assertThat(map.getTerrain(49), is(Prison.class));
        assertThat(map.getTerrain(62), is(House.class));
        assertThat(map.getTerrain(63), is(MagicShop.class));
        assertThat(map.getTerrain(69), is(Mine.class));
    }

}
