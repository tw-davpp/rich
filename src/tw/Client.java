package tw;

import tw.game_command.*;
import tw.map.Map;
import tw.map.ShowMap;
import tw.round.DayRound;
import tw.round.Round;
import tw.util.IO;
import tw.util.RoleDatabase;

import java.util.List;

public class Client {
    private Round round;
    private Map map;
    private List<Role> players;

    public Client() {
        init();
        run();
    }

    private void run() {
        while (true) {
            if (winner())
                break;
            ShowMap showMap = new ShowMap(map);
            showMap.show();
            Role player = round.getPresentRole();
            IO.outputLine(RoleDatabase.getName(player.id()) + ">");
            Command cmd = CommandParser.parse(IO.readLine());
            cmd.run();
            if (cmd instanceof RollCmd) {
                RollCmd rollCmd = (RollCmd) cmd;
                rollCmd.terrainUsage();
            }
        }
    }

    private boolean winner() {
        if (players.size() > 1)
            return false;
        else
            return true;
    }

    private void init() {
        initialCapital();
        choosePlayer();
        initMap();
    }

    private void initMap() {
        map = new Map(round);
        CommandParser.setMap(map);
    }

    private void choosePlayer() {
        IO.outputLine("请选择2~4位不重复玩家，输入编号即可。(1.钱夫人; 2.阿土伯; 3.孙小美; 4.金贝贝):");
        ChoosePlayer choosePlayer = new ChoosePlayer(IO.readLine());
        players = choosePlayer.getPlayers();
        round = new DayRound(players);
    }

    private void initialCapital() {
        IO.outputLine("设置玩家初始资金，范围1000～50000（默认10000）");
        InitialCapital initialCapital = new InitialCapital(IO.readLine());
    }

    public static void main(String[] args) {
        Client client = new Client();
    }
}
