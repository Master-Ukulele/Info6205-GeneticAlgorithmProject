package team518.pack;

public class Fitness {
	public static double fit(Individual individual, Mine mine){
		double fitness;
		double x = individual.getxPosition(), y = individual.getyPosition(),
				X = mine.getxPosition(), Y = mine.getyPosition();
		double x_d = X-x;
		double y_d = Y-y;
		fitness = Math.sqrt (Math.pow (x_d,2)+Math.pow (y_d,2));
		return fitness;
	}
}
