
package ch.hearc.device.usb.use.a_xeox;

import ch.hearc.device.usb.api.generic.listener.ComponentEvent;
import ch.hearc.device.usb.api.generic.listener.GamepadListener;

public class UseGamepadXeox
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
		GamepadXeox gamepadXeox = GamepadXeox.getInstance();

		// use listener
			{
			GamepadListener gamepadListener = createGamepadListener();

			System.out.println("[UseGamepadXeox] : add listener");

			gamepadXeox.addGamepadListener(gamepadListener);

			long duratiomMS = 1000 * 120;
			sleep(duratiomMS);

			System.out.println("[UseGamepadXeox] : removed listener");

			gamepadXeox.removeGamepadListener(gamepadListener);
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
				GamepadXeox gamepadXeox = (GamepadXeox)source;
				System.out.println("[UseGamepadXeox] : " + gamepadXeox + " : Connected");
				}

			@Override
			public void componentPerformed(ComponentEvent componentEvent)
				{
				ComponentXeox componentXeox = (ComponentXeox)componentEvent.getSource();
				float value = componentEvent.getValue();

				System.out.println("[UseGamepadXeox] : " + componentXeox + " : " + value);
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
			System.out.println("[UseGamepadXeox] : sleep " + delayMs + " [ms]");
			Thread.sleep(delayMs);
			}
		catch (InterruptedException e)
			{
			e.printStackTrace();
			}
		}

	}
