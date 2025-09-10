
package ch.hearc.dice.moo.implementation.use;

import java.util.Map;

import ch.hearc.b_poo.j_thread.c_vecteurs.tools.Intervale;
import ch.hearc.dice.moo.implementation.DiceVariable;
import ch.hearc.dice.moo.implementation.DiceVariableInputs;
import ch.hearc.dice.moo.implementation.TypeProcessing;
import ch.hearc.dice.moo.specification.DiceVariable_I;
import ch.hearc.dice.moo.specification.FactoryDiceVariable;

public class UseDiceVariable
	{
	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void main(String[] args)
		{
		main();
		}

	public static void main()
		{
		// V1
			{
			DiceVariableInputs diceVariableInputs = new DiceVariableInputs(new Intervale(6, 36), 10000, TypeProcessing.SEQUENTIEL);
			DiceVariable diceVariable = new DiceVariable(diceVariableInputs);
			diceVariable.run();

			Map<Integer, Integer> nbLancerMoyen = diceVariable.getMapFaceLancer();

			System.out.println("Utilisation de DiceVariable:\n"+ nbLancerMoyen);
			}

		// V2 - Utilisation de la Factory
			{
			DiceVariableInputs diceVariableInputs = new DiceVariableInputs(new Intervale(6, 36), 10000, TypeProcessing.SEQUENTIEL);
			DiceVariable_I diceVariable = FactoryDiceVariable.create(diceVariableInputs);
			diceVariable.run();
			Map<Integer, Integer> nbLancerMoyen = diceVariable.getMapFaceLancer();
			System.out.println("Utilisation de la Factory:\n" +nbLancerMoyen);
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
