
package ch.hearc.tools.algo;

public class IterationEvent
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public IterationEvent(AlgoIteratif_A source, int i, EtatAlgo etatAlgo)
		{
		this.source = source;
		this.i = i;
		this.etatAlgo = etatAlgo;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public AlgoIteratif_A getSource()
		{
		return this.source;
		}

	public int getI()
		{
		return this.i;
		}

	public EtatAlgo getEtatAlgo()
		{
		return this.etatAlgo;
		}


	// Inputs / Outputs

	private int i; // l’indice de boucle de l’algo
	private EtatAlgo etatAlgo;
	private AlgoIteratif_A source;


	}
