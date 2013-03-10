package tw.game_command;

import tw.Role;
import tw.map.Map;
import tw.map.House;
import tw.map.Terrain;
import tw.round.Round;
import tw.tool.Bomb;
import tw.tool.RoadBlock;
import tw.tool.RoboticDoll;
import tw.tool.Tool;
import tw.util.IO;

import java.util.List;

public class QueryCmd implements Command {

    public static final int BLOCK_NUM = 1;
    public static final int ROBOT_NUM = 2;
    public static final int BOMB_NUM = 3;
    public static final int NOT_TOOL = 0;
    private Role role;
    private Map map;
    private List<Tool> tools;

    public QueryCmd(Map map) {
        Round round = map.round();
        role = round.getPresentRole();
        this.map = map;
        tools = role.tools();
    }

    public void show() {
        IO.outputLine("资金：" + money() + "元");
        IO.outputLine("点数：" + credit() + "点");
        IO.outputLine("地产：空地" + space() + "处；茅屋" + hut() + "处；洋房" + bungalow() + "处；摩天楼" + skyscraper() + "处。");
        IO.outputLine("道具：路障" + block() + "个；炸弹" + bomb() + "个；机器娃娃" + robotic() + "个。");
    }

    public int money() {
        return role.money();
    }

    public int credit() {
        return role.credit();
    }

    public List<Tool> tool() {
        return role.tools();
    }

    public int bomb() {
        int bomb = 0;
        for (Tool tool : tools) {
            if (tool instanceof Bomb)
                bomb++;
        }
        return bomb;
    }

    public int block() {
        int block = 0;
        for (Tool tool : tools) {
            if (tool instanceof RoadBlock)
                block++;
        }
        return block;
    }

    public int robotic() {
        int robotic = 0;
        for (Tool tool : tools) {
            if (tool instanceof RoboticDoll)
                robotic++;
        }
        return robotic;
    }

    public int space() {
        return getHouseCount(House.SPACE);
    }

    public int hut() {
        return getHouseCount(House.HUT);
    }

    public int skyscraper() {
        return getHouseCount(House.SKYSCRAPER);
    }

    public int bungalow() {
        return getHouseCount(House.BUNGALOW);
    }

    private int getHouseCount(int level) {
        int count = 0;
        for (Terrain terrain : map.getTerrains()) {
            if (terrain instanceof House) {
                House house = (House) terrain;
                if (house.owner() == role && house.level() == level)
                    count++;
            }
        }
        return count;
    }

    public int getTool(int toolId) {
        switch (toolId) {
            case BLOCK_NUM:
                return block();
            case ROBOT_NUM:
                return robotic();
            case BOMB_NUM:
                return bomb();
            default:
                return NOT_TOOL;
        }
    }

    @Override
    public void run() {
        show();
    }
}
