package tw.terrain;

import tw.Role;
import tw.map.Mine;

public class EarnCredit {

    public EarnCredit(Role role, Mine mine) {
        role.setCredit(role.credit() + mine.credit());
    }
}
