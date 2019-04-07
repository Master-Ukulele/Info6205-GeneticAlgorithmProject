package team518.pack;

public class OutPutTest {

    public static void print () {
        Individual ind = new Individual();
        ind.createGenotype();
        ind.createPhenotype();
        System.out.print(ind.getGene());
    }

    public static void main (String[] arg) {
        print();
    }
}
