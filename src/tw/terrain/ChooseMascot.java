package tw.terrain;

import tw.God.Mascot;
import tw.Role;

public class ChooseMascot implements ChooseGift {
    private static final int FIVE_ROUND = 5;
    private Role role;

    public ChooseMascot(Role role) {
        this.role = role;
    }

    @Override
    public void reward() {
        role.setGod(new Mascot());
        role.godProcessed(FIVE_ROUND);
    }

}
