
package ch.hearc.dice.gui;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JTabbedPane;

import ch.hearc.dice.gui.about.JAbout;
import ch.hearc.dice.gui.tabExperience.JCustomSplitPanel;

public class JCentralWidget extends Box
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JCentralWidget()
		{

		super(BoxLayout.Y_AXIS);
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
		this.tabbedPane = new JTabbedPane();
		this.splitPanel = new JCustomSplitPanel();
		this.about = new JAbout();

		this.tabbedPane.addTab("Experience", splitPanel);
		this.tabbedPane.addTab("About", about);
		add(this.tabbedPane);
		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{

		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs

	// Tools
	private JTabbedPane tabbedPane;
	private JCustomSplitPanel splitPanel;
	private JAbout about;

	}
