
package ch.hearc.dice.gui.images;

import javax.swing.ImageIcon;

import ch.hearc.c_gui.tools.image.ImageLoader;

/**
* <pre>
* Les images doivent se trouver dans un jar, et le jar dans le classapth!
* Le jar doit contenir le folder ressources/cours.
* A l'interieur du folder cours doit se trouver les images aux formats (jpg, voir mieux png pour la transparance)
* </pre>
*/
public class MagasinImages
	{

	private static final String PATH_IN_JAR = "ressources/";

	/*------------------------------------------------------------------*\
	|*		 Version Synchrone (bloquant)								*|
	\*------------------------------------------------------------------*/

	public static final ImageIcon HEARC = ImageLoader.loadSynchroneJar(PATH_IN_JAR + "logoTransHeArc.png");
	public static final ImageIcon PLAY = ImageLoader.loadSynchroneJar(PATH_IN_JAR + "play.png");
	public static final ImageIcon PAUSE = ImageLoader.loadSynchroneJar(PATH_IN_JAR + "pause.png");
	public static final ImageIcon STOP = ImageLoader.loadSynchroneJar(PATH_IN_JAR + "not-disturb.png");
	public static final ImageIcon DICES = ImageLoader.loadSynchroneJar(PATH_IN_JAR + "dices.png");

	/*------------------------------------------------------------------*\
	|*		Version Assynchrone	(non bloquant)							*|
	\*------------------------------------------------------------------*/

	//public static final ImageIcon WARNING = ImageLoader.loadAsynchroneJar(PATH_IN_JAR+"warning.png");
	//public static final ImageIcon JAVA = ImageLoader.loadAsynchroneJar(PATH_IN_JAR+"java.png");
	//public static final ImageIcon LINUX = ImageLoader.loadAsynchroneJar(PATH_IN_JAR+"linux.png");
	//public static final ImageIcon CERVIN = ImageLoader.loadAsynchroneJar(PATH_IN_JAR+"cervin.png");

	}
