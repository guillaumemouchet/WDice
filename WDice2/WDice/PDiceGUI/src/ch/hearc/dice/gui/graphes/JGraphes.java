
package ch.hearc.dice.gui.graphes;

import javax.swing.JSplitPane;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import ch.hearc.dice.gui.service.DiceVariableService;
import ch.hearc.dice.gui.service.DiceVariableServiceEvent;
import ch.hearc.dice.gui.service.DiceVariableServiceListener;
import ch.hearc.dice.gui.service.LifeCycle;

public class JGraphes extends JSplitPane
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JGraphes()
		{
		super(JSplitPane.VERTICAL_SPLIT);
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
	|*			  Static			*|
	\*------------------------------*/

	public static XYSeriesCollection createDataset(String name)
		{
		return new XYSeriesCollection(new XYSeries(name));
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		this.grapheLancerMoyen = new JGrapheLancerMoyen();
		this.grapheDuration = new JGrapheDuration();

		this.setTopComponent(grapheDuration);
		this.setBottomComponent(grapheLancerMoyen);
		this.setResizeWeight(0.5);
		this.setDividerSize(0);
		}

	private void control()
		{
		DiceVariableService.getInstance().addDiceVariableServiceListener(createDIceVariableServiceListener());
		}

	private void appearance()
		{
		//rien
		}

	private void resetGraphs()
		{
		this.grapheLancerMoyen.resetGraph();
		this.grapheDuration.resetGraph();
		}

	private void startGraphs()
		{
		this.grapheLancerMoyen.startGraph();
		this.grapheDuration.startGraph();
		}

	private DiceVariableServiceListener createDIceVariableServiceListener()
		{
		return new DiceVariableServiceListener()
			{

			@Override
			public void diceVariableServicePerformed(DiceVariableServiceEvent diceVariableServiceEvent)
				{
				//On aurait souhaité réaliser le reset sur LifeCycle.CREATED_STARTED, ne fonctionne pas...
				/*if (diceVariableServiceEvent.getLifeCycle() == LifeCycle.CREATED_STARTED)
					{
					JGraphes.this.resetGraphs();
					}*/
				if (diceVariableServiceEvent.getLifeCycle() == LifeCycle.KILLED)
				{
				JGraphes.this.resetGraphs();
				}
				if (diceVariableServiceEvent.getLifeCycle() == LifeCycle.RUNNING)
					{
					JGraphes.this.startGraphs();
					}
				}
			};
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	private JGrapheLancerMoyen grapheLancerMoyen;
	private JGrapheDuration grapheDuration;

	}
