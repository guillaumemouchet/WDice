
package ch.hearc.dice.gui.progressbars;

import javax.swing.JProgressBar;

import ch.hearc.dice.gui.service.DiceVariableService;
import ch.hearc.dice.gui.service.DiceVariableServiceEvent;
import ch.hearc.dice.gui.service.DiceVariableServiceListener;
import ch.hearc.dice.gui.service.LifeCycle;

public class JProgressBarGlobale extends JProgressBar
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JProgressBarGlobale()
		{
		super();
		this.setVisible(false);
		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{

		}

	private void control()
		{
		DiceVariableService.getInstance().addDiceVariableServiceListener(createDIceVariableServiceListener());

		}

	private void appearance()
		{
		this.setIndeterminate(true);
		}

	private DiceVariableServiceListener createDIceVariableServiceListener()
		{
		return new DiceVariableServiceListener()
			{

			@Override
			public void diceVariableServicePerformed(DiceVariableServiceEvent diceVariableServiceEvent)
				{
				if (diceVariableServiceEvent.getLifeCycle() == LifeCycle.CREATED_STARTED)
					{
					JProgressBarGlobale.this.setVisible(true);
					}
				if (diceVariableServiceEvent.getLifeCycle() == LifeCycle.KILLED || diceVariableServiceEvent.getLifeCycle() == LifeCycle.STOPPED)
					{
					JProgressBarGlobale.this.setVisible(false);
					}
				}
			};
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	}
