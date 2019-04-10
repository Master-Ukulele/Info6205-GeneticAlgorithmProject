package team518.pack;

import java.sql.SQLOutput;

public class OutPutTest {

    public static void print () {
//        Individual ind = new Individual();
//        ind.createGenotype();
//        ind.createPhenotype();
//        System.out.println(ind.getGene());
//        System.out.println(ind.getxPosition());
//        System.out.println(ind.getyPosition());
        Galaxy galaxy = new Galaxy();
        galaxy.createMine();
        System.out.println(galaxy.getMine().getxPosition());
        System.out.println(galaxy.getMine().getyPosition());
    }

    public static void main (String[] arg) {
        print();
    }
}
