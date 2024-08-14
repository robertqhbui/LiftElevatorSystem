
package com.robertbui.liftelevatorsystem.liftcars;

import com.robertbui.liftelevatorsystem.common.userinterface.Door;
import com.robertbui.liftelevatorsystem.liftcars.states.OperationState;

public abstract class LiftCar
{

	protected OperationState	mState;
	protected Door				mDoor;

	public void openOpenDoorRequest()
	{
		this.mDoor.onOpenRequest();
	}

	public void onCloseDoorRequest()
	{
		this.mDoor.onCloseRequest();
	}

	public void onAssistanceRequest(String message)
	{
		System.out.println("Assistance request sent:" + message);
	}

	public void onArrival()
	{
		if (this.mState.stop())
		{
			this.mDoor.onOpenRequest();
		}
	}

	// TODO: Security risk. Need to protect these methods. Should accessible to
	// "friend" classes only.
	// TODO: May consider using inner class for the states.
	public abstract void openDoor() throws Exception;

	public abstract boolean closeDoor();

	public abstract boolean stop();

	public abstract void move();

}
