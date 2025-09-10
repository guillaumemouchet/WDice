
package ch.hearc.dice.gui.graphes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.AbstractRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.general.Series;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import ch.hearc.b_poo.j_thread.Threads;
import ch.hearc.dice.gui.service.DiceVariableService;
import ch.hearc.tools.Chrono;

public class JGrapheDuration extends ChartPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JGrapheDuration()
		{

		super(createChart());

		this.series = new XYSeries("Duration");
		this.seriesCollection = new XYSeriesCollection();
		this.plot = new XYPlot();
		this.resetFlag = new AtomicBoolean(false);

		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	public void setSeries(Series series)
		{
		this.series = (XYSeries)series;
		}

	public void resetGraph()
		{
		this.resetFlag.set(true);
		}

	public void startGraph()
		{
		this.resetFlag.set(false);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{

		}

	private void control()
		{
		this.seriesCollection = (XYSeriesCollection)this.getChart().getXYPlot().getDataset();

		this.thread = new Thread(createRunnable());
		thread.start();
		}

	private void appearance()
		{
		display(this.getChart());
		}

	private static JFreeChart createChart()
		{
		XYSeriesCollection xyDataset = JGraphes.createDataset("Duration");
		return ChartFactory.createXYLineChart("Aperçu du temps nécessaire", "Nombre de Faces", "Temps d'execution (ms)", xyDataset, PlotOrientation.VERTICAL, true, true, false);
		}

	private void refreshXY()
		{
		if (resetFlag.get())
			{
			this.series.clear();
			}
		else
			{
			Map<Integer, Chrono> mapInt = DiceVariableService.getInstance().getCurentDiceVariable().getMapFaceChrono();

			for(Integer key:mapInt.keySet())
				{
				series.add((double)key, (double)mapInt.get(key).getTimeMS());
				}
			}

		}

	private JFreeChart display(JFreeChart chart)
		{
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		renderer.setSeriesShape(0, AbstractRenderer.DEFAULT_SHAPE);
		renderer.setSeriesPaint(0, Color.RED);
		renderer.setSeriesStroke(0, new BasicStroke());

		plot = chart.getXYPlot();
		plot.setRenderer(renderer);
		plot.setBackgroundPaint(Color.WHITE);
		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.LIGHT_GRAY);
		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.LIGHT_GRAY);

		return chart;
		}

	private Runnable createRunnable()
		{
		return new Runnable()
			{

			@Override
			public void run()
				{

				while(true)
					{
					if (DiceVariableService.getInstance().getCurentDiceVariable() != null)
						{
						refreshXY();

						seriesCollection = new XYSeriesCollection(series);
						plot.setDataset(seriesCollection);

						repaint();
						}
					Threads.sleep(1000);
					}
				}
			};
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//Tools
	private XYSeriesCollection seriesCollection;
	private XYPlot plot;
	private XYSeries series;
	private Thread thread;
	private AtomicBoolean resetFlag;

	}
