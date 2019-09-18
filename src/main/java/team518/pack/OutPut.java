package team518.pack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OutPut {

    /**
     * @param m_array     A list that returns the final locations of the ships
     * @param ind_number  Number of the individuals(ships)
     * @param mine_number Number of the mines
     * @param j           An integer to store the rank of the mine found
     */

    protected static ArrayList<Mine> m_array = new ArrayList<>();
    protected static int ind_number = 30;
    protected static int mine_number = 120;
    public static int j = 0;


    public static void main(String[] arg) {
        Galaxy galaxy = new Galaxy(ind_number, mine_number);

        Arrays.sort(galaxy.getMine_array(), (Mine m1, Mine m2)
                -> Double.compare(m2.getRadiation(), m1.getRadiation()));

//        Print the mines
//        System.out.println("Mine rank  /  Reserve /  x  /  y  /  z");
//        System.out.print("\n");
//        int i = 0;
//        for (Mine m : galaxy.getMine_array()) {
//            System.out.print(++i + "\t ");
//            System.out.print(m.getRadiation() + "\t");
//            System.out.print(m.getxPosition() + "\t");
//            System.out.print(m.getyPosition() + "\t");
//            System.out.println(m.getzPosition() + "\t");
//        }
//        System.out.print("\n");

        parallel(galaxy);

//        Print the result
        System.out.println("Number of mines: " + mine_number + " Number of ships: " + ind_number + " \n");
        System.out.println("GA Result:\nMine rank  /  Reserve /  x  /  y  /  z");
        System.out.print(j+1 + "\t ");
        System.out.print(m_array.get(0).getRadiation() + "\t");
        System.out.print(m_array.get(0).getxPosition() + "\t");
        System.out.print(m_array.get(0).getyPosition() + "\t");
        System.out.println(m_array.get(0).getzPosition() + "\t");
    }

    /**
     * Multi-thread (parallelism)
     */
    public static void parallel(Galaxy galaxy) {

        ExecutorService executorService = Executors.newFixedThreadPool(8);
        Thread thread1 = new Thread(new myThread(galaxy.getSub_individuals_1(), galaxy.getMine_array_1(), 1));
        executorService.execute(thread1);

        Thread thread2 = new Thread(new myThread(galaxy.getSub_individuals_2(), galaxy.getMine_array_2(), 2));
        executorService.execute(thread2);

        Thread thread3 = new Thread(new myThread(galaxy.getSub_individuals_3(), galaxy.getMine_array_3(), 3));
        executorService.execute(thread3);

        Thread thread4 = new Thread(new myThread(galaxy.getSub_individuals_4(), galaxy.getMine_array_4(), 4));
        executorService.execute(thread4);

        Thread thread5 = new Thread(new myThread(galaxy.getSub_individuals_5(), galaxy.getMine_array_5(), 5));
        executorService.execute(thread5);

        Thread thread6 = new Thread(new myThread(galaxy.getSub_individuals_6(), galaxy.getMine_array_6(), 6));
        executorService.execute(thread6);

        Thread thread7 = new Thread(new myThread(galaxy.getSub_individuals_7(), galaxy.getMine_array_7(), 7));
        executorService.execute(thread7);

        Thread thread8 = new Thread(new myThread(galaxy.getSub_individuals_8(), galaxy.getMine_array_8(), 8));
        executorService.execute(thread8);

        executorService.shutdown();

        //Sleep longer if array index out of bounds
        int t = 100;
        try {
            thread1.sleep(t);
            thread2.sleep(t);
            thread3.sleep(t);
            thread4.sleep(t);
            thread5.sleep(t);
            thread6.sleep(t);
            thread7.sleep(t);
            thread8.sleep(t);
        } catch (InterruptedException e) {

        } finally {
//            System.out.println(m_array.size());
        }

        Collections.sort(m_array, (Mine a, Mine b)
                -> Double.compare(b.getRadiation(), a.getRadiation()));

        for (; j < galaxy.getMine_array().length; j++) {
            if (m_array.get(0).getRadiation() == galaxy.getMine_array()[j].getRadiation() && m_array.get(0).getxPosition() == galaxy.getMine_array()[j].getxPosition())
                break;
        }
    }
}
