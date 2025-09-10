
package ch.hearc.dice.gui.progressbars;

import javax.swing.JProgressBar;

import ch.hearc.b_poo.j_thread.c_vecteurs.tools.Intervale;
import ch.hearc.dice.gui.service.DiceVariableService;
import ch.hearc.dice.gui.service.DiceVariableServiceEvent;
import ch.hearc.dice.gui.service.DiceVariableServiceListener;
import ch.hearc.dice.gui.service.LifeCycle;
import ch.hearc.dice.moo.specification.DiceVariable_I;
import ch.hearc.tools.algo.EtatAlgo;
import ch.hearc.tools.algo.IterationEvent;
import ch.hearc.tools.algo.IterationListener;

public class JProgressBarFace extends JProgressBar
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JProgressBarFace(Intervale intervale)
		{
		super(intervale.getA(), intervale.getB());
		this.setString("Algorithm not started yet");
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

		}

	private void control()
		{
		DiceVariableService.getInstance().addDiceVariableServiceListener(createDIceVariableServiceListener());
		}

	private void appearance()
		{
		setStringPainted(true);
		}

	private DiceVariableServiceListener createDIceVariableServiceListener()
		{
		return new DiceVariableServiceListener()
			{

			@Override
			public void diceVariableServicePerformed(DiceVariableServiceEvent diceVariableServiceEvent)
				{
				if (diceVariableServiceEvent.getLifeCycle() == LifeCycle.CREATED_STARTED)
					{
					lancerProgressBar();
					}
				if (diceVariableServiceEvent.getLifeCycle() == LifeCycle.KILLED)
					{
					JProgressBarFace.this.setValue(0);
					JProgressBarFace.this.setString("Algorithme killed");
					}

				}
			};
		}

	private IterationListener createIterationListener()
		{
		return new IterationListener()
			{

			@Override
			public void iterationPerformed(IterationEvent iterationEvent)
				{
				if (iterationEvent.getEtatAlgo() == EtatAlgo.RUNNING)
					{
					JProgressBarFace.this.setString((iterationEvent.getI() + 1) + " sides done out of " + JProgressBarFace.this.getMaximum());
					JProgressBarFace.this.setValue(iterationEvent.getI() + 1);
					JProgressBarFace.this.repaint();
					}

				}
			};

		}

	private void lancerProgressBar()
		{

		if (iterationListener != null)
			{
			diceVariable.removeIterationListener(iterationListener);
			}

		Intervale nbFaces = DiceVariableService.getInstance().getCurentDiceVariable().getNbFaces();
		setMinimum(nbFaces.getA());
		setMaximum(nbFaces.getB() - nbFaces.getA());

		this.iterationListener = createIterationListener();
		this.diceVariable = DiceVariableService.getInstance().getCurentDiceVariable();
		this.diceVariable.addIterationListener(iterationListener);

		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//Tools
	private IterationListener iterationListener;
	private DiceVariable_I diceVariable;

	}
