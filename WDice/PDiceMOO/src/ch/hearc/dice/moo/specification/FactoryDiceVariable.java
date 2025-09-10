
package ch.hearc.dice.moo.specification;

import ch.hearc.dice.moo.implementation.DiceVariable;
import ch.hearc.dice.moo.implementation.DiceVariableInputs;

public class FactoryDiceVariable
	{

	public static DiceVariable_I create(DiceVariableInputs diceVariableInput)
		{
			return new DiceVariable(diceVariableInput);
		}
	}
