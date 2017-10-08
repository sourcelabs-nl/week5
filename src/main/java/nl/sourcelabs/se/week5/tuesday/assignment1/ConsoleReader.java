package nl.sourcelabs.se.week5.tuesday.assignment1;

import java.util.Scanner;

/**
 * Ignore this delegate class - focus on testing the UppercaseEchoTool :)
 */
public class ConsoleReader {

    private Scanner scanner = new Scanner(System.in);

    public String readLine() {
        return scanner.nextLine();
    }
}
