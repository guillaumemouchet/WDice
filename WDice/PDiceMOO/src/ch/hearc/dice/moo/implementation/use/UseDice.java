
package ch.hearc.dice.moo.implementation.use;

import ch.hearc.dice.moo.implementation.Dice;
import ch.hearc.dice.moo.implementation.TypeProcessing;

public class UseDice
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
		Dice dice = new Dice(TypeProcessing.PARALLEL);

		dice.run();

		int nbLancerMoyen = dice.getNbLancerMoyen();

		System.out.println("Nombre de lancer moyen : " + nbLancerMoyen);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
