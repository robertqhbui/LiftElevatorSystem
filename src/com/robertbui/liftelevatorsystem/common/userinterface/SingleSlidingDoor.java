
package com.robertbui.liftelevatorsystem.common.userinterface;

import com.robertbui.liftelevatorsystem.common.types.DoorOperationState;

public class SingleSlidingDoor extends Door
{

	public SingleSlidingDoor()
	{
		super();

	}

	public SingleSlidingDoor(DoorOperationState mState)
	{
		super(mState);
	}

	@Override
	protected boolean open()
	{
		System.out.println("Sliding door open.");
		this.mState = DoorOperationState.DOOR_OPENED;
		return (true);
	}

	@Override
	protected boolean close()
	{
		System.out.println("Sliding door close.");
		this.mState = DoorOperationState.DOOR_CLOSED;
		return (true);

	}

}
