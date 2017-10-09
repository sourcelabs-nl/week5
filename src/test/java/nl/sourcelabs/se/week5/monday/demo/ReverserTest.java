package nl.sourcelabs.se.week5.monday.demo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ReverserTest {
    
    @Test
    public void testReverseHallo() {
        assertEquals("ollah", new Reverser().reverse("hallo"));
    }
    
    @Test
    public void testReverseHallO() {
        assertEquals("OllaH", new Reverser().reverse("HallO"));
    }
    
    @Test
    public void testEmptyString() {
        assertEquals("", new Reverser().reverse(""));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testNullValue() { 
        assertNull(new Reverser().reverse(null)); 
    }
}