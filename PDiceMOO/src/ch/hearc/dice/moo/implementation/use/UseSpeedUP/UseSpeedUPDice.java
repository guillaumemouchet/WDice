
package ch.hearc.dice.moo.implementation.use.UseSpeedUP;

import ch.hearc.dice.moo.implementation.Dice;
import ch.hearc.dice.moo.implementation.TypeProcessing;
import ch.hearc.tools.Chrono;

public class UseSpeedUPDice
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
		//Récupération des propriété système
		int nbFace = Integer.parseInt(System.getProperty("nbFace"));
		int nbExperience = Integer.parseInt(System.getProperty("nbExperience"));

		Chrono chrono = new Chrono();

		long endTimeParallel = runParallel(nbFace, nbExperience, chrono);

		long endTimeSequentiel = runSequentiel(nbFace, nbExperience, chrono);

		//SpeedUp
		int nbCore = Runtime.getRuntime().availableProcessors();
		double speedUp = (double)endTimeSequentiel / endTimeParallel;
		System.out.println("Le nombre de core est de " + nbCore + " avec un SpeedUp de " + speedUp);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static long runParallel(int nbFace, int nbExperience, Chrono chrono)
		{
		Dice dice = new Dice(nbFace, nbExperience, TypeProcessing.PARALLEL);

		chrono.start();
		dice.run();
		long endTimeParallel = chrono.stop();
		int nbLancerMoyenParallel = dice.getNbLancerMoyen();
		System.out.println("Nombre de lancer moyen parallel : " + nbLancerMoyenParallel + " en un temps de : " + chrono.toString());

		return endTimeParallel;
		}

	private static long runSequentiel(int nbFace, int nbExperience, Chrono chrono)
		{
		Dice dice = new Dice(nbFace, nbExperience, TypeProcessing.SEQUENTIEL);

		chrono.start();
		dice.run();
		long endTimeSequentiel = chrono.stop();
		int nbLancerMoyenSequentiel = dice.getNbLancerMoyen();

		System.out.println("Nombre de lancer moyen sequentiel : " + nbLancerMoyenSequentiel + " en un temps de : " +  chrono.toString());
		return endTimeSequentiel;
		}
	}
