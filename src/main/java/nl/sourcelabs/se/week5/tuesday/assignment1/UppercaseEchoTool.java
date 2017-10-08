package nl.sourcelabs.se.week5.tuesday.assignment1;

import java.util.Scanner;

public class UppercaseEchoTool {
    
    private ConsoleReader consoleReader;

    public UppercaseEchoTool(ConsoleReader consoleReader) {
        this.consoleReader = consoleReader;
    }
    
    public String readAndEchoLine() {
        final String line = consoleReader.readLine();
        return line.toUpperCase();
    }

    public static void main(String[] args) {
        UppercaseEchoTool reader = new UppercaseEchoTool(new ConsoleReader());
        System.out.println(reader.readAndEchoLine());
    }
}
