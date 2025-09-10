
package ch.hearc.device.usb.use.a_xeox;

import java.util.Arrays;
import java.util.Optional;

import ch.hearc.device.usb.api.generic.Component_I;
import ch.hearc.device.usb.api.generic.GamepadGeneric_A;

import net.java.games.input.Controller.Type;

/**
 * singleton
 */
public class GamepadXeox extends GamepadGeneric_A
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	private GamepadXeox()
		{
		super();
		}

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static synchronized GamepadXeox getInstance()
		{
		if (instance == null)
			{
			instance = new GamepadXeox();
			}

		return instance;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	@Override
	public String getName()
		{
		return CONTROLLER_XEOX_NAME;
		}

	@Override
	public Type getType()
		{
		return Type.GAMEPAD;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	@Override
	protected Optional<Component_I> toComponent(String id)
		{
		try
			{
			return Optional.of(ComponentXeox.lookupById(id));
			}
		catch (NullPointerException e)
			{
			String message = "[GamepadXeox] : panic error : code error : check name of Enum ComponentXeox ! Cause :  " + id + " not found in " + Arrays.toString(ComponentXeox.values());
			System.err.println(message);

			return Optional.empty();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static GamepadXeox instance = null;

	private static final String CONTROLLER_XEOX_NAME = "TODO"; // TODO
	}
