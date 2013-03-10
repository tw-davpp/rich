package tw.game_command;

import org.junit.Test;
import tw.Role;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class InitialCapitalTest {
    @Test
    public void test_initial_capital() {
        InitialCapital ic = new InitialCapital("20000");
        ChoosePlayer cp = new ChoosePlayer("12");
        List<Role> players = cp.getPlayers();
        Role role = players.get(0);
        assertThat(role.money(), equalTo(20000));
    }

    @Test
    public void test_default_initial_capital() {
        InitialCapital ic = new InitialCapital("");
        ChoosePlayer cp = new ChoosePlayer("12");
        List<Role> players = cp.getPlayers();
        Role role = players.get(0);
        assertThat(role.money(), equalTo(10000));
    }
}
