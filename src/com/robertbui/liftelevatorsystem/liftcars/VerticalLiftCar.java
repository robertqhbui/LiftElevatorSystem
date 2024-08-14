
package com.robertbui.liftelevatorsystem.liftcars;

public class VerticalLiftCar extends LiftCar
{

	@Override
	public void openDoor() throws Exception
	{
		if (!this.mDoor.onOpenRequest())
		{
			throw new Exception("Warning. Unable to open door.");
		}

	}

	@Override
	public boolean closeDoor()
	{
		return (this.mDoor.onCloseRequest());

	}

	@Override
	public boolean stop()
	{
		System.out.println("Verticle Lift Car stopped.");
		return true;

	}

	@Override
	public void move()
	{
		System.out.println("Verticle Lift Car moving.");

	}

}
