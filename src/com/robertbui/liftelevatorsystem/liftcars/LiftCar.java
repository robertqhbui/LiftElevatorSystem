
package com.robertbui.liftelevatorsystem.liftcars;

import com.robertbui.liftelevatorsystem.common.userinterface.Door;
import com.robertbui.liftelevatorsystem.common.types.LiftMessageType;
import com.robertbui.liftelevatorsystem.common.userinterface.ControlPanel;
import com.robertbui.liftelevatorsystem.common.userinterface.ControlPanelConnectorInterface;
import com.robertbui.liftelevatorsystem.liftcars.states.OperationState;

public abstract class LiftCar
{

	protected OperationState	mState;
	protected Door				mDoor;
	protected ControlPanel 		mControlPanel;
	protected LiftToControlPanelConnector mControlConnector;

	public void openOpenDoorRequest()
	{
		this.mDoor.onOpenRequest();
		this.mControlConnector = new LiftToControlPanelConnector();
		this.mControlPanel = new ControlPanel(this.mControlConnector);
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
	
	public abstract void setup();
	
	class LiftToControlPanelConnector implements ControlPanelConnectorInterface
	{
		public void onRequestMessage(LiftMessageType messageType, String data)
		{
			System.out.println("LiftCar()::LiftToControlPanelConnector::onRequestMessage() - called with data " + data);
			switch (messageType)
			{
				case REQUEST_LIFT_MESSAGE_TYPE:
				{
					break;
				}
				case REQUEST_FLOOR_MESSAGE_TYPE:
				{

					break;
				}
				case REQUEST_OPEN_DOOR_MESSAGE_TYPE:
				{
					openOpenDoorRequest();
					break;
				}
				case REQUEST_CLOSE_DOOR_MESSAGE_TYPE:
				{
					onCloseDoorRequest();
					break;
				}
				case REQUEST_ASSISTANCE_MESSAGE_TYPE:
				{
					onAssistanceRequest(data);
					break;
				}
				default:
				{
					//DO nothing
				}
			}
			mControlPanel.clearButtonStatus(data);
		}
		
	}

}
