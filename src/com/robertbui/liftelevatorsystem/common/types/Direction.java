
package com.robertbui.liftelevatorsystem.common.types;

public enum Direction
{

	DOWN_DIRECTION(-1), NEUTRAL_DIRECTION(0), UP_DIRECTION(1);

	private int value;

	private Direction(int value)
	{
		this.value = value;
	}

	public int getValue()
	{
		return value;
	}

}
