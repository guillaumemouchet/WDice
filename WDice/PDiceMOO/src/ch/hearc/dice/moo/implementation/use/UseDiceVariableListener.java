
package ch.hearc.dice.moo.implementation.use;

import java.util.Map;

import ch.hearc.b_poo.j_thread.c_vecteurs.tools.Intervale;
import ch.hearc.dice.moo.implementation.DiceVariableInputs;
import ch.hearc.dice.moo.implementation.TypeProcessing;
import ch.hearc.dice.moo.specification.DiceVariable_I;
import ch.hearc.dice.moo.specification.FactoryDiceVariable;
import ch.hearc.tools.algo.IterationEvent;
import ch.hearc.tools.algo.IterationListener;

public class UseDiceVariableListener
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
		DiceVariableInputs diceVariableInputs = new DiceVariableInputs(new Intervale(6, 36), 10000, TypeProcessing.SEQUENTIEL);

		DiceVariable_I diceVariable = FactoryDiceVariable.create(diceVariableInputs);
		// classe interne anonyme
		IterationListener iterationListener = createIterationListener();

		/*
		 * N'affiche rien si le add est commenté
		 */
		diceVariable.addIterationListener(iterationListener);
		diceVariable.run();

		Map<Integer, Integer> nbLancerMoyen = diceVariable.getMapFaceLancer();

		System.out.println(nbLancerMoyen);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static IterationListener createIterationListener()
		{
		return new IterationListener()
			{

			@Override
			public void iterationPerformed(IterationEvent iterationEvent)
				{
				System.out.println("Iteration numéro: [" + iterationEvent.getI() + "] est finie");
				}
			};

		}
	}
