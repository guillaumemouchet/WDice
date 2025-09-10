
package ch.hearc.dice.gui;

import ch.hearc.dice.gui.images.MagasinImages;

public class UseGui
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
		new JFrameBaseLineDice(JDice.getInstance(), MagasinImages.DICES);
		}

	/*--------------------------------------l----------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
