
package ch.hearc.tools.algo;

public interface AlgoIteratif_I extends Runnable
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void stop(); // arret naturel (non instantané)

	public void addIterationListener(IterationListener iterationListener);

	public void removeIterationListener(IterationListener iterationListener);

	// abstrait : a implementer dans la classe deriver
	public void iterationStep(int i); // i indice de l’itération en cours

	public boolean isFini(int i); // i indice de l’itération en cours
	// a redefinir si besoin

	public void onBegin(); // appeler au debut de l’algo

	public void onEnd(); // appeler a la fin de l’algo

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/


	}
