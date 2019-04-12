package team518.pack;

import java.sql.SQLOutput;

public class OutPutTest {

    public static void print() {
/**
        Galaxy Test:
*/
//        Galaxy galaxy = new Galaxy(4);
//        System.out.println(galaxy.getMine().getxPosition());
//        System.out.println(galaxy.getMine().getyPosition());

//        for (Individual a : galaxy.getIndividuals()) {
//            System.out.println(a.getGene());
//            System.out.println(a.getRadiationStrength());
//        }
//        System.out.println("\n");
//
//        Species.selection(galaxy.getIndividuals(), galaxy.getMine());
//        for (Individual a : galaxy.getIndividuals()) {
//            System.out.println(a.getGene());
//            System.out.println(a.getRadiationStrength());
//        }
        Individual i = new Individual();

        i.setGene("0000000000000000000000000000000000000000000000");
        System.out.println(i.getGene());
        String gene1 = "0000000000000000000000000000000000000000000000";
        String gene2 = "1111111111111111111111111111111111111111111111";
        Species.corrossOver(i, gene1, gene2);
        System.out.println(i.getGene());
    }

    public static void main(String[] arg) {
        print();
    }
}
