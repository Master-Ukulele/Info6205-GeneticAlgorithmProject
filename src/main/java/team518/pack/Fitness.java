package team518.pack;
import java.util.*;

public class Fitness {
	public static double fit(Individual individual, Mine mine){

		double fitness;
		double d;
		double x = individual.getxPosition(), y = individual.getyPosition(),z=individual.getzPosition (),
				X = mine.getxPosition(), Y = mine.getyPosition(), Z=mine.getzPosition ();
		double x_d = X-x;
		double y_d = Y-y;
		double z_d = Z-z;
		d = Math.sqrt (Math.pow (x_d,2)+Math.pow (y_d,2)+Math.pow (z_d,2));
		fitness = 1/(mine.getRadiation ()/(d*d)); //Smallest is the best fitted
		//!!!!! ----- Also change the direction in selecting step if apply the next line ----- !!!!!
		//fitness = mine.getRadiation ()/(d*d); //Largest is the best fitted
		return fitness;
	}

	public static double fit(Individual individual, Mine[] mine){

		if(mine.length==0)
			return 100000000;

		List<Double> fitness = new ArrayList<> ();
		for(Mine m:mine) {
//			System.out.println (fit (individual, m));
			fitness.add (fit (individual, m));

		}
		//Collections.sort (fitness,(Double a, Double b)->{return Double.compare (b,a);});
		Collections.sort(fitness);
		//individual.setFitness (fitness.get (0));
		return fitness.get(0);
	}

	public static Mine find_Mine(Mine[] mine, Individual individual){
		double m_X, m_Y, m_Z, i_X, i_Y, i_Z;
		Map<Double,Mine> map = new HashMap<> ();
		double d;

		i_X = individual.getxPosition ();
		i_Y = individual.getyPosition ();
		i_Z = individual.getzPosition ();

		for(Mine m: mine){
			m_X = m.getxPosition ();
			m_Y = m.getyPosition ();
			m_Z = m.getzPosition ();
			d=Math.sqrt (Math.pow (m_X-i_X,2)+Math.pow ((m_Y-i_Y),2)+Math.pow ((m_Z-i_Z),2));
			map.put (d,m);
		}

		Object[] key =  map.keySet ().toArray ();
		Arrays.sort (key);
		Mine min = map.get (key[0]);
//		System.out.println ("Min Mine");
//		System.out.println (min.getRadiation ());
//		System.out.println (min.getxPosition ());
//		System.out.println (min.getyPosition ());
//		System.out.println (min.getzPosition ());
		return min;

	}

}
