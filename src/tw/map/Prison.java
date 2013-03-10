package tw.map;

import tw.round.Round;
import tw.terrain.PrisonUsage;

public class Prison extends Terrain {
    public Prison(int id, Round round) {
        super(id);
        terrainUsage = new PrisonUsage(round);
    }
}
