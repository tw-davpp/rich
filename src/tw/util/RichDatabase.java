package tw.util;

import tw.map.House;

import java.util.TreeMap;

public class RichDatabase {
    static TreeMap<Integer, House> map = new TreeMap<Integer, House>();

    public static House getHouse(int houseId) {
        return map.get(houseId);
    }

    public static void addHouse(int houseId, House house) {
        map.put(houseId, house);
    }
}
