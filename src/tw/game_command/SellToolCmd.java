package tw.game_command;

import tw.Role;
import tw.map.Map;
import tw.round.Round;
import tw.tool.Tool;
import tw.util.IO;

import java.util.List;

public class SellToolCmd implements Command {

    private Role role;
    private Map map;
    private int toolId;

    public SellToolCmd(Map map, String toolId) {
        this.map = map;
        this.toolId = Integer.parseInt(toolId);
    }

    private void sell() {
        List<Tool> tools = role.tools();
        for (int tool = 0; tool < tools.size(); tool++) {
            if (tools.get(tool).id() == toolId) {
                tools.remove(tool);
                break;
            }
        }
    }

    private boolean roleHasTool() {
        QueryCmd query = new QueryCmd(map);
        if (query.getTool(toolId) > 0) {
            return true;
        } else {
            prompt();
            return false;
        }
    }

    private void prompt() {
        IO.outputLine("没有该编号的道具");
    }

    @Override
    public void run() {
        Round round = map.round();
        role = round.getPresentRole();
        if (roleHasTool())
            sell();
    }
}
