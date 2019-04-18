package team518.pack;

public class myThread implements Runnable {

    /**
     * @param subIndividual Arrays of divided individuals(ships)
     * @param subMine       Arrays of divided mines
     * @param i             Index of the sub arrays
     */

    private Individual[] subIndividual;
    private Mine[] subMine;
    private int i;


    public myThread(Individual[] subIndividual, Mine[] subMine, int i) {
        this.subIndividual = subIndividual;
        this.subMine = subMine;
        this.i = i;
    }

    @Override
    public void run() {

        Individual[] aux = new Individual[subIndividual.length];
        System.arraycopy(subIndividual, 0, aux, 0, aux.length);

        for (int i = 0; i < 1000; i++) {
            Species.select(subIndividual, aux, subMine);
        }

        Mine temp = Fitness.find_Mine(subMine, subIndividual[0]);

        synchronized (this) {
            OutPut.m_array.add(temp);
        }
    }
}
