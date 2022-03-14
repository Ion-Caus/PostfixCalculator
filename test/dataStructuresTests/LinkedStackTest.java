package dataStructuresTests;

import dataStructures.LinkedStack;
import exceptions.EmptyListException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedStackTest {
    private LinkedStack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new LinkedStack<>();
    }

    @Test
    void isEmpty() {
        assertTrue(stack.isEmpty());
    }

    @Test
    void isNotEmpty() {
        stack.push(20);

        assertFalse(stack.isEmpty());
    }

    @Test
    void pushPop() {
        stack.push(10);

        assertEquals(10, stack.pop());
    }

    @Test
    void pushMany() {
        stack.push(10);
        stack.push(20);
        stack.push(30);

        assertEquals(30, stack.pop());
    }

    @Test
    void popException() {
        assertTrue(stack.isEmpty());
        assertThrows(
                EmptyStackException.class,
                () -> stack.pop()
        );
    }

}
