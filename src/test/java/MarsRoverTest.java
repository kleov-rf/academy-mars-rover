import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsRoverTest {
    @Test
    public void should_return_0_0_N_when_no_commands_given() {
        MarsRover rover = new MarsRover();

        String output = rover.run("");

        assertEquals("0:0:N", output);
    }
    @ParameterizedTest
    @CsvSource({
            "R, 0:0:E",
            "RR, 0:0:S",
            "RRR, 0:0:W",
            "RRRR, 0:0:N",
    })
    public void should_rotate_right_when_command_is_R(String input, String expectedOutput) {
        MarsRover rover = new MarsRover();

        String output = rover.run(input);

        assertEquals(expectedOutput, output);
    }

    @ParameterizedTest
    @CsvSource({
            "L, 0:0:W",
            "LL, 0:0:S",
            "LLL, 0:0:E",
    })
    public void should_rotate_left_when_command_is_L(String input, String expectedOutput) {
        MarsRover rover = new MarsRover();

        String output = rover.run(input);

        assertEquals(expectedOutput, output);
    }
    @ParameterizedTest
    @CsvSource({
            "LLR, 0:0:W",
            "RRL, 0:0:E",
            "RLLL, 0:0:S",
    })
    void should_be_able_to_turn_both_left_and_right(String input, String expectedOutput) {
        MarsRover rover = new MarsRover();

        String output = rover.run(input);

        assertEquals(expectedOutput, output);
    }

    @ParameterizedTest
    @CsvSource({
            "M, 0:1:N",
            "MM, 0:2:N",
            "MMM, 0:3:N"
    })
    void should_be_able_to_move_north(String input, String expectedOutput) {
        MarsRover rover = new MarsRover();

        String output = rover.run(input);

        assertEquals(expectedOutput, output);
    }

    @Test
    void should_be_able_to_move_south() {
        MarsRover rover = new MarsRover();

        String output = rover.run("MRRM");

        assertEquals("0:0:S", output);
    }

    @Test
    void should_be_able_to_move_east() {
        MarsRover rover = new MarsRover();

        String output = rover.run("RM");

        assertEquals("1:0:E", output);
    }

    @Test
    void should_be_able_to_move_west() {
        MarsRover rover = new MarsRover();

        String output = rover.run("RMLLM");

        assertEquals("0:0:W", output);
    }

    @Test
    void should_be_able_to_wrap_west_border() {
        MarsRover rover = new MarsRover();

        String output = rover.run("LM");

        assertEquals("9:0:W", output);
    }

    @Test
    void should_be_able_to_wrap_east_border() {
        MarsRover rover = new MarsRover();

        String output = rover.run("RMMMMMMMMMM");

        assertEquals("0:0:E", output);
    }
}
