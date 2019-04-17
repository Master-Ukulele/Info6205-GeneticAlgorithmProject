package team518.pack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    private Map<Integer, Individual[]> individual_map;
    private Map<Integer, Mine[]> mine_map;

    public Galaxy(int N){
        createMine();
        initIndividuals(N);
        createMine_Array(40);
        split();
//        individual_map.put(1,sub_individuals_1);
//        individual_map.put(2,sub_individuals_2);
//        individual_map.put(3,sub_individuals_3);
//        individual_map.put(4,sub_individuals_4);
//        individual_map.put(5,sub_individuals_5);
//        individual_map.put(6,sub_individuals_6);
//        individual_map.put(7,sub_individuals_7);
//        individual_map.put(8,sub_individuals_8);
//
//        mine_map.put(1,mine_array_1);
//        mine_map.put(2,mine_array_1);
//        mine_map.put(3,mine_array_1);
//        mine_map.put(4,mine_array_1);
//        mine_map.put(5,mine_array_1);
//        mine_map.put(6,mine_array_1);
//        mine_map.put(7,mine_array_1);
//        mine_map.put(8,mine_array_1);

        initSubIndividuals(N);
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

    private void initWithMap (int N) {
        //Create sub_individuals_1 -- 8
        for (int i = 1; i < 9; i++) {
            Individual[] temp = new Individual[N];
            //Create N individuals for a sub_individuals_X
            for (int j=0; j<temp.length; j++) {
                temp[j] = new Individual();
            }
            //individual_map.get(i) = temp;
            //
        }
    }

    private void initSubIndividuals (int N) {

        sub_individuals_1 = new Individual[N];
        for (int i=0; i<sub_individuals_1.length; i++) {
            sub_individuals_1[i] = new Individual();
            sub_individuals_1[i].setFitness(Fitness.fit(sub_individuals_1[i], mine_array_1));
        }

        sub_individuals_2 = new Individual[N];
        for (int i=0; i<sub_individuals_2.length; i++) {
            sub_individuals_2[i] = new Individual();
            sub_individuals_2[i].setFitness(Fitness.fit(sub_individuals_2[i], mine_array_2));
        }

        sub_individuals_3 = new Individual[N];
        for (int i=0; i<sub_individuals_3.length; i++) {
            sub_individuals_3[i] = new Individual();
            sub_individuals_3[i].setFitness(Fitness.fit(sub_individuals_3[i], mine_array_3));
        }

        sub_individuals_4 = new Individual[N];
        for (int i=0; i<sub_individuals_4.length; i++) {
            sub_individuals_4[i] = new Individual();
            sub_individuals_4[i].setFitness(Fitness.fit(sub_individuals_4[i], mine_array_4));
        }

        sub_individuals_5 = new Individual[N];
        for (int i=0; i<sub_individuals_5.length; i++) {
            sub_individuals_5[i] = new Individual();
            sub_individuals_5[i].setFitness(Fitness.fit(sub_individuals_5[i], mine_array_5));
        }

        sub_individuals_6 = new Individual[N];
        for (int i=0; i<sub_individuals_6.length; i++) {
            sub_individuals_6[i] = new Individual();
            sub_individuals_6[i].setFitness(Fitness.fit(sub_individuals_6[i], mine_array_6));
        }

        sub_individuals_7 = new Individual[N];
        for (int i=0; i<sub_individuals_7.length; i++) {
            sub_individuals_7[i] = new Individual();
            sub_individuals_7[i].setFitness(Fitness.fit(sub_individuals_7[i], mine_array_7));
        }

        sub_individuals_8 = new Individual[N];
        for (int i=0; i<sub_individuals_8.length; i++) {
            sub_individuals_8[i] = new Individual();
            sub_individuals_8[i].setFitness(Fitness.fit(sub_individuals_8[i], mine_array_8));
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

        mine_array_1 = list1.toArray(new Mine[list1.size ()]);
        mine_array_2 = list2.toArray(new Mine[list2.size ()]);
        mine_array_3 = list3.toArray(new Mine[list3.size ()]);
        mine_array_4 = list4.toArray(new Mine[list4.size ()]);
        mine_array_5 = list5.toArray(new Mine[list5.size ()]);
        mine_array_6 = list6.toArray(new Mine[list6.size ()]);
        mine_array_7 = list7.toArray(new Mine[list7.size ()]);
        mine_array_8 = list8.toArray(new Mine[list8.size ()]);
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
