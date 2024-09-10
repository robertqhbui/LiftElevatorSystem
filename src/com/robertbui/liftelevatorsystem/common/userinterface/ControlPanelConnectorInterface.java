
package com.robertbui.liftelevatorsystem.common.userinterface;

import com.robertbui.liftelevatorsystem.common.types.LiftMessageType;

public interface  ControlPanelConnectorInterface
{
	public void onRequestMessage(LiftMessageType messageType, String data);
}
