
package ch.hearc.dice.gui.service;

public class DiceVariableServiceEvent
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public DiceVariableServiceEvent(LifeCycle lifeCycle)
		{
		this.lifeCycle = lifeCycle;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public LifeCycle getLifeCycle()
		{
		return this.lifeCycle;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs/Outputs
	//private DiceVariableService source; // inutile
	//private DiceVariable_I curentDiceVariable;
	//private DiceVariableInputs diceVariableInput;
	private LifeCycle lifeCycle;

	}
