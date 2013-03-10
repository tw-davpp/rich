package tw.round;

import tw.Role;

public interface Round {
    void nextRole();

    int getRound();

    Role getPresentRole();

    void remove(Role role);
}
