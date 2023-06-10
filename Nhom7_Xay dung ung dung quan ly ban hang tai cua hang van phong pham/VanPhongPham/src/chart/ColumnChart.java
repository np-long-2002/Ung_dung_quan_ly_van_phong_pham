package chart;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.category.DefaultCategoryDataset;

import dao.HoaDonDAO;;

public class ColumnChart extends ApplicationFrame {

    public ColumnChart(String title) {
        super(title);

        JPanel chartPanel = createChartPanel();
        chartPanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartPanel);
    }

    private JPanel createChartPanel() {
        String chartTitle = "Doanh thu theo tháng";
        String categoryAxisLabel = "Tháng";
        String valueAxisLabel = "Doanh thu (VNĐ)";

        DefaultCategoryDataset dataset = createDataset();

        JFreeChart chart = ChartFactory.createBarChart(chartTitle, categoryAxisLabel, valueAxisLabel, dataset,
                PlotOrientation.VERTICAL, true, true, false);

        // Set color for the chart
        chart.setBackgroundPaint(Color.white);

        // Set color for the plot
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        // Create chart panel to display the chart
        ChartPanel chartPanel = new ChartPanel(chart);
        return chartPanel;
    }

    private DefaultCategoryDataset createDataset() {
        String series = "Doanh thu";
        String[] categories = { "T1", "T2", "T3", "T4", "T5", "T6", "T7",
                "T8", "T9", "T10", "T11", "T12" };

        List<Double> data = getData(); // Get data for 12 months

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < data.size(); i++) {
            dataset.addValue(data.get(i), series, categories[i]);
        }

        return dataset;
    }

    private List<Double> getData() {
        // Dummy data for 12 months
        List<Double> data = new ArrayList<Double>();
        HoaDonDAO hoaDonDao = new HoaDonDAO();
        for(String i : hoaDonDao.getTongDoanhThu12Thang()){
        	data.add(Double.parseDouble(i));
        }

        return data;
    }

//    public static void main(String[] args) {
//        ColumnChart chart = new ColumnChart("Sơ đồ cột doanh thu 12 tháng");
}