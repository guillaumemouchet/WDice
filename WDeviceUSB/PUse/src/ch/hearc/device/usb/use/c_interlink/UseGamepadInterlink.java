
package ch.hearc.device.usb.use.c_interlink;

import ch.hearc.device.usb.api.generic.listener.ComponentEvent;
import ch.hearc.device.usb.api.generic.listener.GamepadListener;

/**
 * model InterLink Elite
 */
public class UseGamepadInterlink
	{
	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void main(String[] args)
		{
		main();
		}

	public static void main()
		{
		GamepadInterlink gamepadInterlink = GamepadInterlink.getInstance();

		// use listener
			{
			GamepadListener gamepadListener = createGamepadListener();

			System.out.println("[UseGamepadInterlink] : add listener");

			gamepadInterlink.addGamepadListener(gamepadListener);

			long duratiomMS = 1000 * 120;
			sleep(duratiomMS);

			System.out.println("[UseGamepadInterlink] : removed listener");

			gamepadInterlink.removeGamepadListener(gamepadListener);
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static GamepadListener createGamepadListener()
		{
		return new GamepadListener()
			{

			@Override
			public void connected(Object source)
				{
				GamepadInterlink gamepadInterlink = (GamepadInterlink)source;
				System.out.println("[UseGamepadInterlink] :" + gamepadInterlink + " : Connected");
				}

			@Override
			public void componentPerformed(ComponentEvent componentEvent)
				{
				ComponentInterlink componentInterlink = (ComponentInterlink)componentEvent.getSource();
				float value = componentEvent.getValue();

				System.out.println("[UseGamepadInterlink] :" + componentInterlink + " : " + value);
				}
			};
		}

	/*------------------------------*\
	|*			  Tools				*|
	\*------------------------------*/

	private static void sleep(long delayMs)
		{
		try
			{
			System.out.println("[UseGamepadInterlink] : sleep " + delayMs + " [ms]");
			Thread.sleep(delayMs);
			}
		catch (InterruptedException e)
			{
			e.printStackTrace();
			}
		}

	}
