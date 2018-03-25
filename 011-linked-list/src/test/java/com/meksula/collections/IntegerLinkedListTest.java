package com.meksula.collections;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 25-03-2018
 * */

public class IntegerLinkedListTest {
    private IntegerLinkedList list = new IntegerLinkedList();

    private void fillList() {
        list.putElement(10);
        list.putElement(17);
        list.putElement(179);
        list.putElement(299);
    }

    @Test
    public void listShouldBeAbleToHoldItem() {
        fillList();
        assertEquals(4, list.size());
    }
}