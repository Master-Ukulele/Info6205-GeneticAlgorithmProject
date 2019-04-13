package team518.pack;

import java.util.Arrays;
import java.util.Random;

import static team518.pack.Fitness.*;

public class Species {

    private static Random random;

    public static void select(Individual[] individuals, Individual[] newSpecies, Mine mine) {
        int num = individuals.length;
        //Individual[] newSpecies = new Individual[num];
        shuffle(individuals);
        for (int i = 0; i < num / 2; i++) {
            Individual i1 = individuals[i];
            Individual i2 = individuals[i + 1];
            Double f1 = Fitness.fit(i1, mine);
            Double f2 = Fitness.fit(i2, mine);
            if (f1 > f2) {
                newSpecies[i] = i1;
            } else {
                newSpecies[i] = i2;
            }
        }

        for (int i = num / 2; i < num; i++) {
            int r1 = random.nextInt(num / 2), r2 = random.nextInt(num / 2 - 1);
            r2 = r2 == r1 ? random.nextInt(num / 2 - 1) : r2;
            //mutation(individuals[i], individuals[r1].getGene());
            crossOver(individuals[i], individuals[r1].getGene(), individuals[r2].getGene());
            updateIndividual(individuals[i], mine);
        }
    }

//    public static void selection(Individual[] individuals, Mine mine) {
        // Replace the lower half of the array with mutated genes

//        Arrays.sort(individuals);
//        Random random = new Random();
//        int n = individuals.length;

//        for (int i = n / 2; i < n; i++) {
//        for (int i = n/2; i < n; i++) {
//            int r1 = random.nextInt(n / 2 ); //r2 = random.nextInt(n / 2 - 1);
//            //r2 = r2 == r1 ? random.nextInt(n / 2 - 1) : r2;
//            mutation(individuals[i], individuals[r1].getGene());
//            //crossOver(individuals[i], individuals[r1].getGene(), individuals[r2].getGene());
//            updateIndividual(individuals[i], mine);
//        }
//        Arrays.sort(individuals);

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
            if (Math.random() < 0.1) {
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

    public static void shuffle(Individual[] arr){
        random = new Random();
        int n = arr.length;
        for(int i=0;i<n;i++){
            int r = random.nextInt (n-1);
            Individual tmp = arr[r];
            arr[r] = arr[i];
            arr[i] = tmp;
        }
    }

//    private static Individual crossover1(Individual individual) {
//        // Crossover the genes
//        // Called internally by selection()
//
//        Individual res = individual;
//        String subGeneX = individual.getGene().substring(0, 23);
//        String subGeneY = individual.getGene().substring(23, 46);
//        int subX = Integer.parseInt(subGeneX, 2);
//        int subY = Integer.parseInt(subGeneY, 2);
//
//        double x = subX * (10.0 - 0) / (Math.pow(2, 23) - 1);
//        double y = subY * (10.0 - 0) / (Math.pow(2, 23) - 1);
//        x = x > 0.1 ? x - 0.1 : x;
//        y = y > 0.1 ? y - 0.1 : y;
//
//        res.setxPosition(x);
//        res.setyPosition(y);
//
//        return res;
//    }

//    private static Individual crossover2(Individual individual) {
//        // Crossover the genes
//        // Called internally by selection()
//
//        Individual res2 = individual;
//        String subGeneX = individual.getGene().substring(0, 23);
//        String subGeneY = individual.getGene().substring(23, 46);
//        int subX = Integer.parseInt(subGeneX, 2);
//        int subY = Integer.parseInt(subGeneY, 2);
//
//        double x = subX * (10.0 - 0) / (Math.pow(2, 23) + 1);
//        double y = subY * (10.0 - 0) / (Math.pow(2, 23) + 1);
//        x = x > 0.1 ? x + 0.1 : x;
//        y = y > 0.1 ? y + 0.1 : y;
//
//        res2.setxPosition(x);
//        res2.setyPosition(y);
//
//        return res2;
//    }
}
