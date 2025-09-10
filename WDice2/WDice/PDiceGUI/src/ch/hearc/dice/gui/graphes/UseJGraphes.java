
package ch.hearc.dice.gui.graphes;

import ch.hearc.c_gui.tools.decorateur.JFrameBaseLine;
import ch.hearc.dice.gui.service.DiceVariableService;

public class UseJGraphes
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
		new JFrameBaseLine(new JGraphes());
		DiceVariableService.getInstance().start();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
