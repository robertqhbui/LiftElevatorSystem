
package com.robertbui.liftelevatorsystem.liftcars.states;

import com.robertbui.liftelevatorsystem.liftcars.LiftCar;

public class OperationStopState extends OperationState
{

	public OperationStopState(LiftCar mLiftCar)
	{
		super(mLiftCar);
	}

	@Override
	public void openDoor()
	{

		try
		{
			this.mLiftCar.openDoor();
		}
		catch (Exception e)
		{
			this.mLiftCar.onAssistanceRequest("OperationStopState()=>Unable to open door.");
		}
	}

	@Override
	public boolean closeDoor()
	{
		return this.mLiftCar.closeDoor();
	}

	@Override
	public void move()
	{
		if (this.closeDoor())
		{
			this.mLiftCar.move();
		}
	}

	@Override
	public boolean stop()
	{
		// NOOP. Already stopped. Nothing to do.
		return true;

	}

}
