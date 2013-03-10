package tw.game_command;

import tw.Role;
import tw.map.Map;
import tw.map.House;
import tw.map.Terrain;
import tw.round.Round;

public class Broken {
    private final Role role;
    private final Map map;

    public Broken(Role role, Map map) {
        this.role = role;
        this.map = map;
        cleanHouse();
        removeRole();
    }

    private void removeRole() {
        Round round = map.round();
        round.remove(role);
    }

    private void cleanHouse() {
        for (Terrain terrain : map.getTerrains()) {
            if (terrain instanceof House) {
                House house = (House) terrain;
                if (house.owner() == role) {
                    house.setLevel(House.SPACE);
                    house.setOwner(null);
                }
            }
        }
    }

}
