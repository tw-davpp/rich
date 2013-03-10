package tw.map;

import tw.Role;
import tw.round.Round;
import tw.terrain.Hospital;
import tw.tool.Bomb;
import tw.tool.Tool;
import tw.util.RoleDatabase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Map {

    public static final int LIMIT = 69;
    public static final int HOSPITAL_SITE = 14;
    public static final int PRISON_SITE = 49;
    public static final int START_POINT = 0;
    private Round round;

    private List<Terrain> mapList;
    Tool[] toolList;
    String mapStr = "S0000000000000H0000000000000T000000G0000000000000P0000000000000M$$$$$$";
    int[] MINE_CREDIT = {20, 80, 100, 40, 80, 60};

    public Map(Round round) {
        this.round = round;
        init();
    }

    public Terrain getTerrain(int id) {
        return mapList.get(id);
    }

    private void init() {
        mapList = new ArrayList<Terrain>();
        int id = 0;
        mapList.add(new StartPoint(id++));
        for (; id <= 13; id++)
            mapList.add(new House(id, 200));
        mapList.add(new Hospital(id++));
        for (; id <= 27; id++)
            mapList.add(new House(id, 200));
        mapList.add(new ToolShop(id++));
        for (; id <= 34; id++)
            mapList.add(new House(id, 500));
        mapList.add(new GiftShop(id++));
        for (; id <= 48; id++)
            mapList.add(new House(id, 300));
        mapList.add(new Prison(id++, round));
        for (; id <= 62; id++)
            mapList.add(new House(id, 300));
        mapList.add(new MagicShop(id++));
        for (; id <= 69; id++)
            mapList.add(new Mine(id, MINE_CREDIT[id - 64]));

        toolList = new Tool[LIMIT + 1];

        for (Role role : RoleDatabase.getPlayers()) {
            role.setRound(round);
        }
    }

    public Tool getTool(int site) {
        return toolList[site];
    }

    public boolean isEmpty(int destination) {
        return nobody(destination) && noTool(destination);
    }

    private boolean noTool(int destination) {
        if (null == getTool(destination))
            return true;
        else
            return false;
    }

    private boolean nobody(int destination) {
        Collection<Role> players = RoleDatabase.getPlayers();
        for (Role player : players) {
            if (player.site() == destination)
                return false;
        }
        return true;
    }

    public void setTool(Tool tool, int destination) {
        toolList[destination] = tool;
    }

    public Round round() {
        return round;
    }

    public List<Terrain> getTerrains() {
        return mapList;
    }
}
