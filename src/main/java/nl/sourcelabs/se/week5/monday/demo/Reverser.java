package nl.sourcelabs.se.week5.monday.demo;

/**
 * Define test cases and test if everything works as expected.
 * 
 * Reverser class, for some reversing awesomeness
 */
public class Reverser {

    /**
     * Method that reverses the input string.
     *
     * @param source
     *         the string to reverse
     *         hello
     * @return the source string reversed
     * @throws IllegalArgumentException when source null is null
     */
    public String reverse(final String source) {
        if(source == null) {
            throw new IllegalArgumentException("Source cannot be null");
        }
        
        final StringBuilder result = new StringBuilder();
        for (int i = source.length() - 1; i >= 0; i--) {
            result.append(source.charAt(i));
        }
        return result.toString();
    }
}