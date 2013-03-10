package tw.util;

import org.junit.Test;

import java.awt.*;

public class IOTest {
    @Test
    public void test_IO() {
        IO.setColor(Color.RED);
        IO.output("hello");
    }

    public static void main(String[] args) {
        IO.setColor(Color.RED);
        IO.output("hello");
    }
}
