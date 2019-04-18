package team518.pack;

import java.util.*;

public class Fitness {

    /**
     * This class is used only for calculating ship's fitness
     */

    // Calculate ship's fitness with single mine
    public static double fit(Individual individual, Mine mine) {

        /**
         * @param d    Distance between the ship and the mine
         * @param R    Mine's radiation
         * Fitness is evaluated as mine's radiation, R, divided by distance squared, d^2,
         * namely, fitness = R / d^2
         */

        double fitness;
        double d;
        double R = mine.getRadiation();
        double x = individual.getxPosition(), y = individual.getyPosition(), z = individual.getzPosition(),
                X = mine.getxPosition(), Y = mine.getyPosition(), Z = mine.getzPosition();
        double x_d = X - x;
        double y_d = Y - y;
        double z_d = Z - z;
        d = Math.sqrt(Math.pow(x_d, 2) + Math.pow(y_d, 2) + Math.pow(z_d, 2));
        fitness = 1 / (R / (d * d)); //Smallest is the best fitted
        //!!!!! ----- Also change the direction in selecting step if apply the next line ----- !!!!!
        //fitness = mine.getRadiation ()/(d*d); //Largest is the best fitted
        return fitness;
    }

    // Calculate ship's fitness with multiple mines
    public static double fit(Individual individual, Mine[] mine) {

        if (mine.length == 0) return 100000000;

        List<Double> fitness = new ArrayList<>();
        for (Mine m : mine) {
            fitness.add(fit(individual, m));

        }
        Collections.sort(fitness);
        return fitness.get(0);
    }

    // Once the fitness is small enough, meaning the ship is close enough to the mine,
    // We consider it's found the target mine
    public static Mine find_Mine(Mine[] mine, Individual individual) {
        double m_X, m_Y, m_Z, i_X, i_Y, i_Z;
        Map<Double, Mine> map = new HashMap<>();
        double d;

        i_X = individual.getxPosition();
        i_Y = individual.getyPosition();
        i_Z = individual.getzPosition();

        for (Mine m : mine) {
            m_X = m.getxPosition();
            m_Y = m.getyPosition();
            m_Z = m.getzPosition();
            d = Math.sqrt(Math.pow(m_X - i_X, 2) + Math.pow((m_Y - i_Y), 2) + Math.pow((m_Z - i_Z), 2));
            map.put(d, m);
        }

        Object[] key = map.keySet().toArray();
        Arrays.sort(key);
        Mine min = map.get(key[0]);
        return min;

    }

}
