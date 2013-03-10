package tw.game_command;

import tw.map.Map;
import tw.map.ShowMap;
import tw.round.Round;
import tw.util.IO;

public class RollCmd implements Command {
    private int steps;
    private Map map;
    private Walk walk;

    public RollCmd(Map map) {
        this.map = map;
    }

    public int steps() {
        return steps;
    }

    private int randomSteps() {
        return (int) (Math.random() * 10 % 6 + 1);
    }

    @Override
    public void run() {
        steps = randomSteps();
        Round round = map.round();
        walk = new Walk(round.getPresentRole(), map, steps);
        showMap();
        round.nextRole();
    }

    public void terrainUsage() {
        walk.terrainUsage();
    }

    private void showMap() {
        ShowMap showMap = new ShowMap(map);
        IO.outputLine(showMap.change());
    }
}
