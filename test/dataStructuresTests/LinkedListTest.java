package dataStructuresTests;

import dataStructures.LinkedList;
import exceptions.EmptyListException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {
    private LinkedList<Integer> linkedList;

    @BeforeEach
    void setUp() {
        this.linkedList = new LinkedList<>();
    }

    @Test
    void isEmpty() {
        assertTrue(linkedList.isEmpty());
    }

    @Test
    void isNotEmpty() {
        linkedList.addToFront(1);
        linkedList.addToFront(2);

        assertFalse(linkedList.isEmpty());
    }

    @Test
    void size() {
        linkedList.addToFront(1);
        linkedList.addToFront(2);
        linkedList.addToFront(3);

        assertEquals(3, linkedList.size());
    }

    @Test
    void addToFrontOne() {
        linkedList.addToFront(10);

        assertFalse(linkedList.isEmpty());
        assertEquals(1, linkedList.size());
    }

    @Test
    void addToFrontMany() {
        linkedList.addToFront(10);
        linkedList.addToFront(20);
        linkedList.addToFront(30);

        assertFalse(linkedList.isEmpty());
        assertEquals(3, linkedList.size());
    }

    @Test
    void removeFirst() {
        linkedList.addToFront(10);
        linkedList.addToFront(20);

        try {
            linkedList.removeFirst();
        }
        catch (EmptyListException ignored) {}
        assertEquals(1, linkedList.size());
    }

    @Test
    void removeFirstException() {
        assertEquals(0, linkedList.size());
        Assertions.assertThrows(
                EmptyListException.class,
                () -> linkedList.removeFirst()
        );
    }

}
