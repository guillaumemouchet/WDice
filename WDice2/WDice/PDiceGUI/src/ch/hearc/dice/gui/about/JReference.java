
package ch.hearc.dice.gui.about;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class JReference extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public JReference()
		{
		geometry();
		}
	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/
	private void geometry()
		{
		this.refDice = new JLabel("Dice icon created by Smashicons - Flaticon https://www.flaticon.com/free-icons/dice");
		this.refStop = new JLabel("Cancel icon created by Vitaly Gorbachev - Flaticon https://www.flaticon.com/free-icons/cancel");
		this.refPause = new JLabel("Pause icon created by Icongeek26 - Flaticon: https://www.flaticon.com/free-icons/pausePause");
		this.refPlay = new JLabel("Play icon created by Icongeek26 - Flaticon https://www.flaticon.com/free-icons/play-button");

		this.gridLayout = new GridLayout(-1, 1);

		setLayout(gridLayout);

		add(this.refPlay);
		add(this.refPause);
		add(this.refStop);
		add(this.refDice);

		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	private JLabel refPlay;
	private JLabel refStop;
	private JLabel refPause;
	private JLabel refDice;

	private GridLayout gridLayout;
	}
