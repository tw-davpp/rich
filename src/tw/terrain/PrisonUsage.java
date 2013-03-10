package tw.terrain;

import tw.round.Round;

public class PrisonUsage extends TerrainUsage {
    private Round round;

    public PrisonUsage(Round round) {
        this.round = round;
    }

    @Override
    public void usage() {
        new Arrest(role);
    }
}
