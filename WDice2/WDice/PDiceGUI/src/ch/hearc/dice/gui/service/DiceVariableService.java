
package ch.hearc.dice.gui.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.jupiter.api.Assertions;

import ch.hearc.dice.moo.implementation.DiceVariableInputs;
import ch.hearc.dice.moo.specification.DiceVariable_I;
import ch.hearc.dice.moo.specification.FactoryDiceVariable;
import ch.hearc.tools.algo.EtatAlgo;
import ch.hearc.tools.algo.IterationEvent;
import ch.hearc.tools.algo.IterationListener;

/**
 * singleton
 */
public class DiceVariableService
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	private DiceVariableService()
		{
		this.listDiceVariableServiceListener = new ArrayList<DiceVariableServiceListener>();
		this.isStarted = new AtomicBoolean(false);
		this.diceVariableInput = new DiceVariableInputs();
		}

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static synchronized DiceVariableService getInstance()
		{
		if (instance == null)
			{
			instance = new DiceVariableService();
			}

		return instance;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/**
	* use by JInputs every time a input change
	*/
	public void setInputs(DiceVariableInputs diceVariableInput)
		{
		this.diceVariableInput = diceVariableInput;
		}

	/*------------------------------------------------------------------*\
	|* start/stop/kill *|
	\*------------------------------------------------------------------*/

	public synchronized void start() // called by buttonStart
		{
		Assertions.assertTrue(diceVariableInput != null);
		if (!isStarted.get())
			{

			this.currentDiceVariable = FactoryDiceVariable.create(diceVariableInput);
			this.avertirDiceVariableListener(new DiceVariableServiceEvent(LifeCycle.CREATED_STARTED));
			this.avertirDiceVariableListener(new DiceVariableServiceEvent(LifeCycle.RUNNING));

			this.thread = new Thread(this.currentDiceVariable);
			this.thread.start();
			this.isStarted.set(true);

			this.listening();

			}
		else
			{
			System.out.println("Thread already started");
			}
		}

	public synchronized void stop()
		{
		// called by buttonStop {
		if (isStarted.get())
			{
			this.currentDiceVariable.stop();
			this.avertirDiceVariableListener(new DiceVariableServiceEvent(LifeCycle.STOPPED));
			this.isStarted.set(false);
			//this.listening();
			}
		else
			{
			System.out.println("No thread sarted");
			}
		}

	public synchronized void kill() // called by buttonKill
		{
		if (isStarted.get())
			{

			this.avertirDiceVariableListener(new DiceVariableServiceEvent(LifeCycle.KILLED));

			this.isStarted.set(false);
			this.thread.stop();
			//this.thread.interrupt();
			}
		else
			{
			System.out.println("No thread sarted");
			}
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public DiceVariable_I getCurentDiceVariable()
		{
		return currentDiceVariable;
		}

	/*------------------------------------------------------------------*\
	|* 							listener 								*|
	\*------------------------------------------------------------------*/

	public synchronized void addDiceVariableServiceListener(DiceVariableServiceListener diceVariableServiceListener)
		{
		this.listDiceVariableServiceListener.add(diceVariableServiceListener);
		}

	public synchronized void removeDiceVariableServiceListener(DiceVariableServiceListener diceVariableServiceListener)
		{
		this.listDiceVariableServiceListener.remove(diceVariableServiceListener);
		}

	private synchronized void avertirDiceVariableListener(DiceVariableServiceEvent diceVariableEvent)
		{
		for(DiceVariableServiceListener diceVariableServiceListener:listDiceVariableServiceListener)
			{
			diceVariableServiceListener.diceVariableServicePerformed(diceVariableEvent);
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void listening()
		{
		this.currentDiceVariable.addIterationListener(createIterationListener());
		}

	private IterationListener createIterationListener()
		{
		return new IterationListener()
			{

			@Override
			public void iterationPerformed(IterationEvent iterationEvent)
				{
				if (iterationEvent.getEtatAlgo() == EtatAlgo.END)
					{
					DiceVariableService.this.isStarted.set(false);
					avertirDiceVariableListener(new DiceVariableServiceEvent(LifeCycle.STOPPED));
					}

				}
			};
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private DiceVariable_I currentDiceVariable;
	private List<DiceVariableServiceListener> listDiceVariableServiceListener;
	private AtomicBoolean isStarted;
	private Thread thread;
	// Inputs
	private DiceVariableInputs diceVariableInput;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static DiceVariableService instance = null;

	}
