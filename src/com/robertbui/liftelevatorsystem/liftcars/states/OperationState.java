
package com.robertbui.liftelevatorsystem.liftcars.states;

import com.robertbui.liftelevatorsystem.liftcars.LiftCar;

public abstract class OperationState
{

	protected LiftCar mLiftCar;

	public OperationState(LiftCar mLiftCar)
	{
		this.mLiftCar = mLiftCar;
	}

	public abstract void openDoor();

	public abstract boolean closeDoor();

	public abstract void move();

	public abstract boolean stop();

}
