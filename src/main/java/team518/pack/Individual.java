package team518.pack;

public class Individual {

    private final char GENE_0 = '0';
    private final char GENE_1 = '1';
    private final int GENE_LENGTH = 30;

    private String gene; //genotype

    private double xPosition;
    private double yPosition;
    private double zPosition; //phenotype

    private double radiationStrength; //fitness

    public Individual () {

    }

    public void createGenotype () {
        this.gene = initGene();
    }

    public void createPhenotype () {
        //TODO: Generate Phenotype According To Genotype
        String subGeneX = "";
        String subGeneY = "";
        String subGeneZ = "";
        xPosition = 0;
        yPosition = 0;
        zPosition = 0;
    }

    public String getGene () {
        return this.gene;
    }

    private String initGene() {
        String res = "";
        for (int i = 0; i < GENE_LENGTH; i++) {
            if (Math.random() > 0.5) {
                res += GENE_0;
            } else {
                res += GENE_1;
            }
        }
        return res;
    }
}
