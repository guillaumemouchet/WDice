
package ch.hearc.dice.gui;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

import ch.hearc.c_gui.tools.decorateur.JFrameBaseLine;

public class JFrameBaseLineDice extends JFrameBaseLine
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public JFrameBaseLineDice(JComponent jcomponent, ImageIcon imageIcon)
		{
		super(jcomponent, imageIcon);
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
		setMinimumSize(new Dimension(800, 600));
		}
	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	}
