package Praktikum_11_A1;

public class Timer implements Runnable {

	private TimerListener timerListener;
	private int delay;
	
	public Timer(TimerListener tl, int delay) {
		this.timerListener = tl;
		this.delay = delay;
	}
	
	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			try {
				timerListener.signalPerformed();
				Thread.sleep(delay);
			} catch(InterruptedException ex) {
				System.out.println("interrupted!");
			}
		}
	}
	
}
