
package com.robertbui.liftelevatorsystem.common.userinterface;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.robertbui.liftelevatorsystem.common.types.DoorOperationState;

class SlidingDoorUnitTest
{

	@Test
	void testDoor()
	{
		assertNotNull(new SingleSlidingDoor());
	}

	@Test
	void testDoorClosedOperationState()
	{
		Door door = new SingleSlidingDoor(DoorOperationState.DOOR_CLOSED);
		assertTrue(door.getOperateState() == DoorOperationState.DOOR_CLOSED);
	}

	@Test
	void testDoorOpenedOperationState()
	{
		Door door = new SingleSlidingDoor(DoorOperationState.DOOR_OPENED);
		assertTrue(door.getOperateState() == DoorOperationState.DOOR_OPENED);
	}

	@Test
	void testOnOpenRequest()
	{
		Door door = new SingleSlidingDoor();
		door.onOpenRequest();
		assertTrue(door.getOperateState() == DoorOperationState.DOOR_OPENED);
	}

	@Test
	void testOnCloseRequest()
	{
		Door door = new SingleSlidingDoor();
		door.onCloseRequest();
		assertTrue(door.getOperateState() == DoorOperationState.DOOR_CLOSED);
	}

	@Test
	void testOpen()
	{
		Door door = new SingleSlidingDoor();
		door.open();
		assertTrue(door.getOperateState() == DoorOperationState.DOOR_OPENED);
	}

	@Test
	void testClose()
	{
		Door door = new SingleSlidingDoor();
		door.close();
		assertTrue(door.getOperateState() == DoorOperationState.DOOR_CLOSED);
	}

	@Test
	void testCloseOpenedDoor()
	{
		Door door = new SingleSlidingDoor(DoorOperationState.DOOR_OPENED);
		assertTrue(door.getOperateState() == DoorOperationState.DOOR_OPENED);
		door.close();
		assertTrue(door.getOperateState() == DoorOperationState.DOOR_CLOSED);
	}

	@Test
	void testCloseClosedDoor()
	{
		Door door = new SingleSlidingDoor(DoorOperationState.DOOR_CLOSED);
		assertTrue(door.getOperateState() == DoorOperationState.DOOR_CLOSED);
		door.close();
		assertTrue(door.getOperateState() == DoorOperationState.DOOR_CLOSED);
	}

	@Test
	void testOpenClosedDoor()
	{
		Door door = new SingleSlidingDoor(DoorOperationState.DOOR_CLOSED);
		assertTrue(door.getOperateState() == DoorOperationState.DOOR_CLOSED);
		door.open();
		assertTrue(door.getOperateState() == DoorOperationState.DOOR_OPENED);
	}

	@Test
	void testOpenOpenedDoor()
	{
		Door door = new SingleSlidingDoor(DoorOperationState.DOOR_OPENED);
		assertTrue(door.getOperateState() == DoorOperationState.DOOR_OPENED);
		door.open();
		assertTrue(door.getOperateState() == DoorOperationState.DOOR_OPENED);
	}

}
