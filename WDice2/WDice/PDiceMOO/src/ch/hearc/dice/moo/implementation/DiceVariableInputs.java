
package ch.hearc.dice.moo.implementation;

import ch.hearc.b_poo.j_thread.c_vecteurs.tools.Intervale;

public class DiceVariableInputs
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public DiceVariableInputs(Intervale intervalNbFace, int nbExperience, TypeProcessing typeProcessing)
		{
		this.intervalNbFace = intervalNbFace;
		this.nbExperience = nbExperience;
		this.typeProcessing = typeProcessing;
		}

	public DiceVariableInputs()
		{
		this(createIntervale(), NB_EXPERIENCE, TYPE_PROCESSING);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void setNbExperience(int nbExperience)
		{
		this.nbExperience = nbExperience;
		}

	public void setIntervale(Intervale intervale)
		{
		this.intervalNbFace = intervale;
		}

	public void setProcessing(TypeProcessing typeProcessing)
		{
		this.typeProcessing = typeProcessing;
		}
	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public Intervale getIntervale()
		{
		return this.intervalNbFace;
		}

	public int getExperience()
		{
		return this.nbExperience;
		}

	public TypeProcessing getProcessing()
		{
		return this.typeProcessing;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static Intervale createIntervale()
		{
		return new Intervale(NB_FACE_MIN, NB_FACE_MAX);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs/outputs
	private Intervale intervalNbFace; // [a,b[
	private int nbExperience;
	private TypeProcessing typeProcessing;

	/*------------------------------*\
	|* 			Static 				*|
	\*------------------------------*/

	public static final int NB_FACE_MIN = 6;
	public static final int NB_FACE_MAX = 200;
	public static final int NB_EXPERIENCE = Integer.MAX_VALUE / 100;
	public static final TypeProcessing TYPE_PROCESSING = TypeProcessing.PARALLEL;
	}
