package tw.game_command;

import org.junit.Test;
import tw.map.Map;
import tw.round.DayRound;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CommandParserTest {
    @Test
    public void test_command_parser() {
        ChoosePlayer cp = new ChoosePlayer("12");
        Map map = new Map(new DayRound(cp.getPlayers()));
        CommandParser.setMap(map);

        String strCmd = "roll";
        Command cmd = CommandParser.parse(strCmd);
        assertThat(cmd, is(RollCmd.class));

        strCmd = "block 2";
        cmd = CommandParser.parse(strCmd);
        assertThat(cmd, is(PlaceBlockCmd.class));

        strCmd = "bomb 3";
        cmd = CommandParser.parse(strCmd);
        assertThat(cmd, is(PlaceBombCmd.class));

        strCmd = "robot";
        cmd = CommandParser.parse(strCmd);
        assertThat(cmd, is(RoboticCmd.class));

        strCmd = "sell 1";
        cmd = CommandParser.parse(strCmd);
        assertThat(cmd, is(SellHouseCmd.class));

        strCmd = "sellTool 1";
        cmd = CommandParser.parse(strCmd);
        assertThat(cmd, is(SellToolCmd.class));

        strCmd = "query";
        cmd = CommandParser.parse(strCmd);
        assertThat(cmd, is(QueryCmd.class));

        strCmd = "help";
        cmd = CommandParser.parse(strCmd);
        assertThat(cmd, is(HelpCmd.class));
    }
}
