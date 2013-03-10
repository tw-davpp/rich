package tw.game_command;

import tw.map.Map;

import java.util.Scanner;

public class CommandParser {
    private static Map map;
    private static String rollCmd = "roll";
    private static final String BLOCK_CMD = "block";
    private static final String BOMB_CMD = "bomb";
    private static final String ROBOTIC_CMD = "robot";
    private static final String SELL_HOUSE_CMD = "sell";
    private static final String SELL_TOOL_CMD = "sellTool";
    private static final String QUERY_CMD = "query";
    private static final String HELP_CMD = "help";

    public static Command parse(String strCmd) {
        Scanner scanner = new Scanner(strCmd);
        String cmd = scanner.next();
        if (rollCmd.equals(cmd))
            return new RollCmd(map);
        else if (BLOCK_CMD.equals(cmd))
            return new PlaceBlockCmd(map, scanner.next());
        else if (BOMB_CMD.equals(cmd))
            return new PlaceBombCmd(map, scanner.next());
        else if (ROBOTIC_CMD.equals(cmd))
            return new RoboticCmd(map);
        else if (SELL_HOUSE_CMD.equals(cmd))
            return new SellHouseCmd(map, scanner.next());
        else if (SELL_TOOL_CMD.equals(cmd))
            return new SellToolCmd(map, scanner.next());
        else if (QUERY_CMD.equals(cmd))
            return new QueryCmd(map);
        else if (HELP_CMD.equals(cmd))
            return new HelpCmd();
        return null;
    }

    public static void setMap(Map map) {
        CommandParser.map = map;
    }
}
