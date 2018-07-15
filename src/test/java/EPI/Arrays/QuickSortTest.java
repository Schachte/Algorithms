package EPI.Arrays;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuickSortTest {
    QuickSort qs;

    @Before
    public void setup() {
        qs = new QuickSort();
    }

    @Test
    public void swap() {
        int[] inputArr = new int[]{1,2,3,4};
        assertTrue(inputArr[2] == 3);
        assertTrue(inputArr[3] == 4);
        qs.swap(inputArr, 2, 3);
        assertTrue(inputArr[2] == 4);
        assertTrue(inputArr[3] == 3);
    }

    @Test
    public void sort() {
        int[] inputArr = new int[]{4,3,2,1};
        qs.sort(inputArr, 0, inputArr.length - 1);
        for (int i = 0; i < inputArr.length; i++) {
            assertTrue(inputArr[i] == i+1);
        }
    }
}