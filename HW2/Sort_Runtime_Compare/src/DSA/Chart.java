package DSA;

import org.jfree.chart.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;

public class Chart {
    All[] all;
    public  Chart(All[] all){
        this.all = all;
        JPanel panel =  createChartPanel();
        JFrame frame = new JFrame();
        frame.add(panel);
        frame.setSize(700,700);
        frame.setVisible(true);
    }
     XYDataset createDataset() {
         XYSeriesCollection datasett = new XYSeriesCollection();
        XYSeries series1 = new XYSeries("Heapsort");
        XYSeries series2 = new XYSeries("Insertionsort");
        XYSeries series3 = new XYSeries("Mergesort");
        XYSeries series4 = new XYSeries("Quicksort");

        for(int i=0;i<all.length;i++){
            series1.add( all[i].h.size,all[i].h.time);
            System.out.println(all[i].h.size);
            series2.add( all[i].i.size,all[i].i.time);
            series3.add( all[i].m.size,all[i].m.time);
            series4.add( all[i].q.size,all[i].q.time);
        }
         datasett.addSeries(series1);
         datasett.addSeries(series2);
         datasett.addSeries(series3);
         datasett.addSeries(series4);

        return datasett;
    }

    private JPanel createChartPanel() {
        String chartTitle = "Objects Movement Chart";
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
}
