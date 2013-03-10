package tw.game_command;

import tw.Role;
import tw.map.Map;
import tw.map.Terrain;
import tw.terrain.TerrainUsage;
import tw.tool.Tool;

public class Walk {

    private static final int START_POINT = 0;
    private Role role;
    private Map map;

    public Walk(Role role, Map map, int steps) {
        this.role = role;
        this.map = map;

        for (int step = 0; step < steps; step++) {
            forward();
            if (usageTool())
                break;
        }
    }

    public void terrainUsage() {
        Terrain terrain = map.getTerrain(role.site());
        TerrainUsage tu = terrain.usage();
        tu.setRole(role);
        tu.usage();
        if (0 > role.money()) {
            Broken broken = new Broken(role, map);
        }
    }

    private boolean usageTool() {
        Tool tool = map.getTool(role.site());
        if (tool == null)
            return false;
        else {
            tool.usage(role);
            return true;
        }
    }

    private void forward() {
        role.setSite(role.site() + 1);
        if (role.site() > map.LIMIT)
            role.setSite(START_POINT);
    }

}
