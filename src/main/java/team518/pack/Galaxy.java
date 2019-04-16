package team518.pack;

public class Galaxy {
    private double xMax = 10;
    private double yMax = 10;
    private double zMax = 10;
    private Individual[] individuals;
    private Mine mine; //Use a container later to storage more mines, e.g. Array, better with HashTable
    //private Blocker blocker; //Design blocker later and its container

    public Galaxy(int N){
        createMine();
        initIndividuals(N);
    }

    private void initIndividuals(int N) {
        individuals = new Individual[N];
        for (int i=0; i<individuals.length; i++) {
            individuals[i] = new Individual();
            individuals[i].setFitness(Fitness.fit(individuals[i], getMine ()));
        }
    }

    public Individual[] getIndividuals() {
        return individuals;
    }

    public void createMine () {
        this.mine = new Mine();
        mine.setxPosition(Math.random() * xMax); // 0 <= x < xMax
        mine.setyPosition(Math.random() * yMax);
        mine.setzPosition(Math.random() * zMax);
        mine.setRadiation (1000);
    }

    public Mine getMine() {
        return mine;
    }
}
