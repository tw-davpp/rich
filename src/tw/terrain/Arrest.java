package tw.terrain;

import tw.Role;
import tw.map.Map;

public class Arrest {
    private static final int TWO_DAYS = 2;

    public Arrest(Role role) {
        moveToPrison(role);
        Remain remain = new Remain(role, TWO_DAYS);
    }

    private void moveToPrison(Role role) {
        role.setSite(Map.PRISON_SITE);
    }
}
