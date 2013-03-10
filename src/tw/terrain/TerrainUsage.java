package tw.terrain;

import tw.Role;

public abstract class TerrainUsage {
    protected Role role;

    public abstract void usage();

    public void setRole(Role role) {
        this.role = role;
    }
}
