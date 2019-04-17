package team518.pack;

import java.util.ArrayList;
import java.util.List;

public class Galaxy {
    private double xMax = 10;
    private double yMax = 10;
    private double zMax = 10;
    private Individual[] individuals;
    private Mine mine; //Use a container later to storage more mines, e.g. Array, better with HashTable
    //private Blocker blocker; //Design blocker later and its container
    private Mine[] mine_array;

    private Mine[] mine_array_1;
    private Mine[] mine_array_2;
    private Mine[] mine_array_3;
    private Mine[] mine_array_4;
    private Mine[] mine_array_5;
    private Mine[] mine_array_6;
    private Mine[] mine_array_7;
    private Mine[] mine_array_8;

    private Individual[] sub_individuals_1;
    private Individual[] sub_individuals_2;
    private Individual[] sub_individuals_3;
    private Individual[] sub_individuals_4;
    private Individual[] sub_individuals_5;
    private Individual[] sub_individuals_6;
    private Individual[] sub_individuals_7;
    private Individual[] sub_individuals_8;

    public Galaxy(int N){
        createMine();
        initIndividuals(N);
        createMine_Array(5);
    }

    private void initIndividuals(int N) {
        individuals = new Individual[N];
        for (int i=0; i<individuals.length; i++) {
            individuals[i] = new Individual();
            individuals[i].setFitness(Fitness.fit(individuals[i], getMine ()));
        }
    }

    private void createMine () {
        this.mine = new Mine();
        mine.setxPosition(Math.random() * xMax); // 0 <= x < xMax
        mine.setyPosition(Math.random() * yMax);
        mine.setzPosition(Math.random() * zMax);
        mine.setRadiation (10);
    }

    private void createMine_Array (int num) {
        mine_array = new Mine[num];
        for (int i = 0; i < num; i++) {
            mine_array[i] = new Mine();
            mine_array[i].setxPosition(Math.random() * xMax); // 0 <= x < xMax
            mine_array[i].setyPosition(Math.random() * yMax);
            mine_array[i].setzPosition(Math.random() * zMax);
            double radiation = Math.random() * 10;
            mine_array[i].setRadiation (radiation);// Change to a random value later
        }
    }

    private void initIdividuals (int N, Individual[] sub_individuals, Mine[] mines) {

        if (mines.length == 0) {
            return;
        }

        sub_individuals = new Individual[N];
        for (int i=0; i<sub_individuals.length; i++) {
            sub_individuals[i] = new Individual();
            sub_individuals[i].setFitness(Fitness.fit(sub_individuals[i], getMine ()));
        }
    }

    public void split () {

        List<Mine> list1 = new ArrayList<> ();
        List<Mine> list2 = new ArrayList<> ();
        List<Mine> list3 = new ArrayList<> ();
        List<Mine> list4 = new ArrayList<> ();
        List<Mine> list5 = new ArrayList<> ();
        List<Mine> list6 = new ArrayList<> ();
        List<Mine> list7 = new ArrayList<> ();
        List<Mine> list8 = new ArrayList<> ();

        for (Mine m : mine_array) {

            if (m.getxPosition() < xMax / 2 &&
                m.getyPosition() < yMax / 2 &&
                m.getzPosition() < zMax / 2) {
                list1.add(m);
                continue;
            }

            if (m.getxPosition() < xMax / 2 &&
                m.getyPosition() < yMax / 2 &&
                m.getzPosition() >= zMax / 2) {
                list2.add(m);
                continue;
            }

            if (m.getxPosition() < xMax / 2 &&
                    m.getyPosition() >= yMax / 2 &&
                    m.getzPosition() < zMax / 2) {
                list3.add(m);
                continue;
            }

            if (m.getxPosition() < xMax / 2 &&
                    m.getyPosition() >= yMax / 2 &&
                    m.getzPosition() >= zMax / 2) {
                list4.add(m);
                continue;
            }

            if (m.getxPosition() >= xMax / 2 &&
                    m.getyPosition() < yMax / 2 &&
                    m.getzPosition() < zMax / 2) {
                list5.add(m);
                continue;
            }

            if (m.getxPosition() >= xMax / 2 &&
                    m.getyPosition() < yMax / 2 &&
                    m.getzPosition() >= zMax / 2) {
                list6.add(m);
                continue;
            }

            if (m.getxPosition() >= xMax / 2 &&
                    m.getyPosition() >= yMax / 2 &&
                    m.getzPosition() < zMax / 2) {
                list7.add(m);
                continue;
            }

            if (m.getxPosition() >= xMax / 2 &&
                    m.getyPosition() >= yMax / 2 &&
                    m.getzPosition() >= zMax / 2) {
                list8.add(m);
                continue;
            }

        }

        mine_array_1 = (Mine[]) list1.toArray();
        mine_array_2 = (Mine[]) list2.toArray();
        mine_array_3 = (Mine[]) list3.toArray();
        mine_array_4 = (Mine[]) list4.toArray();
        mine_array_5 = (Mine[]) list5.toArray();
        mine_array_6 = (Mine[]) list6.toArray();
        mine_array_7 = (Mine[]) list7.toArray();
        mine_array_8 = (Mine[]) list8.toArray();
    }

    public Individual[] getIndividuals() {
        return individuals;
    }

    public Mine getMine() {
        return mine;
    }

    public Mine[] getMine_array () {
        return mine_array;
    }


    public Mine[] getMine_array_1() {
        return mine_array_1;
    }

    public Mine[] getMine_array_2() {
        return mine_array_2;
    }

    public Mine[] getMine_array_3() {
        return mine_array_3;
    }

    public Mine[] getMine_array_4() {
        return mine_array_4;
    }

    public Mine[] getMine_array_5() {
        return mine_array_5;
    }

    public Mine[] getMine_array_6() {
        return mine_array_6;
    }

    public Mine[] getMine_array_7() {
        return mine_array_7;
    }

    public Mine[] getMine_array_8() {
        return mine_array_8;
    }

    public Individual[] getSub_individuals_1() {
        return sub_individuals_1;
    }

    public Individual[] getSub_individuals_2() {
        return sub_individuals_2;
    }

    public Individual[] getSub_individuals_3() {
        return sub_individuals_3;
    }

    public Individual[] getSub_individuals_4() {
        return sub_individuals_4;
    }

    public Individual[] getSub_individuals_5() {
        return sub_individuals_5;
    }

    public Individual[] getSub_individuals_6() {
        return sub_individuals_6;
    }

    public Individual[] getSub_individuals_7() {
        return sub_individuals_7;
    }

    public Individual[] getSub_individuals_8() {
        return sub_individuals_8;
    }
}
