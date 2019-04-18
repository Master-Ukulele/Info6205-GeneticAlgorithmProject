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
        assertEquals(3, Fitness.fit(individual, mine), 0.01);
    }

    @Test
    public void testTwoMinesFitness() {
        Mine[] mines = new Mine[2];
        for (int i = 0; i < 2; i++) {
            mines[i] = new Mine();
            mines[i].setRadiation(i + 2);
            mines[i].setxPosition(i + 2);
            mines[i].setyPosition(i + 2);
            mines[i].setzPosition(i + 2);
        }
        Individual individual = new Individual();
        individual.setxPosition(0);
        individual.setyPosition(0);
        individual.setzPosition(0);
        assertEquals(6, Fitness.fit(individual, mines), 0.01);
    }
}
