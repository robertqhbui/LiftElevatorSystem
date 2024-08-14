
package com.robertbui.liftelevatorsystem.common.userinterface;

import com.robertbui.liftelevatorsystem.common.types.DoorOperationState;

public abstract class Door
{

	protected DoorOperationState mState;

	public Door()
	{
		this.mState = DoorOperationState.DOOR_CLOSED;
	}

	public Door(DoorOperationState mState)
	{
		this.mState = mState;
	}

	public DoorOperationState getOperateState()
	{
		return mState;
	}

	public boolean onOpenRequest()
	{
		if (this.mState != DoorOperationState.DOOR_OPENED)
		{
			return (this.open());
		}
		return (true);
	}

	public boolean onCloseRequest()
	{
		if (this.mState != DoorOperationState.DOOR_CLOSED)
		{
			return (this.close());

		}
		// Already closed.
		return (true);
	}

	protected abstract boolean open();

	protected abstract boolean close();

}
