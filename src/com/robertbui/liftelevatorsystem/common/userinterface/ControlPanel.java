
package com.robertbui.liftelevatorsystem.common.userinterface;

import java.util.HashMap;

import com.robertbui.liftelevatorsystem.common.types.LiftMessageType;

public class ControlPanel
{
	HashMap<String, Button> mButtonList;
	ControlPanelConnectorInterface mConnectorInterface;

	public ControlPanel(ControlPanelConnectorInterface connectorInterface)
	{
		mButtonList = new HashMap<String, Button>();
		this.mConnectorInterface = connectorInterface;
	}
	
	public void addButton(LiftMessageType messageType, String data)
	{
		Button button = new Button(this, messageType, data);
		mButtonList.put(data, button);
	}

	public void onButtonPressed(Button button)
	{
		LiftMessageType messageType = button.getType();
		String			data = button.getData();
		mConnectorInterface.onRequestMessage(messageType, data);
	}
	public void clearButtonStatus(String buttonName)
	{
		Button button = mButtonList.get(buttonName);
		button.setStatus(false);
	}
}
