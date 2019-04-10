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

       // Galaxy Test
//        Galaxy galaxy = new Galaxy();
//        galaxy.createMine();
//        System.out.println(galaxy.getMine().getxPosition());
//        System.out.println(galaxy.getMine().getyPosition());

        //Fitness Test
        Fitness fitness = new Fitness ();
        double x =fitness.fit (0,0,12,5);
        System.out.println (x);
    }

    public static void main (String[] arg) {
        print();
    }
}
