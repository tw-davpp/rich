package tw.terrain;

import tw.util.IO;
import tw.util.ToolDatabase;

public class ToolShopping extends TerrainUsage {
    private static final int TOOL_LIMIT = 10;
    private int toolId;

    private void prompt() {
        IO.outputLine("“欢迎光临道具屋， 请选择您所需要的道具：");
    }

    public void usage() {
        prompt();
        while (matchCondition()) {
            new PurchaseTool(role, toolId);
        }
    }

    private boolean matchCondition() {
        String line = IO.readLine();
        if ("f".equals(line.trim().toLowerCase()))
            return false;
        if (!isLessThanCheapestTool() && isLessThanLimitTools()) {
            toolId = Integer.parseInt(line);
            return true;
        } else
            return false;
    }

    public boolean isLessThanLimitTools() {
        return role.tools().size() < TOOL_LIMIT;
    }

    public boolean isLessThanCheapestTool() {
        return role.credit() < ToolDatabase.getCheapestValue();
    }

}
