package nl.sourcelabs.se.week5.tuesday.assignment1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UpperCaseEchoToolTestManual {

    private InstrumentableConsoleReader reader = new InstrumentableConsoleReader();
    private UppercaseEchoTool uppercaseEchoTool = new UppercaseEchoTool(reader);

    @Test
    public void testUppercaseTool() {
        reader.setExpectedValue("Jarno");
        assertEquals("JARNO", uppercaseEchoTool.readAndEchoLine());
    }

    @Test
    public void testUpperCaseEmptyString() {
        reader.setExpectedValue("");
        assertEquals("", uppercaseEchoTool.readAndEchoLine());
    }

    static class InstrumentableConsoleReader extends ConsoleReader {

        private String expectedValue;

        public void setExpectedValue(String expectedValue) {
            this.expectedValue = expectedValue;
        }

        @Override
        public String readLine() {
            return expectedValue;
        }
    }
}
