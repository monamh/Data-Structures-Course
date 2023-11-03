package LinearTimeSorting;

import javax.swing.*;
import java.util.Random;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class Chart {
    public Chart() {
        JPanel panel = createChartPanel();
        JFrame frame = new JFrame();
        frame.add(panel);
        frame.setSize(70, 700);
        frame.setVisible(true);
    }

    private JPanel createChartPanel() {
        String chartTitle = "Comparison Chart";
        String xAxisLabel = "N";
        String yAxisLabel = "TIME";

        XYDataset dataset = createDataset();

        //JFreeChart chartt = (JFreeChart) ChartFactory.createXYLineChart(chartTitle,xAxisLabel,yAxisLabel,createDataset());
        boolean showLegend = true;
        boolean createURL = true;
        boolean createTooltip = false;

        JFreeChart chart = ChartFactory.createXYLineChart(chartTitle,
                xAxisLabel, yAxisLabel, dataset, PlotOrientation.VERTICAL, showLegend, createTooltip, createURL);

        return new ChartPanel(chart);
    }


    XYDataset createDataset() {
        XYSeriesCollection datasett = new XYSeriesCollection();
        XYSeries series1 = new XYSeries("BucketSort");
        XYSeries series2 = new XYSeries("CountingSort");
        XYSeries series3 = new XYSeries("RadixSort");
        Random r = new Random();
        int n = 150;
        //debug
        float[] test={(float)0.2};
        BucketSort.sort(test);
        //debug

        for (int i = 2; i < n; i=i+4) {
            float[] a = new float[i];
            int[] b = new int[i];
            int[] c = new int[i];
            int[] b_sorted = new int[i];
            for (int j = 0; j < i; j++) {
                //a[j]=r.nextInt(1);
                a[j] = (float) Math.random();
                b[j] = (int) (a[j] * 100);
                c[j] = (int) (a[j] * 100);

            }
            series1.add(i, BucketSort.sort(a));
            series2.add(i, CountingSort.sort(b, b_sorted, 100));
            series3.add(i, RadixSort.sort(c, 3));

        }
        datasett.addSeries(series1);
        datasett.addSeries(series2);
        datasett.addSeries(series3);
        return datasett;
    }

    public static void main(String[] args){
        Chart x=new Chart();
    }
}

