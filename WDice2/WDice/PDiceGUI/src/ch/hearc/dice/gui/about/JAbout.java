
package ch.hearc.dice.gui.about;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ch.hearc.c_gui.tools.decorateur.jimage.JImage;
import ch.hearc.c_gui.tools.decorateur.jimage.TypeRendering;
import ch.hearc.dice.gui.images.MagasinImages;

public class JAbout extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JAbout()
		{
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
		this.label = new JLabel("End of semester Java project made by Benjamin Mouchet and Guillaume Mouchet");
		this.logo = new JImage(MagasinImages.HEARC.getImage(), TypeRendering.KEEP_RATIO);
		this.references = new JReference();

		BorderLayout borderLayout = new BorderLayout();
		setLayout(borderLayout);
		add(this.label, BorderLayout.NORTH);
		add(this.logo, BorderLayout.CENTER);
		add(this.references, BorderLayout.SOUTH);
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
	private JLabel label;
	private JImage logo;
	private JReference references;

	}
