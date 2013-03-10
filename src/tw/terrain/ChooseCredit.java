package tw.terrain;

import tw.Role;

public class ChooseCredit implements ChooseGift {
    private static final int CREDIT_AWARD = 200;
    private Role role;

    public ChooseCredit(Role role) {
        this.role = role;
    }

    @Override
    public void reward() {
        role.setCredit(role.credit() + CREDIT_AWARD);
    }
}
