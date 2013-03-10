package tw.terrain;

import tw.Role;

public class ChooseAward implements ChooseGift {
    private static final int AWARD = 2000;
    private Role role;

    public ChooseAward(Role role) {
        this.role = role;
    }

    @Override
    public void reward() {
        role.setMoney(role.money() + AWARD);
    }
}
