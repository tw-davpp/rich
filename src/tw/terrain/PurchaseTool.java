package tw.terrain;

import tw.Role;
import tw.tool.Tool;
import tw.util.IO;
import tw.util.ToolDatabase;

public class PurchaseTool {
    private final int toolId;
    private static final int TOOL_LIMIT = 10;
    private final Role role;

    public PurchaseTool(Role role, int toolId) {
        this.role = role;
        this.toolId = toolId;
        purchase();
    }

    private void purchase() {
        Tool tool = ToolDatabase.getTool(toolId);
        if (tool.value() <= role.credit()) {
            role.addTool(tool);
            role.setCredit(role.credit() - tool.value());
        } else lackOfCredit();
    }

    private void lackOfCredit() {
        IO.outputLine("您当前剩余的点数为" + role.credit() + "， 不足以购买" + ToolDatabase.getTool(toolId).name() + "道具。");
    }

}
