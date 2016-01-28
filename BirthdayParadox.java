import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;

public class BirthdayParadox {
	private static double[] array; // 0 to 350 people
	private static double[] probs; // probabilities 0 - 1.0
	
	// probabilities of two people in same room having same birthday
	public static void findProb(){
		int n = 351; // 0 to 350 people
		array = new double[n]; 
		probs = new double[n];
		
		double result = 1.0;
		double days = 365.00;
		double diffBday = 365.00;
		
		for(int i = 1; i < n; i++){
			result *= diffBday / days;
			diffBday -= 1;
			
			array[i] = i; // people
			probs[i] = 1 - result; // probability
			System.out.println("i = " + i + " Prob: " + probs[i]);
		}
	}
	
    public static void main(String args[]) {
    	findProb(); // find probabilities
    	
    	// make graph
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	// create frame
                JFrame frame = new JFrame("Charts");
                frame.setSize(1000, 1000);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
                
                // call createDataset and make the chart
                XYDataset ds = createDataset();
                JFreeChart chart = ChartFactory.createScatterPlot("The Birthday Problem", "number of people", 
                		"prob 2 people have same bday", ds);

                // adjust plotting scale
                XYPlot xyPlot = (XYPlot) chart.getPlot();
                
                // adjust y axis to be 0 to 1.0 with ticks of 0.25
                NumberAxis range = (NumberAxis) xyPlot.getRangeAxis();
                range.setRange(0.0, 1.0);
                range.setTickUnit(new NumberTickUnit(0.25));
                
                // adjust x axis to be 0 to 350 with tickets of 10
                NumberAxis domain = (NumberAxis) xyPlot.getDomainAxis();
                domain.setRange(0.0, 350.0);
                domain.setTickUnit(new NumberTickUnit(10));
                
                ChartPanel cp = new ChartPanel(chart); // make the chart with the previous info
                frame.getContentPane().add(cp); // add chart to content pane
            }
        });
    }

    // create 2d array dataset for plotting
    private static XYDataset createDataset() {
        DefaultXYDataset ds = new DefaultXYDataset(); // create xy dataset
        double[][] data = {array, probs}; // 2d array holds probabilities with corresponding index
        ds.addSeries("Bday Dataset", data);
        return ds;
    }
}