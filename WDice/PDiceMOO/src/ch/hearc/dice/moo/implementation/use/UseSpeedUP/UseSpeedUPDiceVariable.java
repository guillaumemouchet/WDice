
package ch.hearc.dice.moo.implementation.use.UseSpeedUP;

import java.util.Map;

import ch.hearc.b_poo.j_thread.c_vecteurs.tools.Intervale;
import ch.hearc.dice.moo.implementation.DiceVariableInputs;
import ch.hearc.dice.moo.implementation.TypeProcessing;
import ch.hearc.dice.moo.specification.DiceVariable_I;
import ch.hearc.dice.moo.specification.FactoryDiceVariable;
import ch.hearc.tools.Chrono;

public class UseSpeedUPDiceVariable
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
		int nbFaceMin = Integer.parseInt(System.getProperty("nbFaceMin"));
		int nbFaceMax = Integer.parseInt(System.getProperty("nbFaceMax"));
		int nbExperience = Integer.parseInt(System.getProperty("nbExperience"));

		DiceVariableInputs diceVariableInputs = new DiceVariableInputs(new Intervale(nbFaceMin, nbFaceMax), nbExperience, TypeProcessing.PARALLEL);

		Chrono chrono = new Chrono();

		long endTimeParallel = runParallel(diceVariableInputs, chrono);

		long endTimeSequentiel = runSequentiel(diceVariableInputs, chrono);

		//SpeedUp
		double speedUp = (double)endTimeSequentiel / endTimeParallel;
		int nbCore = Runtime.getRuntime().availableProcessors();
		System.out.println("Le nombre de core est de " + nbCore + " avec un SpeedUp de " + speedUp);

		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static long runParallel(DiceVariableInputs diceVariableInputs, Chrono chrono)
		{

		DiceVariable_I diceVariable = FactoryDiceVariable.create(diceVariableInputs);

		chrono.start();
		diceVariable.run();
		long endTimeParallel = chrono.stop();
		Map<Integer, Integer> nbLancerMoyenParallel = diceVariable.getMapFaceLancer();

		System.out.println("Nombre de lancer moyen parallel : " + nbLancerMoyenParallel + " en un temps de : " + endTimeParallel);
		return endTimeParallel;

		}

	private static long runSequentiel(DiceVariableInputs diceVariableInputs, Chrono chrono)
		{
		DiceVariable_I diceVariable = FactoryDiceVariable.create(diceVariableInputs);

		chrono.start();
		diceVariable.run();
		long endTimeSequentiel = chrono.stop();
		Map<Integer, Integer> nbLancerMoyenSeq = diceVariable.getMapFaceLancer();

		System.out.println("Nombre de lancer moyen parallel : " + nbLancerMoyenSeq + " en un temps de : " + endTimeSequentiel);
		return endTimeSequentiel;
		}

	}
