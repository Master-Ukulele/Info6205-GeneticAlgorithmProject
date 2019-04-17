package team518.pack;

import javax.swing.plaf.synth.SynthScrollBarUI;
import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.*;

public class OutPutTest {

    public static ArrayList<Mine> m_array = new ArrayList<> ();

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
        Galaxy galaxy = new Galaxy (10);

        Arrays.sort(galaxy.getMine_array(),(Mine m1, Mine m2)
                ->{return Double.compare(m2.getRadiation(),m1.getRadiation());

        });
        System.out.println("Mine information: Reserve /  x  /  y  /  z");
        System.out.print("\n");
        for (Mine m : galaxy.getMine_array()) {
            System.out.print(m.getRadiation() + "\t");
            System.out.print(m.getxPosition() + "\t");
            System.out.print(m.getyPosition() + "\t");
            System.out.println(m.getzPosition() + "\t");
        }
        System.out.print("\n");

        paralel (galaxy);
    }

    public static void paralel(Galaxy galaxy) {

        ExecutorService executorService = Executors.newFixedThreadPool(8);
        Thread thread1 = new Thread (new myThread(galaxy.getSub_individuals_1 (),galaxy.getMine_array_1 (),1));
        executorService.execute (thread1);

        Thread thread2 = new Thread (new myThread(galaxy.getSub_individuals_2 (),galaxy.getMine_array_2 (),2));
        executorService.execute (thread2);

        Thread thread3 = new Thread (new myThread(galaxy.getSub_individuals_3 (),galaxy.getMine_array_3 (),3));
        executorService.execute (thread3);

        Thread thread4 = new Thread (new myThread(galaxy.getSub_individuals_4 (),galaxy.getMine_array_4 (),4));
        executorService.execute (thread4);

        Thread thread5 = new Thread (new myThread(galaxy.getSub_individuals_5 (),galaxy.getMine_array_5 (),5));
        executorService.execute (thread5);

        Thread thread6 = new Thread (new myThread(galaxy.getSub_individuals_6 (),galaxy.getMine_array_6 (),6));
        executorService.execute (thread6);

        Thread thread7 = new Thread (new myThread(galaxy.getSub_individuals_7 (),galaxy.getMine_array_7 (),7));
        executorService.execute (thread7);

        Thread thread8 = new Thread (new myThread(galaxy.getSub_individuals_8 (),galaxy.getMine_array_8 (),8));
        executorService.execute (thread8);

        executorService.shutdown();
        //Sleep longer if something goes wrong
        try {
            thread1.sleep(100);
            thread2.sleep(100);
            thread3.sleep(100);
            thread4.sleep(100);
            thread5.sleep(100);
            thread6.sleep(100);
            thread7.sleep(100);
            thread8.sleep(100);
        } catch (InterruptedException e) {

        } finally {
            //System.out.println(m_array.size());
        }

        Collections.sort (m_array, (Mine a, Mine b)
                ->{return Double.compare (b.getRadiation(),a.getRadiation());
        });

        System.out.print("GA Result: Reserve /  x  /  y  /  z");
        System.out.print("\n");
        System.out.print(m_array.get(0).getRadiation() + "\t");
        System.out.print(m_array.get(0).getxPosition() + "\t");
        System.out.print(m_array.get(0).getyPosition() + "\t");
        System.out.print(m_array.get(0).getzPosition() + "\t");

    }
}
