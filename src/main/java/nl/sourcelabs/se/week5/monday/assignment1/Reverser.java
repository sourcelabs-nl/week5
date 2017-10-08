package nl.sourcelabs.se.week5.monday.assignment1;

/**
 * Assignment: Test this class. Define test cases and test if everything works as expected.
 * 
 * Reverser class, for some reversing awesomeness
 */
public class Reverser {

    /**
     * Method that reverses the input string.
     *
     * @param source
     *         the string to reverse
     *         
     * @return the source string reversed
     */
    public String reverse(final String source) {
        final StringBuilder result = new StringBuilder();
        for (int i = source.length(); i > 0; i--) {
            result.append(source.charAt(i));
        }
        return result.toString();
    }
}
