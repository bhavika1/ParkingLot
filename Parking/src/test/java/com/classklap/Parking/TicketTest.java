package com.classklap.Parking;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TicketTest {
	static Slot slot;
	static ParkingLot ticket;
	
	@BeforeAll
	static void init() {
		
		slot = new Slot(6);
		ticket = new ParkingLot(6,slot);
		
		App.createParkinglot(6);
		
		ticket.park("KA-01-HH-1234","White","HW");
		ticket.park("KA-01-HH-9999","White","LW");
		ticket.park("KA-01-BB-0001","Black","LW");
		ticket.park("KA-01-HH-7777","Red","HW");
		ticket.park("KA-01-HH-2701","Blue","HW");
		ticket.park("KA-01-HH-3141","Black","LW");

	}
	
	@Test
	void testLeaveSlotTicket() {
		//If 1 is returned the slot was deleted.If 0 is returned the slot was not deleted
		int n = ticket.leaveSlotTicket(8);
		assertEquals(0, n);
	}

	@Test
	void testFindRegistrationNumber() {

		ArrayList<String> ar = ticket.findRegistrationNumber("White");
		
		ArrayList<String> res = new ArrayList<String>();
		res.add("KA-01-HH-9999");
		res.add("KA-01-HH-1234");

		assertEquals(res,ar);
	}

	@Test
	void testFindSlotNumberGivenColor() {
		
		ArrayList<Integer> ar = ticket.findSlotNumberGivenColor("White");
		
		ArrayList<Integer> res = new ArrayList<Integer>();
		res.add(1);
		res.add(4);
		
		assertEquals(ar, res);
	}

	@Test
	void testFindSlotNumberGivenRegistrationNumber() {
		
		int ans = ticket.findSlotNumberGivenRegistrationNumber("KA-01-HH-3141");
		
		assertEquals(3, ans);
	}

}
