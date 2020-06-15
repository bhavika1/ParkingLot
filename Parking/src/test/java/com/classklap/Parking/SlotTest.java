package com.classklap.Parking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SlotTest {
	static Slot s;
	
	@BeforeAll
	static void init() {
		s = new Slot(6);
		Slots sl[] = new Slots[7];
		sl[1] = new Slots();
		sl[1].isAvailable = true;
		sl[1].vehicleType = 1;
		sl[2] = new Slots();
		sl[2].isAvailable = false;
		sl[1].vehicleType = 1;
		sl[3] = new Slots();
		sl[3].isAvailable = false;
		sl[1].vehicleType = 0;
		sl[4] = new Slots();
		sl[4].isAvailable = false;
		sl[1].vehicleType = 1;
		sl[5] = new Slots();
		sl[5].isAvailable = true;
		sl[1].vehicleType = 0;
		sl[6] = new Slots();
		sl[6].isAvailable = true;
		sl[1].vehicleType = 0;
		s.slot = sl;

	}
	
	//Returns the least slot from the beginning
	@Test
	void testFindNextSlot() {
		
		int ans = s.findNextSlot("HW");
		
		assertEquals(1, ans);
	}

	@Test
	void testLeaveSlot() {
		//1 is returned the slot was deleted.0 is returned the slot was not deleted
		int n = s.leaveSlot(2);
		assertEquals(1, n);
	}

}
