
package ch.hearc.dice.gui.chronometre;

import java.awt.BorderLayout;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.JPanel;

import ch.hearc.b_poo.j_thread.Threads;
import ch.hearc.c_gui.tools.decorateur.center.JCenter;
import ch.hearc.dice.gui.service.DiceVariableService;
import ch.hearc.dice.gui.service.DiceVariableServiceEvent;
import ch.hearc.dice.gui.service.DiceVariableServiceListener;
import ch.hearc.dice.gui.service.LifeCycle;
import ch.hearc.dice.moo.specification.DiceVariable_I;
import ch.hearc.tools.algo.EtatAlgo;
import ch.hearc.tools.algo.IterationEvent;
import ch.hearc.tools.algo.IterationListener;

public class JTimerHorloge extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JTimerHorloge()
		{

		this.horloge = new JPanelHorloge();
		this.digit = new JTimerDigit();
		this.isFini = new AtomicBoolean(true);
		this.secondes = 0;
		this.minutes = 0;
		this.heures = 0;


		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/


	public void startClock()
		{
		this.isFini.set(false);
		this.thread = new Thread(createRunnable());
		this.thread.start();
		}

	public void stopClock()
		{
		this.secondes = 0;
		this.minutes = 0;
		this.heures = 0;
		this.horloge.setTime(JTimerHorloge.this.secondes);
		this.digit.setTime(JTimerHorloge.this.heures, JTimerHorloge.this.minutes, JTimerHorloge.this.secondes);
		this.isFini.set(true);
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private Runnable createRunnable()
		{
		return new Runnable()
			{

			@Override
			public void run()
				{
				while(!isFini.get())
					{

					JTimerHorloge.this.horloge.setTime(JTimerHorloge.this.secondes % 60);
					JTimerHorloge.this.digit.setTime(JTimerHorloge.this.heures % 24, JTimerHorloge.this.minutes % 60, JTimerHorloge.this.secondes % 60);
					Threads.sleep(1000);
					JTimerHorloge.this.secondes++;
					if (secondes % 60 == 0)
						{
						JTimerHorloge.this.minutes++;
						}
					if (minutes % 60 == 0 && secondes % 60 == 0)
						{
						JTimerHorloge.this.heures++;
						}
					}
				}
			};
		}

	private void geometry()
		{

		this.centeredDigit = new JCenter(digit);

		BorderLayout borderLayout = new BorderLayout();
		setLayout(borderLayout);
		this.add(centeredDigit, BorderLayout.NORTH);
		this.add(horloge, BorderLayout.CENTER);

		}

	private void control()
		{
		DiceVariableService.getInstance().addDiceVariableServiceListener(createDiceVariableServiceListener());
		}

	private void appearance()
		{

		}

	private IterationListener createIterationListener()
		{
		return new IterationListener()
			{

			@Override
			public void iterationPerformed(IterationEvent iterationEvent)
				{
				if (iterationEvent.getEtatAlgo() == EtatAlgo.BEGIN)
					{
					startClock();
					}
				else if (iterationEvent.getEtatAlgo() == EtatAlgo.END)
					{
					stopClock();
					}

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
					if (JTimerHorloge.this.iterationListener != null)
						{
						JTimerHorloge.this.diceVariable.removeIterationListener(JTimerHorloge.this.iterationListener);
						}

					JTimerHorloge.this.iterationListener = createIterationListener();
					JTimerHorloge.this.diceVariable = DiceVariableService.getInstance().getCurentDiceVariable();
					JTimerHorloge.this.diceVariable.addIterationListener(JTimerHorloge.this.iterationListener);
					}

				if (diceVariableServiceEvent.getLifeCycle() == LifeCycle.KILLED)
					{
					JTimerHorloge.this.stopClock();
					}

				}

			};
		}


	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs

	// Tools
	private JPanelHorloge horloge;
	private JTimerDigit digit;
	private JCenter centeredDigit;
	private Thread thread;
	private int secondes;
	private AtomicBoolean isFini;
	private IterationListener iterationListener;
	private DiceVariable_I diceVariable;
	private int minutes;
	private int heures;

	}
