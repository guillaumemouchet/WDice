
package ch.hearc.dice.gui.tabExperience.controls;

import javax.swing.JLabel;

import ch.hearc.dice.gui.service.DiceVariableService;
import ch.hearc.dice.gui.service.DiceVariableServiceEvent;
import ch.hearc.dice.gui.service.DiceVariableServiceListener;
import ch.hearc.dice.gui.service.LifeCycle;

public class JOutputTexte extends JLabel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JOutputTexte(String s)
		{
		super(s);
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

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
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
					JOutputTexte.this.setText("Experiment started");
					}
				if (diceVariableServiceEvent.getLifeCycle() == LifeCycle.KILLED)
					{
					JOutputTexte.this.setText("Experiment killed");
					}
				if (diceVariableServiceEvent.getLifeCycle() == LifeCycle.STOPPED)
					{
					JOutputTexte.this.setText("Experiment stopped clean");
					}
				}
			};
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	}
