
package com.robertbui.liftelevatorsystem.liftcars.states;

import com.robertbui.liftelevatorsystem.liftcars.LiftCar;

public class OperationMovingState extends OperationState
{

	public OperationMovingState(LiftCar mLiftCar)
	{
		super(mLiftCar);
	}

	@Override
	public void openDoor()
	{
		this.mLiftCar.onAssistanceRequest("OperationMovingState()=>Unable to open door. Need to stop at a floor first.");

	}

	@Override
	public boolean closeDoor()
	{
		return this.mLiftCar.closeDoor();
	}

	@Override
	public void move()
	{
		// NOOP. Already moving. Nothing to do.

	}

	@Override
	public boolean stop()
	{
		return (this.mLiftCar.stop());

	}

}
