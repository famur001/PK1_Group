
package Praktikum_11_A1;

public class TimerValue implements TimerListener {

	private int sekunden;
	
	@Override
	public void signalPerformed() {
		++sekunden;
		System.out.printf("%d %s seit Start",
				sekunden,
				(sekunden > 1) ? "Sekunden" : "Sekunde" );
	}
	
}
