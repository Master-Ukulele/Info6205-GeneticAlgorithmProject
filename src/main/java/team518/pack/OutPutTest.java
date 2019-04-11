package team518.pack;

import java.sql.SQLOutput;

public class OutPutTest {

    public static void print() {
/**
        Galaxy Test:
*/
        Galaxy galaxy = new Galaxy(4);
//        System.out.println(galaxy.getMine().getxPosition());
//        System.out.println(galaxy.getMine().getyPosition());

        for (Individual a : galaxy.getIndividuals()) {
            System.out.println(a.getGene());
            System.out.println(a.getRadiationStrength());
        }
        System.out.println("\n");

        Species.selection(galaxy.getIndividuals(), galaxy.getMine());
        for (Individual a : galaxy.getIndividuals()) {
            System.out.println(a.getGene());
            System.out.println(a.getRadiationStrength());
        }

    }

    public static void main(String[] arg) {
        print();
    }
}
