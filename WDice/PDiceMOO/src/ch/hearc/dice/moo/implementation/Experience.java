
package ch.hearc.dice.moo.implementation;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Experience implements Runnable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Experience(int nbFaces)
		{
		// Inputs
			{
			this.nbFaces = nbFaces;
			}

		// Outputs
			{
			this.nbLancer = 0;
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void run()
		{
		Set<Integer> setFaces = new HashSet<Integer>();
		this.nbLancer = 0;

		do
			{
			int random = getRandom(nbFaces);

			setFaces.add(random);

			this.nbLancer++;

			} while(setFaces.size() < nbFaces);
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public int getNbLancer()
		{
		return this.nbLancer;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static int getRandom(int min, int max)
		{
		double randomDouble = ThreadLocalRandom.current().nextDouble();
		int random = min + (int)(randomDouble * (max - min));

		//Assertions.assertTrue(random >= min && random < max); //A commenter pour pouvoir le lancer en ligne de commande

		return random;
		}

	private static int getRandom(int max)
		{
		return getRandom(0, max);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	private int nbFaces;

	// Outputs
	private int nbLancer;
	}
