package dataStructuresTests;

import dataStructures.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NodeTest {
    private Node<Integer> node;

    @BeforeEach
    void setUp() {
        this.node = new Node<>(-1);
    }

    @Test
    void getSetData() {
        node.setData(10);
        assertEquals(10, node.getData());
    }

    @Test
    void setDataMany() {
        node.setData(10);
        assertEquals(10, node.getData());

        // many
        node.setData(1);
        node.setData(2);
        assertEquals(2, node.getData());
    }

    @Test
    void getSetNext() {
        node.setData(10);

        Node<Integer> next = new Node<>(15);
        node.setNext(next);

        assertEquals(15, node.getNext().getData());
    }
}
