package tw.terrain;

import tw.map.Mine;

public class MineUsage extends TerrainUsage {
    private Mine mine;

    public MineUsage(Mine mine) {
        super();
        this.mine = mine;
    }

    @Override
    public void usage() {
        new EarnCredit(role, mine);
    }
}
