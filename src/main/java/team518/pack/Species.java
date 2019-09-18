package team518.pack;

import java.util.Random;

public class Species {

    /**
     * This class is used only for selection operation
     */

    private static Random random;
    /**
     * Select after crossover and mutation
     */
    public static void select(Individual[] individuals, Individual[] aux, Mine[] mine_array) {
        int num = individuals.length;
        shuffle(individuals);
        for (int i = 0; i < num; i = i + 2) {
            Individual i1 = individuals[i];
            Individual i2 = individuals[i + 1];
            // Change this logic into compareTo() later
            if (i1.getFitness() > i2.getFitness()) {
                aux[i/2] = i1;
                aux[i/2 + num/2] = i2;
            } else {
                aux[i/2] = i2;
                aux[i/2] = i1;
            }
        }

        for (int i = num / 2; i < num; i++) {
            int r1 = random.nextInt(num / 2), r2 = random.nextInt(num / 2 - 1);
            while (r2 == r1) r2 = random.nextInt(num / 2 - 1);
            crossOver(aux[i], individuals[r1].getGene(), individuals[r2].getGene());
            mutation(aux[i], aux[i].getGene());
            updateIndividual(aux[i], mine_array);
        }
        System.arraycopy(aux, 0, individuals, 0, aux.length);
    }

    /**
     * Crossover the genes
     */
    private static void crossOver(Individual target, String gene1, String gene2) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 30; i++) {
            if (Math.random() < 0.5) {
                res.append(gene1.charAt(i));
            } else {
                res.append(gene2.charAt(i));
            }
        }
        target.setGene(res.toString());
    }

    /**
     * Mutate the genes
     */
    private static void mutation(Individual target, String gene) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 30; i++) {
            if (Math.random() < 0.05) {
                char c = gene.charAt(i);
                if (c == '0') {
                    res.append('1');
                } else {
                    res.append('0');
                }
            } else {
                res.append(gene.charAt(i));
            }
        }
        target.setGene(res.toString());
    }

    /**
     * Update the individual after crossover and mutation
     */
    private static void updateIndividual(Individual individual, Mine[] mine_array) {
        individual.createPhenotype();
        individual.setFitness(Fitness.fit(individual, mine_array));
    }

    /**
     * Shuffle the individuals
     */
    private static void shuffle(Individual[] arr) {
        random = new Random();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int r = random.nextInt(n - 1);
            Individual tmp = arr[r];
            arr[r] = arr[i];
            arr[i] = tmp;
        }
    }

}