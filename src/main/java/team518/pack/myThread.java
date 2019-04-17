package team518.pack;

public class myThread implements Runnable {
	private int i;
	public myThread (int i){
		this.i = i;
	}
	@Override
	public void run () {
		System.out.println("This is thread "+i);
//		System.out.println (System.currentTimeMillis ());
	}
}
