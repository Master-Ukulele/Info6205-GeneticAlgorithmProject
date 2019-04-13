package team518.pack;

import java.sql.SQLOutput;
import java.util.Arrays;

public class OutPutTest {

    public static void print() {
/**
 Galaxy Test:
 */
        Galaxy galaxy = new Galaxy(10);
        System.out.println(galaxy.getMine().getxPosition());
        System.out.println(galaxy.getMine().getyPosition());
        System.out.print("\n");
//
//        for (Individual a : galaxy.getIndividuals()) {
//            System.out.println(a.getGene());
//            System.out.println(a.getRadiationStrength());
//        }
//        System.out.println("\n");

//        for (int i = 0; i < 10000; i++) {
//            Species.selection(galaxy.getIndividuals(), galaxy.getMine());
//        }
//        for (Individual a : galaxy.getIndividuals()) {
//            System.out.println(a.getGene());
//            System.out.println(a.getRadiationStrength());
//        }
//        Individual i = new Individual();
//
//        i.setGene("0000000000000000000000000000000000000000000000");
//        System.out.println(i.getGene());
//        String gene1 = "0000000000000000000000000000000000000000000000";
//        String gene2 = "1111111111111111111111111111111111111111111111";
//        Species.crossOver(i, gene1, gene2);
//        System.out.println(i.getGene());
        Individual[] in = new Individual[6];
        Individual a = new Individual();
        Individual b = new Individual();
        Individual c = new Individual();
        Individual d = new Individual();
        Individual e = new Individual();
        Individual i = new Individual();
//
        a.setGene("0000110000000000000000000001110000000001110000");
        b.setGene("0000000001100000000000000000000000000000000000");
        c.setGene("1100010000000001100000000000000000000000000000");
        d.setGene("0000010000000000000000000000000000000000000000");
        e.setGene("0000010000111000100001000000000000000000000000");
        i.setGene("0000110000000000000000000001000100100100100000");

        in[0] = a;
        in[1] = b;
        in[2] = c;
        in[3] = d;
        in[4] = e;
        in[5] = i;

        Individual[] ss = Species.select(in,galaxy.getMine());
        for(Individual s :ss) {
            System.out.println (s.getxPosition ());
        }

    }

    public static void main(String[] arg) {
        print();
    }
}
