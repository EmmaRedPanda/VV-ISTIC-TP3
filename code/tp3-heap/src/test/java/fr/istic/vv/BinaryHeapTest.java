package fr.istic.vv;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class BinaryHeapTest {

    @Test
    public void testPushAndCount() {
        BinaryHeap<Integer> heap = new BinaryHeap(Comparator.naturalOrder());

        heap.push(3);
        heap.push(1);
        heap.push(4);
        heap.push(1);


        assertEquals(4, heap.count());
    }

    @Test
    public void testPopAndPeekWhenHeapIsEmpty() {
        BinaryHeap<Integer> heap = new BinaryHeap(Comparator.naturalOrder());

        assertNull(heap.pop());
        assertNull(heap.peek());
        assertEquals(0, heap.count());
    }

    @Test
    public void testPushAndPop() {
        BinaryHeap<Integer> heap = new BinaryHeap(Comparator.naturalOrder());

        heap.push(3);
        heap.push(1);
        heap.push(4);

        assertEquals(Integer.valueOf(1), heap.pop());
        assertEquals(2, heap.count());
        assertEquals(Integer.valueOf(3), heap.pop());
        assertEquals(Integer.valueOf(4), heap.pop());
    }

    @Test
    public void testPushAndPeek() {
        BinaryHeap<Integer> heap = new BinaryHeap(Comparator.naturalOrder());

        heap.push(3);
        heap.push(1);
        heap.push(4);

        assertEquals(Integer.valueOf(1), heap.peek());
        assertEquals(3, heap.count());
    }

}