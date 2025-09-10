
package ch.hearc.dice.gui.tabExperience.controls.inputs.components;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ch.hearc.c_gui.tools.Sizes;
import ch.hearc.dice.gui.tabExperience.Settings;
import ch.hearc.dice.gui.tabExperience.controls.inputs.JInputs;

public class JNbExperience extends Box
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JNbExperience(JInputs jInputs)
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
		this.slider.setEnabled(false);
		}

	public void enableInputs()
		{
		this.slider.setEnabled(true);
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		this.slider = new JSlider(10, 100000, 10000);
		this.label = new JLabel(Integer.toString(slider.getValue()));

		add(Box.createHorizontalStrut(Settings.MARGE));
		add(this.slider);
		add(this.label);
		add(Box.createHorizontalStrut(Settings.MARGE));
		}

	private void control()
		{
		this.slider.addChangeListener(createChangeListener());
		}

	private void appearance()
		{
		Sizes.setHorizontal(slider, Settings.LONG_WIDGET_WIDTH);
		}

	private ChangeListener createChangeListener()
		{
		return new ChangeListener()
			{

			@Override
			public void stateChanged(ChangeEvent e)
				{
				label.setText(Integer.toString(slider.getValue()));
				JNbExperience.this.jInputs.setNbExperience(slider.getValue());
				}
			};
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//Tools
	private JSlider slider;
	private JLabel label;
	private JInputs jInputs;

	}
