package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {
    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"2"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(2));
    }

    @Test
    public void whenMultiValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"2", "1", "3"}
        );
        ValidateInput input = new ValidateInput(out, in);
        assertThat(
                input.askInt("Enter menu:"),
                is(2)
        );
        assertThat(
                input.askInt("Enter menu:"),
                is(1)
        );
        assertThat(
                input.askInt("Enter menu:"),
                is(3)
        );
    }

    @Test
    public void whenNegNumberInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"-2"}
        );
        ValidateInput input = new ValidateInput(out, in);
        assertThat(
                input.askInt("Enter menu:"),
                is(-2)
        );
    }
}