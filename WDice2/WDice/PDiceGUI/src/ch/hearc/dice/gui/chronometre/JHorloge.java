
package ch.hearc.dice.gui.chronometre;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import ch.hearc.c_gui.tools.G2D_I;

public class JHorloge implements G2D_I
	{

	public JHorloge()
		{
		//inputs
			{
			this.rayon = 20;
			this.nbMarqeurs = 60;
			}

		//Tools animation
			{
			this.alphaAnimation = 0;
			}

		formes();
		}
	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void setAngle(int s)
		{
		this.alphaAnimation = 2 * Math.PI * s / 60;
		}

	@Override
	public void draw(Graphics2D g2d, int w, int h)
		{
		this.rayon = Math.min(w, h) * 3 / 4 / 2;
		g2d.translate(w / 2, h / 2);
		drawHorloge(g2d);
		drawAiguille(g2d);
		g2d.translate(-w / 2, -h / 2);
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void formes()
		{
		this.aiguille = new Line2D.Double(0, 0, 0, -80);
		this.bout = new Ellipse2D.Double(-10, -100, 20, 20);
		this.petitMarqeur = new Line2D.Double(0, 0, 10, 0);
		this.grandMarqueur = new Line2D.Double(0, 0, 20, 0);

		}

	private void drawAiguille(Graphics2D g2d)
		{
		g2d.rotate(this.alphaAnimation);
		g2d.setColor(Color.RED);
		g2d.draw(aiguille);
		g2d.draw(bout);
		g2d.fillOval(-10, -100, 20, 20);
		g2d.rotate(-this.alphaAnimation);
		}

	private void drawHorloge(Graphics2D g2d)
		{
		for(int i = 0; i < this.nbMarqeurs; i++)
			{
			g2d.translate(this.rayon, 0);
			if (i % 5 == 0)
				{
				g2d.draw(grandMarqueur);
				}
			else
				{
				g2d.draw(petitMarqeur);
				}
			g2d.translate(-this.rayon, 0);

			g2d.rotate((Math.PI * 2) / nbMarqeurs);
			}
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//Tools
	private int rayon;
	private int nbMarqeurs;
	private Line2D.Double petitMarqeur;
	private Line2D.Double grandMarqueur;
	private Line2D.Double aiguille;
	private Ellipse2D.Double bout;
	private double alphaAnimation;

	}
