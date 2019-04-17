package team518.pack;

public class Galaxy {
    private double xMax = 10;
    private double yMax = 10;
    private double zMax = 10;
    private Individual[] individuals;
    private Mine mine; //Use a container later to storage more mines, e.g. Array, better with HashTable
    //private Blocker blocker; //Design blocker later and its container
    private Mine[] mine_array;

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

    public Individual[] getIndividuals() {
        return individuals;
    }

    public Mine getMine() {
        return mine;
    }

    public Mine[] getMine_array () {
        return mine_array;
    }

}
