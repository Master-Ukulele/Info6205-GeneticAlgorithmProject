package team518.pack;
//Individual
public class Individual implements Comparable<Individual>{

    private final char GENE_0 = '0';
    private final char GENE_1 = '1';
    private final int GENE_LENGTH = 30;

    private String gene; //genotype

    private double xPosition;
    private double yPosition;
    private double zPosition; //phenotype

    private double fitness; //fitness

    public Individual () {
        createGenotype();
    }

    public void createGenotype () {
        this.gene = initGene();
        createPhenotype();
    }

    public void createPhenotype () {
        //TODO: Generate Phenotype According To Genotype
        //gene = "0000000000000000000000000000000000000000000000";
        //gene = "1111111111111111111111111111111111111111111111";
        String subGeneX = gene.substring(0,10);
        String subGeneY = gene.substring(10,20);
        String subGeneZ = gene.substring(20,30);
        int subX = Integer.parseInt(subGeneX,2);
        int subY = Integer.parseInt(subGeneY,2);
        int subZ = Integer.parseInt(subGeneZ,2);
        //String subGeneZ = ""; //Start with 2D first
        xPosition = subX * (10.0 - 0) / (Math.pow(2, 10) - 1);
        yPosition = subY * (10.0 - 0) / (Math.pow(2, 10) - 1);
        zPosition = subZ * (10.0 - 0) / (Math.pow(2, 10) - 1);
    }

    public String getGene () {
        return this.gene;
    }

    public double getxPosition () {
        return this.xPosition;
    }

    public double getyPosition() {
        return this.yPosition;
    }

    public double getFitness () {
        return fitness;
    }

    public void setFitness (double fitness) {
        this.fitness = fitness;
    }

    public void setxPosition(double xPosition) {
        this.xPosition = xPosition;
    }

    public void setyPosition(double yPosition) {
        this.yPosition = yPosition;
    }

    public double getzPosition () {
        return zPosition;
    }

    public void setzPosition (double zPosition) {
        this.zPosition = zPosition;
    }

    private String initGene() {
        String res = "";
        for (int i = 0; i < GENE_LENGTH; i++) {
            if (Math.random() < 0.5) { // A little improvement to fix a pseud random
                res += GENE_0;
            } else {
                res += GENE_1;
            }
        }
        return res;
    }

    public void setGene (String gene) {
        this.gene = gene;
    }

    @Override
    public int compareTo(Individual o) {
        if (this.fitness < o.getFitness ()) return -1;
        if (this.fitness > o.getFitness ()) return 1;
        return 0;
    }
}