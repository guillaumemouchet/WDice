
package ch.hearc.dice.gui.tabExperience;

import javax.swing.JSplitPane;

import ch.hearc.dice.gui.graphes.JGraphes;

public class JCustomSplitPanel extends JSplitPane
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JCustomSplitPanel()
		{
		super(JSplitPane.HORIZONTAL_SPLIT);

		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		this.leftPanel = new JLeftPanel();
		this.graphes = new JGraphes();

		setRightComponent(graphes);
		setLeftComponent(leftPanel);

		}

	private void control()
		{

		}

	private void appearance()
		{
		this.setDividerSize(0);
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//Tools
	private JLeftPanel leftPanel;
	private JGraphes graphes;

	}
