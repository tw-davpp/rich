package tw.util;

import enigma.console.Console;
import enigma.console.TextAttributes;
import enigma.core.Enigma;

import java.awt.*;

public class IO {
    private static final Console console;

    static {
        console = Enigma.getConsole("rich");
        setColor(Color.WHITE);
    }

    public static void setColor(Color color) {
        TextAttributes textAttributes = new TextAttributes(color);
        console.setTextAttributes(textAttributes);
    }

    public static String readLine() {
        return console.readLine();
    }

    public static void output(String str) {
        System.out.print(str);
    }

    public static void outputLine(String line) {
        System.out.println(line);
    }
}
