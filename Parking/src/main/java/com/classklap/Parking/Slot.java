package com.classklap.Parking;

public class Slot {
	
	int slotSize;
	Slots slot[];
	
	public Slot(int size) {
		
		slotSize = size;
		slot = new Slots[slotSize+1];
		
		for(int i=1;i<=slotSize;i++) {
			slot[i] = new Slots();
			slot[i].num = i;
			slot[i].isAvailable = true;
			if(i < 4) {
				slot[i].vehicleType = 1;
			}else {
				slot[i].vehicleType = 0;
			}
		}
	}
	
	public int findNextSlot(String vehicle) {
		
		for(int i=1;i<=slotSize;i++) {
			if(slot[i].isAvailable == true) {
				if(vehicle.equals("LW") && slot[i].vehicleType == 1) {
					slot[i].isAvailable = false;
					return i;
				}else if(vehicle.equals("HW") && slot[i].vehicleType == 0){
					slot[i].isAvailable = false;
					return i;
				}
				
			}
		}
		return 0;
	}
	
	public int leaveSlot(int slotNumber) {
		
		if(slotNumber <= slotSize && slot[slotNumber].isAvailable == false) {
			slot[slotNumber].isAvailable = true;
			return 1;
		}else {
				return 0;
		}
	}
	
}
