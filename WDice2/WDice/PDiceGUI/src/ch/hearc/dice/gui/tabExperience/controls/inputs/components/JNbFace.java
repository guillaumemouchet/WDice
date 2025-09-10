
package ch.hearc.dice.gui.tabExperience.controls.inputs.components;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.junit.jupiter.api.Assertions;

import ch.hearc.b_poo.j_thread.c_vecteurs.tools.Intervale;
import ch.hearc.c_gui.tools.Sizes;
import ch.hearc.dice.gui.tabExperience.Settings;
import ch.hearc.dice.gui.tabExperience.controls.inputs.JInputs;
import ch.hearc.dice.moo.implementation.DiceVariableInputs;

public class JNbFace extends Box
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JNbFace(JInputs jInputs)
		{
		super(BoxLayout.Y_AXIS);
		this.jInputs = jInputs;
		this.min = 6;
		this.max = 200;
		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	public void disableInputs()
		{
		this.spinnerMax.setEnabled(false);
		this.spinnerMin.setEnabled(false);
		}

	public void enableInputs()
		{
		this.spinnerMax.setEnabled(true);
		this.spinnerMin.setEnabled(true);
		}
	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		int minInitial = DiceVariableInputs.NB_FACE_MIN;
		int maxInitial = DiceVariableInputs.NB_FACE_MAX;

		Assertions.assertTrue(minInitial < maxInitial);

		SpinnerModel minModel = new SpinnerNumberModel(minInitial, min, max, 1);
		SpinnerModel maxModel = new SpinnerNumberModel(maxInitial, min, max, 1);

		this.spinnerMin = new JSpinner(minModel);
		this.spinnerMax = new JSpinner(maxModel);

		this.spinnerMin.setValue(6);
		this.spinnerMax.setValue(200);

		add(Box.createVerticalStrut(Settings.MARGE));
		add(this.spinnerMin);
		add(Box.createVerticalStrut(Settings.MARGE));
		add(this.spinnerMax);
		add(Box.createVerticalStrut(Settings.MARGE));

		}

	private void control()
		{
		this.spinnerMax.addChangeListener(createChangeListener());
		this.spinnerMin.addChangeListener(createChangeListener());
		}

	private void appearance()
		{
		Sizes.setHorizontal(spinnerMax, Settings.LONG_WIDGET_WIDTH);
		Sizes.setHorizontal(spinnerMin, Settings.LONG_WIDGET_WIDTH);
		spinnerMax.setMaximumSize(new Dimension(Settings.LONG_WIDGET_WIDTH, Settings.BUTTON_HEIGHT));
		spinnerMin.setMaximumSize(new Dimension(Settings.LONG_WIDGET_WIDTH, Settings.BUTTON_HEIGHT));
		}

	private ChangeListener createChangeListener()
		{
		return new ChangeListener()
			{

			@Override
			public void stateChanged(ChangeEvent e)
				{
				JNbFace.this.nbFaceChanged();
				}
			};
		}

	protected void nbFaceChanged()
		{
		int newMin = (int)this.spinnerMin.getValue();
		int newMax = (int)this.spinnerMax.getValue();

		JNbFace.this.jInputs.setIntervale(new Intervale(newMin, newMax));

		//Making sure min spinner can never be above max spinner (and vice-versa)
		SpinnerModel minModel = new SpinnerNumberModel(newMin, this.min, newMax - 1, 1);
		SpinnerModel maxModel = new SpinnerNumberModel(newMax, newMin + 1, this.max, 1);

		this.spinnerMax.setModel(maxModel);
		this.spinnerMin.setModel(minModel);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//Inputs
	private JInputs jInputs;
	//Tools
	private JSpinner spinnerMin;
	private JSpinner spinnerMax;
	private int min;
	private int max;

	}
