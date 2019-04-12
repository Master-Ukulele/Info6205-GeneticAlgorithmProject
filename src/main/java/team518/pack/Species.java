package team518.pack;

import java.util.Arrays;

public class Species {

    public static void selection(Individual[] individuals, Mine mine) {
        // Replace the lower half of the array with mutated genes

        Arrays.sort(individuals);
        int n = individuals.length;
        int boo = n % 2 == 0 ? n : n - 1;

//        for (int i = n / 2; i < boo; i += 2) {
//            individuals[i] = crossover1(individuals[i - n / 2]);
//            individuals[i - n / 2] = crossover2(individuals[i - n / 2]);
//            individuals[i].updateRadiation(mine);
//            individuals[i - n / 2].updateRadiation(mine);
//        }
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
    public static void corrossOver (Individual target, String gene1, String gene2) {
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
}
