package tw.tool;

import tw.Role;
import tw.map.Map;
import tw.terrain.Remain;

public class BombUsage extends ToolUsage {
    private static final int THREE_DAY = 3;
    private Map map;

    public BombUsage(Map map) {
        this.map = map;
    }

    @Override
    public void usage(Role role) {
        moveToHospital(role);
        Remain remain = new Remain(role, THREE_DAY);
    }

    private void moveToHospital(Role role) {
        role.setSite(map.HOSPITAL_SITE);
    }
}
