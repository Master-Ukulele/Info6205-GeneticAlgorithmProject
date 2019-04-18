import org.junit.Test;
import team518.pack.*;
import java.util.*;
import static org.junit.Assert.assertTrue;

public class FortyMinesTest {

    @Test
    public void testFortyMines() {
        int N = 10, mineNumber = 40;
        Galaxy galaxy = new Galaxy(N, mineNumber);
        Arrays.sort(galaxy.getMine_array(), (Mine m1, Mine m2)
                -> Double.compare(m2.getRadiation(), m1.getRadiation()));
        OutPut.paralel(galaxy);

        assertTrue("10 ships, 40 mines failed", OutPut.j / mineNumber < 0.05);
    }
}
