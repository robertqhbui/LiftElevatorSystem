package com.robertbui.liftelevatorsystem.common.userinterface;

import com.robertbui.liftelevatorsystem.common.types.LiftMessageType;

public class Button
{
	boolean mStatus;
	LiftMessageType mType;
	ControlPanel mControlPanel;
	String	mData;
	
	public Button(ControlPanel parent, LiftMessageType messageType, String data)
	{
		mStatus = false;
		mType = messageType;
		mData = data;
	}

	
	
	public String getData()
	{
		return mData;
	}


	
	public void setData(String data)
	{
		this.mData = data;
	}


	public boolean getStatus()
	{
		return mStatus;
	}

	
	public void setStatus(boolean mStatus)
	{
		this.mStatus = mStatus;
	}

	
	public LiftMessageType getType()
	{
		return mType;
	}

	
	public void setType(LiftMessageType type)
	{
		this.mType = type;
	}
	
	
	public void press()
	{
		if (!this.getStatus())
		{
			mControlPanel.onButtonPressed(this);
			this.setStatus(true);
		}
	}
}
