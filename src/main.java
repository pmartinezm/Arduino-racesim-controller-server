

import javax.swing.JFrame;

import util.PerformanceDebugger;
import view.CLI;

public class main {

	public static void main(String[] args) {
		PerformanceDebugger pd = PerformanceDebugger.get();
		pd.start();
		int o = 0;
		for(int i = 0; i < 100000; i++) {
			System.out.println(i);
		}
		pd.stop();
		
		System.out.println(pd.getResults());
		
		new CLI();
	}
}
