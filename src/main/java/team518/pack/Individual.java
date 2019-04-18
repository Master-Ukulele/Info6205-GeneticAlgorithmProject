package team518.pack;

public class Individual implements Comparable<Individual> {

    /**
     * @param gene           Genotype
     * @param x,y,zPosition  Phenotype
     * @param fitness        Fitness, selection criteria
     */

    private final char GENE_0 = '0';
    private final char GENE_1 = '1';
    private final int GENE_LENGTH = 30;

    private String gene;

    private double xPosition;
    private double yPosition;
    private double zPosition;

    private double fitness;

    public Individual() {
        createGenotype();
    }

    // Create genotype, and right after it, phenotype
    public void createGenotype() {
        this.gene = initGene();
        createPhenotype();
    }

    public void createPhenotype() {

        String subGeneX = gene.substring(0, 10);
        String subGeneY = gene.substring(10, 20);
        String subGeneZ = gene.substring(20, 30);
        int subX = Integer.parseInt(subGeneX, 2);
        int subY = Integer.parseInt(subGeneY, 2);
        int subZ = Integer.parseInt(subGeneZ, 2);
        xPosition = subX * (10.0 - 0) / (Math.pow(2, 10) - 1);
        yPosition = subY * (10.0 - 0) / (Math.pow(2, 10) - 1);
        zPosition = subZ * (10.0 - 0) / (Math.pow(2, 10) - 1);
    }

    public String getGene() {
        return this.gene;
    }

    public double getxPosition() {
        return this.xPosition;
    }

    public double getyPosition() {
        return this.yPosition;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public void setxPosition(double xPosition) {
        this.xPosition = xPosition;
    }

    public void setyPosition(double yPosition) {
        this.yPosition = yPosition;
    }

    public double getzPosition() {
        return zPosition;
    }

    public void setzPosition(double zPosition) {
        this.zPosition = zPosition;
    }

    private String initGene() {
        String res = "";
        for (int i = 0; i < GENE_LENGTH; i++) {
            if (Math.random() < 0.5) { // A little improvement to fix a pseudo random
                res += GENE_0;
            } else {
                res += GENE_1;
            }
        }
        return res;
    }

    public void setGene(String gene) {
        this.gene = gene;
    }

    @Override
    public int compareTo(Individual o) {
        if (this.fitness < o.getFitness()) return -1;
        if (this.fitness > o.getFitness()) return 1;
        return 0;
    }
}