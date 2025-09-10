
package ch.hearc.dice.gui.about;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;

public class JLogoHeArc extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public JLogoHeArc()
		{
		this.hearcLogo = new G2DHeArc();
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
	@Override
	protected void paintComponent(Graphics g)
		{
		super.paintComponent(g);

		Graphics2D g2D = (Graphics2D)g;

		AffineTransform transform = g2D.getTransform(); //sauvegarde
		Color color = g2D.getColor(); //sauvegarde
		Font font = g2D.getFont(); //sauvegarde

		this.hearcLogo.draw(g2D, this.getSize().width, this.getSize().height);

		g2D.setFont(font); //restore
		g2D.setColor(color); //restore
		g2D.setTransform(transform); //restore
		}

	private void geometry()
		{

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

	//Tools
	private G2DHeArc hearcLogo;

	}
