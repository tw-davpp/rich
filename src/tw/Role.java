package tw;

import tw.God.God;
import tw.game_command.Broken;
import tw.round.Round;
import tw.tool.Tool;
import tw.util.RoleDatabase;

import java.util.ArrayList;
import java.util.List;

public class Role {
    private int id;
    private int money;
    private int credit;
    private List<Tool> tools;
    private God god;
    public static int initialCapital = 10000;
    public static int initialCredit;
    private int site;
    private int stayDays;
    private boolean out;
    private Round round;
    private int godStayDays;

    public Role(int id, int initialCapital, int initialCredit) {
        this.id = id;
        this.money = initialCapital;
        this.credit = initialCredit;
        out = true;
        tools = new ArrayList<Tool>();
        RoleDatabase.addRole(id, this);
    }

    public Role(int id) {
        this(id, initialCapital, initialCredit);
    }

    public int money() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public List tools() {
        return tools;
    }

    public int credit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void addTool(Tool tool) {
        tools.add(tool);
    }

    public God god() {
        if (!hasGod())
            god = null;
        return god;
    }

    public void setGod(God god) {
        this.god = god;
    }

    public int site() {
        return site;
    }

    public void setSite(int site) {
        this.site = site;
    }

    public boolean isStay() {
        if (stayDays >= round.getRound()) {
            if (out || stayDays == round.getRound() && this == round.getPresentRole()) {
                out = true;
                return false;
            }
            return true;
        } else
            return false;
    }

    public void stay(int days) {
        out = false;
        stayDays = days + 1;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public Round round() {
        return round;
    }

    public void godProcessed(int rounds) {
        godStayDays = rounds + round.getRound() + 1;
    }

    public boolean hasGod() {
        if (godStayDays > round.getRound())
            return true;
        else
            return false;
    }

    public int id() {
        return id;
    }
}
