
package ch.hearc.dice.moo.implementation.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ch.hearc.dice.moo.implementation.Dice;
import ch.hearc.dice.moo.implementation.TypeProcessing;

public class TestDice
	{
	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/


	private static final int LANCER_MOYEN = 15; //le nombre de lancer pour 6 faces est connu

	/*------------------------------------------------------------------*\
	 |*							Methodes Public							*|
	 \*-----------------------------------------------------------------*/

	@Test
	public void testSequential()
		{
		Dice dice = new Dice(TypeProcessing.SEQUENTIEL);

		dice.run();

		Assertions.assertEquals(dice.getNbLancerMoyen(), LANCER_MOYEN);
		}

	@Test
	public void testRunnable()
		{
		Dice dice = new Dice(TypeProcessing.RUNNABLE);

		dice.run();

		Assertions.assertEquals(dice.getNbLancerMoyen(), LANCER_MOYEN);
		}

	@Test
	public void testParallel()
		{
		Dice dice = new Dice(TypeProcessing.PARALLEL);

		dice.run();

		Assertions.assertEquals(dice.getNbLancerMoyen(), LANCER_MOYEN);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/
	}
