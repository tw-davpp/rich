package tw.util;

import enigma.console.Console;
import enigma.console.TextAttributes;
import enigma.core.Enigma;
import org.junit.Test;

import java.awt.*;

public class EnigmaTest {
    @Test
    public void test_enigma() {
        TextAttributes textAttributes = new TextAttributes(Color.BLUE, Color.WHITE);
        Console console = Enigma.getConsole("Hellow World!");
        console.setTextAttributes(textAttributes);
        System.out.println("Hello World! 你好么?");

    }

    public static void main(String[] args) {
        Console console = Enigma.getConsole("Hellow World!");
        TextAttributes textAttributes = new TextAttributes(Color.BLUE, Color.BLACK);
        console.setTextAttributes(textAttributes);
        System.out.print("Hello World! 你好么?");
        textAttributes = new TextAttributes(Color.RED);
        console.setTextAttributes(textAttributes);
        System.out.println("hello too");

        String str = console.readLine();

        System.out.println("ok");


    }
}
