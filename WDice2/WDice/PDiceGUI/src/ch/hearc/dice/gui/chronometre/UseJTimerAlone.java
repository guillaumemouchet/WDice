
package ch.hearc.dice.gui.chronometre;

import ch.hearc.c_gui.tools.decorateur.JFrameBaseLine;

public class UseJTimerAlone
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
		JTimerHorloge jTimerHorloge = new JTimerHorloge();
		new JFrameBaseLine(jTimerHorloge);
		jTimerHorloge.startClock();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
