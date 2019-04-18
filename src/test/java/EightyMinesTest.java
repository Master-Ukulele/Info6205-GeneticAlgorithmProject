import org.junit.Test;
import team518.pack.Galaxy;
import team518.pack.Mine;
import team518.pack.OutPut;
import java.util.Arrays;
import static org.junit.Assert.assertTrue;

public class EightyMinesTest {

    @Test
    public void testEightyMines() {
        int N = 20, mineNumber = 80;
        Galaxy galaxy = new Galaxy(N, mineNumber);
        Arrays.sort(galaxy.getMine_array(), (Mine m1, Mine m2)
                -> Double.compare(m2.getRadiation(), m1.getRadiation()));
        OutPut.paralel(galaxy);
        System.out.println(OutPut.j+1);

        assertTrue("20 ships, 80 mines failed", (double)(OutPut.j+1) / (double)mineNumber < 0.05);
    }
}
