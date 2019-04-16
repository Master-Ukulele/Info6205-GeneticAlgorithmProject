package team518.pack;

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
		fitness = mine.getRadiation ()/(d*d);
		return fitness;
		//return d;

	}
}
