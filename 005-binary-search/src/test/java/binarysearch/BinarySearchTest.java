package binarysearch;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author Karol Meksuła
 * 14-03-2018
 * */

public class BinarySearchTest {
    private BinarySearch binarySearch;
    private int [] values;
    private final int lookingFor = 134;

    @Before
    public void setUp() {
        values = new int[100];
        for (int i = 0; i < 100; i++) {
            values[i] = i * 2;
        }
    }

    @Test
    public void testSchouldCorrectlyFindArgument() throws InterruptedException {
        int index = BinarySearch.binarySearchForInteger(lookingFor, values);
        assertEquals(67, index);
    }

}