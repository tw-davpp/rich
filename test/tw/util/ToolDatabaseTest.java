package tw.util;

import org.junit.Test;
import tw.tool.Bomb;
import tw.tool.RoadBlock;
import tw.tool.RoboticDoll;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ToolDatabaseTest {
    @Test
    public void test_tools_in_tool_terrain() {
        assertThat(ToolDatabase.getTool(1), is(RoadBlock.class));
        assertThat(ToolDatabase.getTool(2), is(RoboticDoll.class));
        assertThat(ToolDatabase.getTool(3), is(Bomb.class));
    }

    @Test
    public void test_cheapest_tool_value() {
        assertThat(ToolDatabase.getCheapestValue(), equalTo(30));
    }
}
