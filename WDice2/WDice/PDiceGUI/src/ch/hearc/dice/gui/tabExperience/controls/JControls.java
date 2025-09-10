
package ch.hearc.dice.gui.tabExperience.controls;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import ch.hearc.c_gui.tools.Sizes;
import ch.hearc.dice.gui.images.MagasinImages;
import ch.hearc.dice.gui.service.DiceVariableService;
import ch.hearc.dice.gui.service.DiceVariableServiceEvent;
import ch.hearc.dice.gui.service.DiceVariableServiceListener;
import ch.hearc.dice.gui.service.LifeCycle;
import ch.hearc.dice.gui.tabExperience.Settings;
import ch.hearc.dice.moo.specification.DiceVariable_I;
import ch.hearc.tools.algo.IterationEvent;
import ch.hearc.tools.algo.IterationListener;

public class JControls extends Box
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JControls()
		{
		super(BoxLayout.X_AXIS);

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
		this.boutonStart = new JButton(MagasinImages.PLAY);
		this.boutonStop = new JButton(MagasinImages.PAUSE);
		this.boutonKill = new JButton(MagasinImages.STOP);

		boutonStop.setEnabled(false);
		boutonKill.setEnabled(false);

		add(Box.createHorizontalStrut(Settings.MARGE));
		add(this.boutonStart);
		add(Box.createHorizontalGlue());
		add(this.boutonStop);
		add(Box.createHorizontalGlue());
		add(this.boutonKill);
		add(Box.createHorizontalStrut(Settings.MARGE));

		}

	private void control()
		{
		this.boutonStart.addActionListener(createStartAcionListener());
		this.boutonStop.addActionListener(createStopAcionListener());
		this.boutonKill.addActionListener(createKillAcionListener());

		DiceVariableService.getInstance().addDiceVariableServiceListener(createDiceVariableServiceListener());
		}

	private void appearance()
		{
		setBorder(BorderFactory.createTitledBorder("Experience controllers"));
		Sizes.setHorizontal(boutonKill, Settings.BUTTON_WIDTH);
		Sizes.setHorizontal(boutonStart, Settings.BUTTON_WIDTH);
		Sizes.setHorizontal(boutonStop, Settings.BUTTON_WIDTH);
		Sizes.setVertical(boutonKill, Settings.BUTTON_HEIGHT);
		Sizes.setVertical(boutonStart, Settings.BUTTON_HEIGHT);
		Sizes.setVertical(boutonStop, Settings.BUTTON_HEIGHT);
		Sizes.setHorizontal(this, Settings.CONTROL_WIDTH);
		}

	private ActionListener createKillAcionListener()
		{
		return new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				DiceVariableService.getInstance().kill();
				JControls.this.boutonStop.setEnabled(false);
				JControls.this.boutonStart.setEnabled(true);
				JControls.this.boutonKill.setEnabled(false);
				}
			};
		}

	private ActionListener createStopAcionListener()
		{
		return new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				DiceVariableService.getInstance().stop();
				JControls.this.boutonStop.setEnabled(false);
				JControls.this.boutonStart.setEnabled(true);
				JControls.this.boutonKill.setEnabled(false);
				}
			};
		}

	private ActionListener createStartAcionListener()
		{
		return new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				DiceVariableService.getInstance().start();
				JControls.this.boutonKill.setEnabled(true);
				JControls.this.boutonStop.setEnabled(true);
				JControls.this.boutonStart.setEnabled(false);
				}
			};
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
					updateButtonListeners();
					}
				}
			};
		}

	private void updateButtonListeners()
		{
		if (this.iterationListener != null)
			{
			this.diceVariable.removeIterationListener(this.iterationListener);
			}
		this.iterationListener = createIterationListener();
		this.diceVariable = DiceVariableService.getInstance().getCurentDiceVariable();
		this.diceVariable.addIterationListener(this.iterationListener);
		}

	private IterationListener createIterationListener()
		{
		return new IterationListener()
			{

			@Override
			public void iterationPerformed(IterationEvent iterationEvent)
				{
				switch(iterationEvent.getEtatAlgo())
					{
					case BEGIN:
						break;
					case END:
						JControls.this.boutonStart.setEnabled(true);
						JControls.this.boutonStop.setEnabled(false);
						JControls.this.boutonKill.setEnabled(false);
						break;
					case RUNNING:
						JControls.this.boutonStart.setEnabled(false);
						JControls.this.boutonStop.setEnabled(true);
						JControls.this.boutonKill.setEnabled(true);
						break;
					default:
						break;
					}
				}
			};
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs

	// Tools
	private JButton boutonStart;
	private JButton boutonStop;
	private JButton boutonKill;

	private DiceVariable_I diceVariable;
	private IterationListener iterationListener;
	}
