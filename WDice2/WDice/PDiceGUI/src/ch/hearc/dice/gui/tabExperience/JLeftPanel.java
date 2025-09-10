
package ch.hearc.dice.gui.tabExperience;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;

import ch.hearc.c_gui.tools.Sizes;
import ch.hearc.c_gui.tools.decorateur.center.JCenter;
import ch.hearc.dice.gui.chronometre.JTimerHorloge;
import ch.hearc.dice.gui.progressbars.JProgressBars;
import ch.hearc.dice.gui.tabExperience.controls.JControls;
import ch.hearc.dice.gui.tabExperience.controls.JOutputTexte;
import ch.hearc.dice.gui.tabExperience.controls.inputs.JInputs;

public class JLeftPanel extends Box
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JLeftPanel()
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
		this.inputs = new JInputs();
		this.control = new JControls();
		this.outputTexte = new JOutputTexte(" ");
		this.outputTextCenter = new JCenter(outputTexte);
		this.progressBars = new JProgressBars();
		this.horloge = new JTimerHorloge();

		add(Box.createVerticalStrut(Settings.MARGE));
		add(this.inputs);
		add(Box.createVerticalGlue());
		add(this.control);
		add(Box.createVerticalGlue());
		add(this.progressBars);
		add(Box.createVerticalGlue());
		add(this.horloge);
		add(Box.createVerticalGlue());
		add(this.outputTextCenter);
		add(Box.createVerticalStrut(Settings.MARGE));

		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		Sizes.setHorizontal(this, Settings.CONTROL_WIDTH);
		this.setMaximumSize(new Dimension(Settings.CONTROL_WIDTH, HEIGHT));
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs

	// Tools
	private JInputs inputs;
	private JControls control;
	private JOutputTexte outputTexte;
	private JCenter outputTextCenter;

	private JProgressBars progressBars;
	private JTimerHorloge horloge;

	}
