package tw.game_command;

import org.junit.Before;
import org.junit.Test;
import tw.Role;
import tw.map.Map;
import tw.round.DayRound;
import tw.tool.*;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WalkTest {
    ChoosePlayer cp;
    List<Role> players;
    Role role;
    Map map;

    @Before
    public void set_up() {
        cp = new ChoosePlayer("12");
        players = cp.getPlayers();
        role = players.get(0);
        map = new Map(new DayRound(players));
    }

    @Test
    public void test_walk() {
        Walk walk = new Walk(role, map, 2);
        assertThat(role.site(), equalTo(2));

        walk = new Walk(role, map, 3);
        assertThat(role.site(), equalTo(5));
    }

    @Test
    public void test_meet_road_block() {
        int from = 0;
        int to = 3;
        PlaceBlock placeBlock = new PlaceBlock(map, from, to);
        assertThat(map.getTool(to), is(RoadBlock.class));
        int steps = 5;
        Walk walk = new Walk(role, map, steps);
        assertThat(role.site(), equalTo(to));
    }

    @Test
    public void test_meet_bomb() {
        int from = 0;
        int to = 2;
        PlaceBomb placeBomb = new PlaceBomb(map, from, to);
        assertThat(map.getTool(to), is(Bomb.class));
        int steps = 5;
        Walk walk = new Walk(role, map, steps);
        assertThat(role.site(), equalTo(map.HOSPITAL_SITE));
        assertThat(role.isStay(), is(true));
    }



}
