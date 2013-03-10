package tw.map;

import tw.Role;
import tw.util.IO;
import tw.util.RoleDatabase;

import java.awt.*;

public class ShowMap {
    private static final int UP_RIGHT_POINT = 28;
    private static final int UP_SITE = 0;
    private static final int DOWN_SITE = 7;
    private static final int START_POINT = 0;
    private static final int DOWN_RIGHT_POINT = 35;
    private static final int DOWN_LEFT_POINT = 63;
    private static final int DEFAULT_COLOR = 0;
    private Map map;
    private char[][] mapChar;
    private String[] mapString =
            {"S0000000000000H0000000000000T",
            "$                           0",
            "$                           0",
            "$                           0",
            "$                           0",
            "$                           0",
            "$                           0",
            "M0000000000000P0000000000000G"};
    private Color[][] mapColor;

    public ShowMap(Map map) {
        this.map = map;

    }

    public void show() {
        change();
        for (int column = 0; column < mapColor.length; column++) {
            for (int row = 0; row < mapColor[column].length; row++) {
                IO.setColor(mapColor[column][row]);
                IO.output(mapChar[column][row]+"");
            }
            IO.outputLine("");
        }
    }

    public String change() {
        initMap();

        changeLots();
        changeRoles();

        StringBuffer stringBuffer = new StringBuffer();
        for (int column = 0; column < mapChar.length; column++) {
            for (int row = 0; row < mapChar[column].length; row++) {
                stringBuffer.append(mapChar[column][row]);
            }
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }

    private void initMap() {
        mapChar = new char[mapString.length][];
        for (int column = 0; column < mapString.length; column++)
            mapChar[column] = mapString[column].toCharArray();
        mapColor = new Color[mapString.length][mapChar[0].length];

        for (int column = 0; column < mapColor.length; column++) {
            for (int row = 0; row < mapColor[column].length; row++) {
                mapColor[column][row] = RoleDatabase.getColor(DEFAULT_COLOR);
            }
        }
    }

    private void changeRoles() {
        for (Role role : RoleDatabase.getPlayers())
            setSymbolByMapId(role.site(), RoleDatabase.getSymble(role.id()),Color.WHITE);
    }

    private void changeLots() {
        for (Terrain terrain : map.getTerrains()) {
            if (terrain instanceof House) {
                House house = (House) terrain;
                Color color = RoleDatabase.getColor(DEFAULT_COLOR);
                if (house.owner()!=null)
                    color = RoleDatabase.getColor(house.owner().id());
                setSymbolByMapId(house.id, changeHouse(house),color);
            }
        }
    }

    private void setSymbolByMapId(int id, char symbol,Color color) {
        int row, column = START_POINT;
        if (id >= START_POINT && id <= UP_RIGHT_POINT) {
            column = UP_SITE;
            row = id;
        } else if (id > UP_RIGHT_POINT && id <= DOWN_RIGHT_POINT) {
            column = id - UP_RIGHT_POINT;
            row = UP_RIGHT_POINT;
        } else if (id >= DOWN_RIGHT_POINT && id <= DOWN_LEFT_POINT) {
            column = DOWN_SITE;
            row = id - (id - DOWN_RIGHT_POINT) * 2 - 7;
        } else {
            row = 0;
            column = id - (id - DOWN_LEFT_POINT) * 2 - 56;
        }
        mapChar[column][row] = symbol;
        mapColor[column][row] = color;
    }

    private char changeHouse(House house) {
        return (char) (house.level() + '0');
    }
}
