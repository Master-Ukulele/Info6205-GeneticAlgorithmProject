package team518.pack;

public class Fitness {
	public static double fit(double x, double y, double X, double Y){
		double fitness;
		double x_d = X-x;
		double y_d = Y-y;
		fitness = Math.sqrt (Math.pow (x_d,2)+Math.pow (y_d,2));
		return fitness;
	}
}
