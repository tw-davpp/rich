package tw.tool;

import tw.Role;

public abstract class Tool {
    protected int id;
    protected int value;
    protected String name;
    protected ToolUsage toolUsage;

    abstract public void usage(Role role);

    public int value() {
        return value;
    }

    public String name() {
        return name;
    }

    public int id() {
        return id;
    }
}
