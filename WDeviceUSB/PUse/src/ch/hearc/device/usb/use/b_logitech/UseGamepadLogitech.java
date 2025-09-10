
package ch.hearc.device.usb.use.b_logitech;

import ch.hearc.device.usb.api.generic.listener.ComponentEvent;
import ch.hearc.device.usb.api.generic.listener.GamepadListener;

/**
 * model : Logitech Cordless RumblePad 2
 */
public class UseGamepadLogitech
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
		GamepadLogitech gamepadWireless = GamepadLogitech.getInstance();

		// use listener
			{
			GamepadListener gamepadListener = createGamepadListener();

			System.out.println("[UseGamepadWireless] : add listener");

			gamepadWireless.addGamepadListener(gamepadListener);

			long duratiomMS = 1000 * 120;
			sleep(duratiomMS);

			System.out.println("[UseGamepadWireless] : removed listener");

			gamepadWireless.removeGamepadListener(gamepadListener);
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
				GamepadLogitech gamepadWireless = (GamepadLogitech)source;
				System.out.println("[UseGamepadWireless] :" + gamepadWireless + " : Connected");
				}

			@Override
			public void componentPerformed(ComponentEvent componentEvent)
				{
				ComponentLogitech componentWireless = (ComponentLogitech)componentEvent.getSource();
				float value = componentEvent.getValue();

				System.out.println("[UseGamepadWireless] :" + componentWireless + " : " + value);
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
			System.out.println("[UseGamepadWireless] : sleep " + delayMs + " [ms]");
			Thread.sleep(delayMs);
			}
		catch (InterruptedException e)
			{
			e.printStackTrace();
			}
		}

	}
