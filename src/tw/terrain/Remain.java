package tw.terrain;

import tw.Role;
import tw.round.Round;

public class Remain {
    private Role role;

    public Remain(Role role, int days) {
        this.role = role;
        stay(days);
    }

    private void stay(int days) {
        Round round = role.round();
        role.stay(round.getRound() + days);
    }

}
