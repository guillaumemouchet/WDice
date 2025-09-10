
package ch.hearc.dice.gui.about;

import java.awt.Graphics2D;
import java.awt.Image;

import ch.hearc.c_gui.tools.G2D_I;
import ch.hearc.dice.gui.images.MagasinImages;

public class G2DHeArc implements G2D_I
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public G2DHeArc()
		{
		this.heArcLogo = MagasinImages.HEARC.getImage();
		}
	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	@Override
	public void draw(Graphics2D g2d, int w, int h)
		{
		g2d.scale(0.5, 1);
		g2d.drawImage(this.heArcLogo, 0, 0, null);
		g2d.scale(2, 1);
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
	private Image heArcLogo;


	}
