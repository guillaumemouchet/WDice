
package ch.hearc.dice.gui.progressbars;

import javax.swing.Box;
import javax.swing.BoxLayout;

import ch.hearc.b_poo.j_thread.c_vecteurs.tools.Intervale;
import ch.hearc.c_gui.tools.Sizes;
import ch.hearc.dice.gui.tabExperience.Settings;
import ch.hearc.dice.moo.implementation.DiceVariableInputs;

public class JProgressBars extends Box
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JProgressBars()
		{
		super(BoxLayout.Y_AXIS);
		geometry();
		control();
		appearance();
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
		this.progressBarFace = new JProgressBarFace(new Intervale(DiceVariableInputs.NB_FACE_MIN, DiceVariableInputs.NB_FACE_MAX));
		this.progressBarGlobale = new JProgressBarGlobale();

		add(Box.createVerticalStrut(Settings.MARGE));
		add(progressBarFace);
		add(Box.createVerticalStrut(Settings.MARGE));
		add(progressBarGlobale);
		add(Box.createVerticalStrut(Settings.MARGE));
		add(Box.createVerticalStrut(Settings.MARGE));

		}

	private void control()
		{

		}

	private void appearance()
		{
		Sizes.setHorizontal(this, Settings.CONTROL_WIDTH);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//Tools
	private JProgressBarGlobale progressBarGlobale;
	private JProgressBarFace progressBarFace;

	}
