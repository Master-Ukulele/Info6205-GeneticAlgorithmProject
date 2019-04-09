package team518.pack;

public class OutPutTest {

    public static void print () {
        Individual ind = new Individual();
        ind.createGenotype();
        ind.createPhenotype();
        System.out.println(ind.getGene());
        System.out.println(ind.getxPosition());
        System.out.println(ind.getyPosition());
    }

    public static void main (String[] arg) {
        print();
    }
}
