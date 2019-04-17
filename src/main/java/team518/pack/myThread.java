package team518.pack;

import java.util.ArrayList;
import java.util.Arrays;

public class myThread implements Runnable {
	private Individual[] subIndividual;
	private Mine[] subMine;
	private ArrayList<Mine> m_array;
	private int i;


	public myThread (Individual[] subIndividual, Mine[] subMine, int i,ArrayList<Mine> m_array){
		this.subIndividual = subIndividual;
		this.subMine = subMine;
		this.i = i;
		this.m_array = m_array;
		System.out.println ("Thread "+i);
	}
	@Override
	public void run () {
		Arrays.sort(subIndividual); //For print propose
		System.out.println("First generation: fitness   x   y   z");
		System.out.print("\n");
		for (Individual a : subIndividual) {
			System.out.print(a.getFitness () + "\t");
			System.out.print(a.getxPosition() + "\t");
			System.out.print(a.getyPosition() + "\t");
			System.out.println(a.getzPosition() + "\t");
		}
		Individual[] aux = new Individual[subIndividual.length];
		System.arraycopy (subIndividual,0,aux,0,aux.length);

		for(int i=0;i<1000;i++){
			Species.select (subIndividual,aux,subMine);
		}

		Arrays.sort(subIndividual); //For print propose
		System.out.println("Last generation: fitness   x   y   z");
		System.out.print("\n");
		for (Individual b : subIndividual) {
			System.out.print(b.getFitness () + "\t");
			System.out.print(b.getxPosition() + "\t");
			System.out.print(b.getyPosition() + "\t");
			System.out.println(b.getzPosition() + "\t");
		}
		System.out.print("\n");
		Arrays.sort(subMine,(Mine m1, Mine m2)->{return Double.compare(m2.getRadiation(),m1.getRadiation());}); //For print propose
		//For print propose
		System.out.println("Mine information: reserve   x   y   z");
		System.out.print("\n");
		for (Mine m : subMine) {
			System.out.print(m.getRadiation() + "\t");
			System.out.print(m.getxPosition() + "\t");
			System.out.print(m.getyPosition() + "\t");
			System.out.println(m.getzPosition() + "\t");
		}
		m_array.add (Fitness.find_Mine (subMine,subIndividual[0]));
	}
}
