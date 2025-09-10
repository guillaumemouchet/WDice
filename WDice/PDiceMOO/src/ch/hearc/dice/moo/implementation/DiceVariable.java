
package ch.hearc.dice.moo.implementation;

import java.util.HashMap;
import java.util.Map;

import ch.hearc.b_poo.j_thread.c_vecteurs.tools.Intervale;
import ch.hearc.dice.moo.specification.DiceVariable_I;
import ch.hearc.tools.Chrono;
import ch.hearc.tools.algo.AlgoIteratif_A;

public class DiceVariable extends AlgoIteratif_A implements DiceVariable_I
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public DiceVariable(DiceVariableInputs diceVariableInputs)
		{
		this.diceVariableInputs = diceVariableInputs;
		this.step = this.diceVariableInputs.getIntervale().getB() - this.diceVariableInputs.getIntervale().getA();

		this.mapFaceChrono = new HashMap<Integer, Chrono>();
		this.mapFaceLancer = new HashMap<Integer, Integer>();
		}
	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void iterationStep(int i) //--> nbStep
		{
		int nbFace = this.getNbFaces().getA() + i; //le nombre de face actuel correspond au pas ajouter sur le nombre de face minimum, on commence avec un pas de 0 puis de 1 etc

		Dice dice = new Dice(nbFace, this.diceVariableInputs.getExperience(), this.diceVariableInputs.getProcessing());

		Chrono chrono = new Chrono();

		dice.run();
		chrono.stop();

		int nbLancerMoyen = dice.getNbLancerMoyen();

		this.mapFaceChrono.put(nbFace, chrono);
		this.mapFaceLancer.put(nbFace, nbLancerMoyen);

		}

	@Override
	public boolean isFini(int i)
		{
		return i >= step;
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	@Override
	public Map<Integer, Integer> getMapFaceLancer()
		{
		return mapFaceLancer;
		}

	@Override
	public Map<Integer, Chrono> getMapFaceChrono()
		{
		return mapFaceChrono;
		}

	@Override
	public Intervale getNbFaces()
		{
		return this.diceVariableInputs.getIntervale();
		}

	@Override
	public int getNbExperience()
		{
		return this.diceVariableInputs.getExperience();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//inputs
	private DiceVariableInputs diceVariableInputs;

	//tools
	private int step;
	private Map<Integer, Chrono> mapFaceChrono;
	private Map<Integer, Integer> mapFaceLancer;
	}
