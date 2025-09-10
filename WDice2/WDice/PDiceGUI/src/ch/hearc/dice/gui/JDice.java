
package ch.hearc.dice.gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class JDice extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	private JDice()
		{
		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static synchronized JDice getInstance()
		{
		if (instance == null)
			{
			instance = new JDice();
			}

		return instance;
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		this.centralWidget = new JCentralWidget();

		this.layout = new BorderLayout();
		this.setLayout(layout);

		add(this.centralWidget, BorderLayout.CENTER);
		}

	private void control()
		{
		}

	private void appearance()
		{
		this.centralWidget.setSize(this.getSize());
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	private JCentralWidget centralWidget;
	private static JDice instance = null;
	private BorderLayout layout;

	}
