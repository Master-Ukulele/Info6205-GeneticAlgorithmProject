package team518.pack;

import java.util.Arrays;
import java.util.Random;

public class DraftArea {

	/**
	public static double fit(Individual individual, Mine mine){
		double fitness; //signal strength
		double d;//distance
		double x = individual.getxPosition(), y = individual.getyPosition(),
				X = mine.getxPosition(), Y = mine.getyPosition();
		double x_d = X-x;
		double y_d = Y-y;
		d = Math.sqrt (Math.pow (x_d,2)+Math.pow (y_d,2));
		fitness = mine.getRadiation ()/d*d;
		return fitness;
	}
	 *///----------------------------

    /**
    private static String crossOverV2 (String gene1, String gene2) {
        //String res="";
        char[] r = new char[46];
        char[] g1 = gene1.toCharArray();
        char[] g2 = gene2.toCharArray();

        double d = Math.random() * 23;
        int start = (int) d;
        for (int i = start; i < start + 23; i++) {
            r[i] = g1[i];
        }

        if (start == 0) {
            char[] ttEnd = gene2.substring(23,46).toCharArray();
            shuffle_char(ttEnd);
            for (int i = 23; i < 46; i++) {
                r[i] = ttEnd[i - 23];
            }
        } else if (start == 22) {
            char[] ttStart = gene2.substring(0,23).toCharArray();
//            shuffle_char(ttStart);
            for (int i = 0; i < 23; i++) {
                r[i] = ttStart[i];
            }
        } else {
            char[] ttStart = gene2.substring(0,start).toCharArray();
            char[] ttEnd = gene2.substring(start + 23,46).toCharArray();
            shuffle_char(ttStart);
            shuffle_char(ttEnd);
            for (int i = 0; i < start; i++) {
                r[i] = ttStart[i];
            }
            for (int i = start + 23; i < 46; i++) {
                r[i] = ttEnd[i - start - 23];
            }
        }
        String x = new String (r);
        return x;
    }
    *///----------------------------


    /**
    public static void shuffle_char (char[] c) {
        Random random = new Random();
        int n = c.length;
        for (int i = 0; i < n; i++) {
            int r = random.nextInt(n);
            char tmp = c[r];
            c[r] = c[i];
            c[i] = tmp;
        }
    }
     *///----------------------------


    /**
        Individual i = new Individual();

        i.setGene("0000000000000000000000000000000000000000000000");
        System.out.println(i.getGene());
        String gene1 = "0000000000000000000000000000000000000000000000";
        String gene2 = "1111111111111111111111111111111111111111111111";
        Species.crossOver(i, gene1, gene2);
        System.out.println(i.getGene());
        Individual[] in = new Individual[6];
        Individual a = new Individual();
        Individual b = new Individual();
        Individual c = new Individual();
        Individual d = new Individual();
        Individual e = new Individual();
        Individual i = new Individual();
        a.setGene("0000110000000000000000000001110000000001110000");
        b.setGene("0000000001100000000000000000000000000000000000");
        c.setGene("1100010000000001100000000000000000000000000000");
        d.setGene("0000010000000000000000000000000000000000000000");
        e.setGene("0000010000111000100001000000000000000000000000");
        i.setGene("0000110000000000000000000001000100100100100000");

        in[0] = a;
        in[1] = b;
        in[2] = c;
        in[3] = d;
        in[4] = e;
        in[5] = i;

        Individual[] ss = Species.select(in,galaxy.getMine());
        for(Individual s :ss) {
            System.out.println (s.getxPosition ());
        }

    *///----------------------------

    /**
    public static void select(Individual[] individuals, Mine mine) {
     //Replace the lower half of the array with mutated genes

        Arrays.sort(individuals);
        Random random = new Random();
        int n = individuals.length;

        for (int i = n / 2; i < n; i++) {
            int r1 = random.nextInt(n / 2), r2 = random.nextInt(n / 2 - 1);
            r2 = r2 == r1 ? random.nextInt(n / 2 - 1) : r2;
            //mutation(individuals[i], individuals[r1].getGene());
            crossOverV2(individuals[i], individuals[r1].getGene(), individuals[r2].getGene());
            updateIndividual(individuals[i], mine);
        }
        Arrays.sort(individuals);

    }
     *///----------------------------


    /**
    private static void crossOver(Individual target, String gene1, String gene2) {
        String res = "";
        for (int i = 0; i < 46; i++) {
            if (Math.random() < 0.5) {
                res += gene1.charAt(i);
            } else {
                res += gene2.charAt(i);
            }
        }
        target.setGene(res);
    }
     *///----------------------------

    /**
    private static Individual crossover1(Individual individual) {
        // Crossover the genes
        // Called internally by selection()

        Individual res = individual;
        String subGeneX = individual.getGene().substring(0, 23);
        String subGeneY = individual.getGene().substring(23, 46);
        int subX = Integer.parseInt(subGeneX, 2);
        int subY = Integer.parseInt(subGeneY, 2);

        double x = subX * (10.0 - 0) / (Math.pow(2, 23) - 1);
        double y = subY * (10.0 - 0) / (Math.pow(2, 23) - 1);
        x = x > 0.1 ? x - 0.1 : x;
        y = y > 0.1 ? y - 0.1 : y;

        res.setxPosition(x);
        res.setyPosition(y);

        return res;
    }
     *///----------------------------

    /**
    private static Individual crossover2(Individual individual) {
        // Crossover the genes
        // Called internally by selection()

        Individual res2 = individual;
        String subGeneX = individual.getGene().substring(0, 23);
        String subGeneY = individual.getGene().substring(23, 46);
        int subX = Integer.parseInt(subGeneX, 2);
        int subY = Integer.parseInt(subGeneY, 2);

        double x = subX * (10.0 - 0) / (Math.pow(2, 23) + 1);
        double y = subY * (10.0 - 0) / (Math.pow(2, 23) + 1);
        x = x > 0.1 ? x + 0.1 : x;
        y = y > 0.1 ? y + 0.1 : y;

        res2.setxPosition(x);
        res2.setyPosition(y);

        return res2;
    }
     *///----------------------------

    /**
    public static void main(String[] arg) {
        String s1 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRST";
        //String s3 = "0000000000000000000000000000000000000000000000";

        String s2 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRST";

        String result = crossOverV2(s1,s2);
        System.out.println(result.length());
        System.out.println(result +"\n" + s1 );
    }
    *///----------------------------

	/**
	public static void main (String[] arg) {
		Galaxy galaxy = new Galaxy(10);
		Arrays.stream(galaxy.getMine_array()).forEach((x)
				-> {System.out.print(x.getxPosition());
					System.out.print("\t");
					System.out.println(x.getRadiation());
		});
	}
 	*///----------------------------

	private static void printMine () {
		Galaxy galaxy = new Galaxy(10);
		Arrays.stream(galaxy.getMine_array_1()).forEach((x)
				-> {System.out.print(x.getxPosition());
			System.out.print("\t");
			System.out.println(x.getRadiation());
		});
		System.out.println();
		Arrays.stream(galaxy.getMine_array_2()).forEach((x)
				-> {System.out.print(x.getxPosition());
			System.out.print("\t");
			System.out.println(x.getRadiation());
		});
		System.out.println();
		Arrays.stream(galaxy.getMine_array_3()).forEach((x)
				-> {System.out.print(x.getxPosition());
			System.out.print("\t");
			System.out.println(x.getRadiation());
		});
		System.out.println();
		Arrays.stream(galaxy.getMine_array_4()).forEach((x)
				-> {System.out.print(x.getxPosition());
			System.out.print("\t");
			System.out.println(x.getRadiation());
		});
		System.out.println();
		Arrays.stream(galaxy.getMine_array_5()).forEach((x)
				-> {System.out.print(x.getxPosition());
			System.out.print("\t");
			System.out.println(x.getRadiation());
		});
		System.out.println();
		Arrays.stream(galaxy.getMine_array_6()).forEach((x)
				-> {System.out.print(x.getxPosition());
			System.out.print("\t");
			System.out.println(x.getRadiation());
		});
		System.out.println();
		Arrays.stream(galaxy.getMine_array_7()).forEach((x)
				-> {System.out.print(x.getxPosition());
			System.out.print("\t");
			System.out.println(x.getRadiation());
		});
		System.out.println();
		Arrays.stream(galaxy.getMine_array_8()).forEach((x)
				-> {System.out.print(x.getxPosition());
			System.out.print("\t");
			System.out.println(x.getRadiation());
		});
	}

	private static void printIndividual () {
		Galaxy galaxy = new Galaxy(10);
		for(Individual x : galaxy.getSub_individuals_1()) {
			System.out.print(x.getxPosition() + "\t");
		}
		System.out.print("\n");

		for(Individual x : galaxy.getSub_individuals_2()) {
			System.out.print(x.getxPosition() + "\t");
		}
		System.out.print("\n");

		for(Individual x : galaxy.getSub_individuals_3()) {
			System.out.print(x.getxPosition() + "\t");
		}
		System.out.print("\n");

		for(Individual x : galaxy.getSub_individuals_4()) {
			System.out.print(x.getxPosition() + "\t");
		}
		System.out.print("\n");

		for(Individual x : galaxy.getSub_individuals_5()) {
			System.out.print(x.getxPosition() + "\t");
		}
		System.out.print("\n");

		for(Individual x : galaxy.getSub_individuals_6()) {
			System.out.print(x.getxPosition() + "\t");
		}
		System.out.print("\n");

		for(Individual x : galaxy.getSub_individuals_7()) {
			System.out.print(x.getxPosition() + "\t");
		}
		System.out.print("\n");

		for(Individual x : galaxy.getSub_individuals_8()) {
			System.out.print(x.getxPosition() + "\t");
		}
		System.out.print("\n");
	}
	public static void main (String[] arg) {
		printMine();
		System.out.println("------");
		printIndividual();
	}
}
