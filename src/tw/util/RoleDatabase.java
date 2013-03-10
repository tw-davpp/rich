package tw.util;

import tw.Role;

import java.awt.*;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RoleDatabase {
    private static Map<Integer, Role> roles = new TreeMap<Integer, Role>();
    private static String[] names = {"", "钱夫人", "阿土伯", "孙小美", "金贝贝"};
    private static char[] symbol = {' ', 'Q', 'A', 'S', 'J'};
    private static Color[] colors = {Color.WHITE, Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW};

    public static Collection<Role> getPlayers() {
        return roles.values();
    }

    public static Role getRole(int id) {
        return roles.get(id);
    }

    public static void addRole(int id, Role role) {
        roles.put(id, role);
    }

    public static String getName(int id) {
        return names[id];
    }

    public static char getSymble(int id) {
        return symbol[id];
    }

    public static Color getColor(int id) {
        return colors[id];
    }


    public static void clean() {
        roles = new TreeMap<Integer, Role>();
    }
}
