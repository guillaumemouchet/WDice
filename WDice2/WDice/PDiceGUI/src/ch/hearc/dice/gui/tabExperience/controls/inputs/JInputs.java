
package ch.hearc.dice.gui.tabExperience.controls.inputs;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;

import ch.hearc.b_poo.j_thread.c_vecteurs.tools.Intervale;
import ch.hearc.c_gui.tools.Sizes;
import ch.hearc.dice.gui.service.DiceVariableService;
import ch.hearc.dice.gui.service.DiceVariableServiceEvent;
import ch.hearc.dice.gui.service.DiceVariableServiceListener;
import ch.hearc.dice.gui.service.LifeCycle;
import ch.hearc.dice.gui.tabExperience.Settings;
import ch.hearc.dice.gui.tabExperience.controls.inputs.components.JNbExperience;
import ch.hearc.dice.gui.tabExperience.controls.inputs.components.JNbFace;
import ch.hearc.dice.gui.tabExperience.controls.inputs.components.JTypeProcessing;
import ch.hearc.dice.moo.implementation.DiceVariableInputs;
import ch.hearc.dice.moo.implementation.TypeProcessing;

public class JInputs extends Box
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JInputs()
		{
		super(BoxLayout.Y_AXIS);

		this.diceVariableInputs = new DiceVariableInputs();

		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void setNbExperience(int nbExperience)
		{
		this.diceVariableInputs.setNbExperience(nbExperience);
		DiceVariableService.getInstance().setInputs(this.diceVariableInputs);
		}

	public void setIntervale(Intervale intervale)
		{
		this.diceVariableInputs.setIntervale(intervale);
		DiceVariableService.getInstance().setInputs(this.diceVariableInputs);
		}

	public void setTypeProcessing(TypeProcessing typeProcessing)
		{
		this.diceVariableInputs.setProcessing(typeProcessing);
		DiceVariableService.getInstance().setInputs(this.diceVariableInputs);
		}

	public void disableInputs()
		{
		this.nbExperience.disableInputs();
		this.nbFace.disableInputs();
		this.typeProcessing.disableInputs();
		}

	public void enableInputs()
		{
		this.nbExperience.enableInputs();
		this.nbFace.enableInputs();
		this.typeProcessing.enableInputs();
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		this.nbExperience = new JNbExperience(this);
		this.nbFace = new JNbFace(this);
		this.typeProcessing = new JTypeProcessing(this);

		add(Box.createVerticalStrut(Settings.MARGE));
		add(this.nbExperience);
		add(Box.createVerticalGlue());
		add(this.nbFace);
		add(Box.createVerticalGlue());
		add(this.typeProcessing);
		add(Box.createVerticalStrut(Settings.MARGE));
		}

	private void control()
		{
		DiceVariableService.getInstance().addDiceVariableServiceListener(createDiceVariableServiceListener());
		}

	private void appearance()
		{
		setBorder(BorderFactory.createTitledBorder("Experience inputs"));
		Sizes.setHorizontal(this, Settings.CONTROL_WIDTH);
		}

	private DiceVariableServiceListener createDiceVariableServiceListener()
		{
		return new DiceVariableServiceListener()
			{

			@Override
			public void diceVariableServicePerformed(DiceVariableServiceEvent diceVariableServiceEvent)
				{
				if (diceVariableServiceEvent.getLifeCycle() == LifeCycle.CREATED_STARTED)
					{
					JInputs.this.disableInputs();
					}
				if (diceVariableServiceEvent.getLifeCycle() == LifeCycle.STOPPED || diceVariableServiceEvent.getLifeCycle() == LifeCycle.KILLED)
					{
					JInputs.this.enableInputs();
					}
				}

			};
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs

	// Tools
	private JNbExperience nbExperience;
	private JNbFace nbFace;
	private JTypeProcessing typeProcessing;
	private DiceVariableInputs diceVariableInputs;

	}
