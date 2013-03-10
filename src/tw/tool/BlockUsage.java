package tw.tool;

import tw.Role;
import tw.map.Map;

public class BlockUsage extends ToolUsage {
    private Map map;

    public BlockUsage(Map map) {
        this.map = map;
    }

    @Override
    public void usage(Role role) {
        stayHere(role);
    }

    private void stayHere(Role role) {
        role.setSite(role.site());
    }
}
