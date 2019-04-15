package team518.pack;

import java.util.Random;

public class Species {

    private static Random random;

    public static void select(Individual[] individuals, Individual[] aux, Mine mine) {

        int num = individuals.length;
        shuffle(individuals);
        for (int i = 0; i < num; i=i+2) {
            Individual i1 = individuals[i];
            Individual i2 = individuals[i + 1];
            Double f1 = Fitness.fit(i1, mine);
            Double f2 = Fitness.fit(i2, mine);
            if (f1 < f2) { // Change this logic into compareTo() later
                aux[i/2] = i1;
            } else {
                aux[i/2] = i2;
            }
        }

        for (int i = num / 2; i < num; i++) {
            int r1 = random.nextInt(num / 2), r2 = random.nextInt(num / 2 - 1);
            r2 = r2 == r1 ? random.nextInt(num / 2 - 1) : r2;
            //TODO: Bug exist, r1 sometimes equals r2, causing the inbreeding.
            // It could be eliminated by fixing.
            // Specifically, the possibility of inbreeding would reduce.
            // Thus, the mutation is still required.
            aux[i] = new Individual();
            crossOver(aux[i], individuals[r1].getGene(), individuals[r2].getGene());
            mutation(aux[i], aux[i].getGene());
            updateIndividual(aux[i], mine);
        }

        System.arraycopy(aux,0,individuals,0,aux.length);
    }

    private static void crossOver(Individual target, String gene1, String gene2) {
        String res = "";
        for (int i = 0; i < 46; i++) {
            if (Math.random() < 0.5) {
                res += gene1.charAt(i);
            } else {
                res += gene2.charAt(i);
            }
        }
        target.setGene(res);
    }

    private static void mutation(Individual target, String gene) {
        String res = "";
        for (int i = 0; i < 46; i++) {
            if (Math.random() < 0.05) {
                char c = gene.charAt(i);
                if (c == '0') {
                    res += '1';
                } else {
                    res += '0';
                }
            } else {
                res += gene.charAt(i);
            }
        }
        target.setGene(res);
    }

    private static void updateIndividual(Individual individual, Mine mine) {
        individual.createPhenotype();
        individual.setRadiation(Fitness.fit(individual, mine));
    }

    public static void shuffle(Individual[] arr) {
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