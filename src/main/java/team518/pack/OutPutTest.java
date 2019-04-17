package team518.pack;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OutPutTest {

    public static void print() {
/**
 Galaxy Test:
 */
        Galaxy galaxy = new Galaxy(10);

        Arrays.sort(galaxy.getIndividuals()); //For print propose
        System.out.println("First generation: fitness   x   y   z");
        System.out.print("\n");
        for (Individual a : galaxy.getIndividuals()) {
            System.out.print(a.getFitness () + "\t");
            System.out.print(a.getxPosition() + "\t");
            System.out.print(a.getyPosition() + "\t");
            System.out.println(a.getzPosition() + "\t");
        }

        Individual[] aux = new Individual[galaxy.getIndividuals().length];
        System.arraycopy(galaxy.getIndividuals(), 0, aux, 0, aux.length);

        for (int i = 0; i < 1000; i++) {
            //Species.select(galaxy.getIndividuals(), galaxy.getMine());
            //Species.select(galaxy.getIndividuals(), aux, galaxy.getMine());
            Species.select(galaxy.getIndividuals(), aux, galaxy.getMine_array());
        }

        Arrays.sort(galaxy.getIndividuals()); //For print propose
        System.out.println("Last generation: fitness   x   y   z");
        System.out.print("\n");
        for (Individual b : galaxy.getIndividuals()) {
            System.out.print(b.getFitness () + "\t");
            System.out.print(b.getxPosition() + "\t");
            System.out.print(b.getyPosition() + "\t");
            System.out.println(b.getzPosition() + "\t");
        }

        System.out.print("\n");
        Arrays.sort(galaxy.getMine_array(),(Mine m1, Mine m2)->{return Double.compare(m2.getRadiation(),m1.getRadiation());}); //For print propose
        //For print propose
        System.out.println("Mine information: reserve   x   y   z");
        System.out.print("\n");
        for (Mine m : galaxy.getMine_array()) {
            System.out.print(m.getRadiation() + "\t");
            System.out.print(m.getxPosition() + "\t");
            System.out.print(m.getyPosition() + "\t");
            System.out.println(m.getzPosition() + "\t");
        }
    }

    public static void main(String[] arg) {
        print();
    }
    public static void paralel(){
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i = 0; i<10; i++)
        {
            Thread thread = new Thread (new myThread(i));
            executorService.execute (thread);
        }
        executorService.shutdown ();
    }
}
