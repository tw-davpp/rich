package tw.tool;

import tw.Role;

public class RoadBlock extends Tool {
    public RoadBlock() {
        id = 1;
        value = 50;
        name = "路障";
    }

    public RoadBlock(ToolUsage toolUsage) {
        this();
        this.toolUsage = toolUsage;
    }

    @Override
    public void usage(Role role) {
        toolUsage.usage(role);
    }
}
