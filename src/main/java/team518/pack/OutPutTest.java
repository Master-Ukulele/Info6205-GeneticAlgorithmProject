package team518.pack;

import java.sql.SQLOutput;
import java.util.Arrays;

public class OutPutTest {

    public static void print() {
/**
 Galaxy Test:
 */
        Galaxy galaxy = new Galaxy(10);
//        galaxy.getMine ().setRadiation (1000);
        System.out.println(galaxy.getMine().getxPosition());
        System.out.println(galaxy.getMine().getyPosition());
        System.out.println(galaxy.getMine().getzPosition ());
        System.out.print("\n");
//
        for (Individual a : galaxy.getIndividuals()) {
            System.out.println(a.getFitness ());
        }
        System.out.println("\n");
        Individual[] aux = new Individual[galaxy.getIndividuals().length];
        System.arraycopy(galaxy.getIndividuals(), 0, aux, 0, aux.length);

        for (int i = 0; i < 100; i++) {
//            Species.select(galaxy.getIndividuals(), galaxy.getMine());
            Species.select(galaxy.getIndividuals(), aux, galaxy.getMine());
        }

        for (int i=0 ; i< aux.length; i++) {
            System.out.println(galaxy.getIndividuals()[i].getFitness ());
//            System.out.println(aux[i].getRadiationStrength());
        }

    }

    public static void main(String[] arg) {
        print();
    }
}
