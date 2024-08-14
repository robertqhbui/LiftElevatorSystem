
package com.robertbui.liftelevatorsystem.liftcars.states;

import com.robertbui.liftelevatorsystem.liftcars.LiftCar;

public class OperationIdleState extends OperationState
{

	public OperationIdleState(LiftCar mLiftCar)
	{
		super(mLiftCar);
	}

	@Override
	public void openDoor()
	{
		// Lift already stationary. It is safe to open the door.
		try
		{
			this.mLiftCar.openDoor();
		}
		catch (Exception e)
		{
			this.mLiftCar.onAssistanceRequest("OperationIdleState()=>Unable to open door.");
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
		return true;

	}

}
