
package ch.hearc.dice.gui.tabExperience.controls.inputs.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import ch.hearc.dice.gui.tabExperience.Settings;
import ch.hearc.dice.gui.tabExperience.controls.inputs.JInputs;
import ch.hearc.dice.moo.implementation.TypeProcessing;

public class JTypeProcessing extends Box
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JTypeProcessing(JInputs jInputs)
		{
		super(BoxLayout.X_AXIS);

		this.jInputs = jInputs;

		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void disableInputs()
		{
		this.radioConcurrent.setEnabled(false);
		this.radioSequentiel.setEnabled(false);
		}

	public void enableInputs()
		{
		this.radioSequentiel.setEnabled(true);
		this.radioConcurrent.setEnabled(true);
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		this.radioConcurrent = new JRadioButton("Concurrent");
		this.radioSequentiel = new JRadioButton("Sequentiel");
		this.buttonGroup = new ButtonGroup();

		this.radioSequentiel.setSelected(true);

		this.buttonGroup.add(radioConcurrent);
		this.buttonGroup.add(radioSequentiel);
		add(Box.createHorizontalStrut(Settings.MARGE));
		add(this.radioConcurrent);
		add(Box.createHorizontalStrut(Settings.MARGE));
		add(this.radioSequentiel);
		add(Box.createHorizontalStrut(Settings.MARGE));

		}

	private void control()
		{

		this.radioConcurrent.addActionListener(createConcurrentActionListener());

		this.radioSequentiel.addActionListener(createSequentialActionListener());

		}

	private ActionListener createSequentialActionListener()
		{
		return new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				JTypeProcessing.this.jInputs.setTypeProcessing(TypeProcessing.SEQUENTIEL);
				}
			};
		}

	private ActionListener createConcurrentActionListener()
		{
		return new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				JTypeProcessing.this.jInputs.setTypeProcessing(TypeProcessing.PARALLEL);
				}
			};
		}

	private void appearance()
		{
		// rien
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	private JInputs jInputs;
	// Tools
	private JRadioButton radioSequentiel;
	private JRadioButton radioConcurrent;
	private ButtonGroup buttonGroup;

	}
