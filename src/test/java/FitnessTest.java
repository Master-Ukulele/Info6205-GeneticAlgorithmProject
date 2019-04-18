import org.junit.Test;
import team518.pack.*;

import static org.junit.Assert.*;

public class FitnessTest {

    @Test
    public void testSingleMineFitness() {

        Mine mine = new Mine();
        mine.setxPosition(1);
        mine.setyPosition(1);
        mine.setzPosition(1);
        mine.setRadiation(1);
        Individual individual = new Individual();
        individual.setxPosition(0);
        individual.setyPosition(0);
        individual.setzPosition(0);
        assertEquals(3, Fitness.fit(individual, mine), 0.1);
    }
}
