package visualise;

import javax.swing.JFrame;

public class Visualiser {
	
	private JFrame frame;
	
	public Visualiser() {
		// Start the visualiser
		
		frame = new JFrame();
		
		frame.setSize(800, 600);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		
		// Create a new visualisation panel
		
		
		
		
	}
	
	
	public void createPanel(ArrayList<Point> particles) {
		
		VisualisationPanel panel = new VisualisationPanel(particles);
		
		frame.add(panel);
		
	}

}
