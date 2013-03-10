package tw.round;

import tw.Role;

import java.util.List;

public class DayRound implements Round {
    private int round;
    private final List<Role> roles;
    private int presentRole;

    public DayRound(List<Role> roles) {
        this.roles = roles;
        round = 1;
    }

    @Override
    public int getRound() {
        return round;
    }

    @Override
    public void nextRole() {
        presentRole++;
        if (presentRole >= roles.size()) {
            presentRole = 0;
            round++;
        }
    }

    public Role getPresentRole() {
        return roles.get(presentRole);
    }

    @Override
    public void remove(Role role) {
        if (getPresentRole() == role) {
            roles.remove(presentRole);
            presentRole--;
        }
        for (int player = 0; player < roles.size(); player++) {
            if (role == roles.get(player)) {
                roles.remove(player);
                break;
            }
        }
    }
}
