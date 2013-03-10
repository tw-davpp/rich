package tw.tool;

import tw.Role;

public class Bomb extends Tool {
    public Bomb() {
        id = 3;
        value = 50;
        name = "炸弹";
    }

    public Bomb(ToolUsage toolUsage) {
        this();
        this.toolUsage = toolUsage;
    }

    @Override
    public void usage(Role role) {
        toolUsage.usage(role);
    }
}
