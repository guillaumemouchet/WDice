
package ch.hearc.tools;

public class Chrono
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public Chrono()
		{
		start();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	public void start()
		{
		stopped = false;
		startTime = System.currentTimeMillis();
		}

	public long stop()
		{
		endTime = System.currentTimeMillis();
		stopped = true;
		return getTimeMS();
		}

	@Override
	public String toString()
		{
		return getTimeMS() + "[ms]";
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public long getTimeMS()
		{
		if (stopped)//Savoir si c'est un temps intermédiaire ou non
			{
			return endTime - startTime;
			}
		else
			{
			return System.currentTimeMillis() - startTime; // Temps intermédiaire
			}
		}
	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//tools
	private boolean stopped = false;
	private long startTime;
	private long endTime;
	}
