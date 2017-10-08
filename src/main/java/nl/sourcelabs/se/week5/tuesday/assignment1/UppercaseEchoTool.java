package nl.sourcelabs.se.week5.tuesday.assignment1;

import java.util.Scanner;

/**
 * Test this class. It takes a line from the console, reads it and then
 * prints it out after converting it to uppercase.
 * 
 * Write a test for this class. Run the main to find out how it should work. 
 * (Hint: It requires user input from the console)
 */
public class UppercaseEchoTool {
    
    private ConsoleReader consoleReader;

    // Constructor, takes a consolereader as a parameter
    public UppercaseEchoTool(final ConsoleReader consoleReader) {
        this.consoleReader = consoleReader;
    }
    
    // This is the method to be tested, reads a line and outputs it converted to uppercase.
    public String readAndEchoLine() {
        final String line = consoleReader.readLine();
        return line.toUpperCase();
    }

    // Main function, run this to test this class
    public static void main(final String[] args) {
        UppercaseEchoTool reader = new UppercaseEchoTool(new ConsoleReader());
        System.out.println(reader.readAndEchoLine());
    }
}
