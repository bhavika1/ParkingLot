package com.classklap.Parking;

import java.util.ArrayList;
import java.util.Arrays;

public class ParkingLot {
	
	int totalSlot;
	Tickets ticket[];
	Slot slots;
	
	public ParkingLot(int slotNumber,Slot s) {
		
		totalSlot = slotNumber;
		ticket = new Tickets[slotNumber+1];
		slots = s;
		
		for(int i=0;i<=totalSlot;i++) {
			ticket[i] = new Tickets();
		}
	}
	
	public int leaveSlotTicket(int n) {

		int sl = slots.leaveSlot(n);
		
		if(sl == 1) {
			ticket[n].registrationNumber = "";
			ticket[n].color = "";
			ticket[n].slotNumber = 0;
			return 1;
		}
		return 0;
	}
	
	public void park(String registrationNumber,String color,String vehicle) {
		
		int n = slots.findNextSlot(vehicle);
		
		if(n == 0) {
			System.out.println("Sorry, parking lot is full");
		}else {
			ticket[n].registrationNumber = registrationNumber;
			ticket[n].color = color;
			ticket[n].slotNumber = n;
			System.out.println("Allocated slot number: "+n);
		}
	}

	public void status() {
		
		System.out.println("Slot No."+"\t"+"Registration No"+"\t"+"Color");
		
		for(int i=1;i<=totalSlot;i++) {
			if(ticket[i].slotNumber != 0) {
				System.out.println(ticket[i].slotNumber+"\t\t"+ticket[i].registrationNumber+"\t"+ticket[i].color);
			}
		}
		
	}
	
	public ArrayList<String> findRegistrationNumber(String color){
		
		ArrayList<String> ar = new ArrayList<String>();
		
		for(int i=1;i<=totalSlot;i++) {
			if(null != ticket[i].color && ticket[i].color.equalsIgnoreCase(color)) {
				ar.add(ticket[i].registrationNumber);
			}
		}
		
		return ar;
	}

	public ArrayList<Integer> findSlotNumberGivenColor(String color){
			
			ArrayList<Integer> ar = new ArrayList<Integer>();
			
			for(int i=1;i<=totalSlot;i++) {
				if(null != ticket[i].color && ticket[i].color.equalsIgnoreCase(color)) {
					ar.add(ticket[i].slotNumber);
				}
			}
			
			return ar;
		}
	public int findSlotNumberGivenRegistrationNumber(String registrationNumber){
				
		for(int i=1;i<=totalSlot;i++) {
			if(null != ticket[i].registrationNumber && ticket[i].registrationNumber.equalsIgnoreCase(registrationNumber)) {
				return ticket[i].slotNumber;
			}
		}
		
		return 0;
	}
	
}
