package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {
    private Stack stack;

    @Before
    public void setUp() {
        stack = new Stack();
    }


    @Test
    public void testPushPeek() {
        for (int i = 0; i < 15; i++) {
            stack.push(i);
            assertEquals(i, stack.peek());
        }
        for (int j = 14; j > 10; j--) {
            assertEquals(14, stack.peek());
        }
    }

    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPop() {
        for (int i = 0; i < 15; i++) {
            stack.push(i);
        }
        for (int j = 14; j >= 0; j--) {
            assertEquals(j, stack.pop());
        }
        assertTrue(stack.isEmpty());
    }
}