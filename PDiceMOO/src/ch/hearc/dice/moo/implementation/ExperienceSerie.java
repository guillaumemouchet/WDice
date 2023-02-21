
package ch.hearc.dice.moo.implementation;

public class ExperienceSerie implements Runnable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public ExperienceSerie(int nbExperiences, int nbFace)
		{
		// Inputs
			{
			this.nbExperiences = nbExperiences;
			}

		// Outputs
			{
			this.nbLancerTotal = 0;
			}

		// Tools
			{
			this.experience = new Experience(nbFace);
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void run()
		{
		for(int i = 0; i < nbExperiences; i++)
			{
			experience.run();
			nbLancerTotal += experience.getNbLancer();
			}
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public long getNbLancerTotal()
		{
		return this.nbLancerTotal;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Input
	private int nbExperiences;

	// Output
	private long nbLancerTotal;

	// Tools
	private Experience experience;
	}
