import org.junit.Test;
import team518.pack.*;
import java.util.Arrays;
import static org.junit.Assert.*;

public class SingleMineTest {

    @Test
    public void testSingleMine() {
        int N = 200;
        Galaxy galaxy = new Galaxy(N);
        Individual[] aux = new Individual[galaxy.getIndividuals().length];
        System.arraycopy(galaxy.getIndividuals(), 0, aux, 0, aux.length);
        for (int i = 0; i < 5000; i++) {
            Species.select(galaxy.getIndividuals(), aux, galaxy.getMine());
        }
        Arrays.sort(galaxy.getIndividuals());
//        for (Individual a: aux) System.out.println(a.getRadiationStrength());
        double res = galaxy.getIndividuals()[N/10].getRadiationStrength();
        assertTrue("1/10 of individuals' radiation is equal or less than 5e-3.", res < 0.005);
    }

}
