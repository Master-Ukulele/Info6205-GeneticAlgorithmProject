import org.junit.Test;
import team518.pack.Galaxy;
import team518.pack.Mine;
import team518.pack.OutPut;
import java.util.Arrays;
import static org.junit.Assert.assertTrue;

public class OneHundAndTwentyMinesTest {

    @Test
    public void test120Mines() {
        int N = 30, mineNumber = 120;
        Galaxy galaxy = new Galaxy(N, mineNumber);
        Arrays.sort(galaxy.getMine_array(), (Mine m1, Mine m2)
                -> Double.compare(m2.getRadiation(), m1.getRadiation()));
        OutPut.parallel(galaxy);
        System.out.println(OutPut.j+1);

        assertTrue("30 ships, 120 mines failed", (double)(OutPut.j+1) / (double) mineNumber < 0.05);
    }
}
