package nl.sourcelabs.se.week5.tuesday.assignment1;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//Tells Junit to run this test with the MockitoJUnitRunner
@RunWith(MockitoJUnitRunner.class)
public class UppercaseEchoToolTest {

    @Mock //Creates a new mock for the consolereader
    private ConsoleReader consoleReader;

    @InjectMocks //Injects all mocks into the UppercaseEchoTool
    private UppercaseEchoTool uppercaseEchoTool;

    @Test
    public void shouldReadAndEchoLine() {
        //when the readline method on the consoleReader is called, then let it return "uppercase"
        when(consoleReader.readLine()).thenReturn("uppercase");
        String result = uppercaseEchoTool.readAndEchoLine();
        assertEquals("UPPERCASE", result);
        //verifies that the consoleReader readline method is called exactly once
        verify(consoleReader).readLine();
    }

    @Test
    public void shouldReadAndEchoLine2() {
        when(consoleReader.readLine()).thenReturn("upper%case");
        String result = uppercaseEchoTool.readAndEchoLine();
        assertEquals("UPPER%CASE", result);
        //verifies that the consoleReader readLine method is called exactly once
        verify(consoleReader, times(1)).readLine();
    }
}