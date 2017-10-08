package nl.sourcelabs.se.week5.monday.assignment1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverserTest {

    private Reverser reverser = new Reverser();

    @Test
    public void testReverseHello() {
        assertEquals("HELLO", reverser.reverse("OLLEH"));
    }

    @Test
    public void testReverseHelloCase() {
        assertEquals("HeLLo", reverser.reverse("oLLeH"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testReverseNullParameter() {
        reverser.reverse(null);
    }
}