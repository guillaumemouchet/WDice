
package ch.hearc.dice.moo.implementation.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ch.hearc.tools.Chrono;

public class TestChrono
	{

	private int delta = 20; // Le temps ne peut pas être exactement le même, 20 semble être un temps acceptable comme marge d'erreur
	 /*-----------------------------------------------------------------*\
	 |*							Methodes Public							*|
	 \*-----------------------------------------------------------------*/

	/*
	 * Test uniquement le fonctionnement du temps final
	 */
	@Test
	public void testEnd()
		{
		long time = 1000;
		Chrono chrono = new Chrono();
		chrono.start();
		sleepMS(time);
		long totalValue = chrono.stop();
		//Assertions.assertEquals(time,totalValue);

		assertTrue(totalValue < (time + delta) && totalValue > (time - delta));
		}

	/*
	 * Test le bon fonctionnement du temps intermédiaire et du temps final
	 */
	@Test
	public void testInterEnd()
		{
		long time = 1000;
		Chrono chrono = new Chrono();
		chrono.start();

		sleepMS(time);

		// Temps Intermediare
			{
		long interValue = chrono.getTimeMS();

		//Assertions.assertEquals(time,interValue);
		assertTrue(interValue < (time + delta) && interValue > (time - delta));
			}

		sleepMS(time);

		// Temps Final
			{
		long totalValue = chrono.stop();

		//Assertions.assertEquals(2*time,interValue);
		assertTrue(totalValue < (2*time + delta) && totalValue > (2*time - delta));
			}

		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void sleepMS(long durationMS)
		{
		try
			{
			Thread.sleep(durationMS);
			}
		catch (InterruptedException e)
			{
			e.printStackTrace();
			}
		}

	}
