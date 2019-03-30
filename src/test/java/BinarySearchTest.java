import org.junit.Test;
import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void testSequence(){
        Integer[] ar = {1,2,3,4,5,6,7,8,9};
        assertEquals(2,BinarySearch.binarySearch(ar,0,ar.length-1,3));
    }

    @Test
    public void testMissingTooLarge(){
        Integer[] ar = {1,2,3,4,5,6,7,8,9};
        assertEquals(-1,BinarySearch.binarySearch(ar,0,ar.length-1,11));
    }

    @Test
    public void testSingletonArray(){
        Integer[] ar = {1};
        assertEquals(0,BinarySearch.binarySearch(ar,0,ar.length-1,1));
    }

    @Test
    public void testEmptyArray(){
        Integer[] ar = {};
        assertEquals(-1,BinarySearch.binarySearch(ar,0,ar.length-1,1));
    }

    @Test
    public void testSequenceOutOfOrder(){
        Integer[] ar = {9,8,7,6,5,4,3,2,1};
        assertEquals(-1,BinarySearch.binarySearch(ar,0,ar.length-1,3));
    }
}

