package tw.terrain;

import tw.map.HospitalUsage;
import tw.map.Terrain;
import tw.terrain.TerrainUsage;

public class Hospital extends Terrain {
    public Hospital(int id) {
        super(id);
        terrainUsage = new HospitalUsage();
    }

}
