
package ch.hearc.dice.moo.implementation;

import java.util.Vector;

import org.junit.jupiter.api.Assertions;

public class Dice implements Runnable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Dice(int nbFaces, int nbExperiences, TypeProcessing typeProcessing)
		{
		// Inputs
			{
			this.nbFaces = nbFaces;
			this.nbExperiences = nbExperiences;
			this.typeProcessing = typeProcessing;
			}

		// Tools
			{
			this.nbThreads = Runtime.getRuntime().availableProcessors(); //Normally 8
			this.nbExpThread = (int)Math.floor(nbExperiences / this.nbThreads);
			}

		// Outputs
			{
			this.mean = 0;
			}
		}

	public Dice(int nbExperiences, TypeProcessing typeProcessing)
		{
		this(NB_FACE, nbExperiences, typeProcessing);
		}

	public Dice(TypeProcessing typeProcessing)
		{
		this(NB_FACE, NB_EXPERIENCES, typeProcessing);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void run()
		{
		switch(this.typeProcessing)
			{
			case SEQUENTIEL:
				{
				runSequentiel();
				break;
				}
			case RUNNABLE:
				{
				runRunnable();
				break;
				}
			case PARALLEL:
				{
				runParallel();
				break;
				}
			default:
				{
				Assertions.fail("(Dice) in run(): unknowned processing type " + this.typeProcessing);
				break;
				}
			}
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public int getNbLancerMoyen()
		{
		return this.mean;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void runSequentiel()
		{

		int nbLancerTotal = 0;
		Experience experience = new Experience(this.nbFaces);

		for(int i = 0; i < this.nbExperiences; i++)
			{
			experience.run();
			nbLancerTotal += experience.getNbLancer();
			}

		double mean = (double)nbLancerTotal / this.nbExperiences;
		this.mean = (int)Math.ceil(mean);
		}

	private void runRunnable()
		{
		//Creation, run et on récupère la valeur total de experienceSerie
		ExperienceSerie experienceSerie = new ExperienceSerie(this.nbExperiences, this.nbFaces);

		experienceSerie.run();

		long nbLancerTotal = experienceSerie.getNbLancerTotal();

		double mean = (double)nbLancerTotal / this.nbExperiences;
		this.mean = (int)Math.ceil(mean);
		}

	private void runParallel()
		{
		// Creation de 2 arrays avec les threads et les series
		Vector<Thread> threads = new Vector<Thread>(); // size = this.nbThreads
		Vector<ExperienceSerie> experienceSeries = new Vector<ExperienceSerie>();

		long nbLancerTotal = 0;

		// Debut des séries dans les threads
		for(int k = 0; k < this.nbThreads; k++)
			{
			ExperienceSerie serie = new ExperienceSerie(this.nbExpThread, this.nbFaces);
			Thread thread = new Thread(serie);

			experienceSeries.add(serie);
			threads.add(thread);

			thread.start();
			}

		//Join sur les threads pour attendre la fin des series
		try
			{
			for(Thread thread:threads)
				{
				thread.join();
				}
			}
		catch (InterruptedException e)
			{
			e.printStackTrace();
			}

		// Récupération des résultats
		for(ExperienceSerie serie:experienceSeries)
			{
			nbLancerTotal += serie.getNbLancerTotal();
			}

		double mean = (double)nbLancerTotal / (this.nbThreads * this.nbExpThread); //Suivi de l'exemple en page 9, il faut divisé par ce qui a été réellement fait
		this.mean = (int)Math.ceil(mean);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	private int nbFaces;
	private int nbExperiences;
	private TypeProcessing typeProcessing;

	// Tools
	private int nbThreads;
	private int nbExpThread;

	// Outputs
	private int mean;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static final int NB_FACE = 6;
	private static final int NB_EXPERIENCES = Integer.MAX_VALUE / 1000;
	}
