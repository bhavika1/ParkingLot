package com.classklap.Parking;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Collectors;

//Driver class
//Assuming the input will be the same as in the question
//We can write stop to prevent the program from accepting any more inputs
public class App 
{
	static ParkingLot tickets;
	static Slot s;
    public static void main( String[] args )
    {
    	try {
    		Scanner sc = new Scanner(System.in);
        	sc.next();
        	int slotNumber = sc.nextInt();
        	sc.hasNextLine();
        	createParkinglot(slotNumber);
            while(true) {
            	String st = sc.next();
            	switch(st) {
            		case "park":
            			String reg = sc.next();
            			String color = sc.next();
            			String vehicle = sc.next();
            			tickets.park(reg,color,vehicle);
            			break;
            		case "leave":
            			int leave = sc.nextInt();
                        leaveCar(leave);
            			break;
            		case "status":
            			tickets.status();
            			break;
            		case "registration_numbers_for_cars_with_colour":
                        String col = sc.next();
            			findRegNumFromColor(col);
            			break;
            		case "slot_numbers_for_cars_with_colour":
                        String cols = sc.next();
            			findSlotFromColor(cols);
            			break;
            		case "slot_number_for_registration_number":
                        String regn = sc.next();
            			findSlotFromRegNum(regn);
            			break;
            		case "stop":
            	        return;
            		default:
                		System.out.println("Please enter the input in correct format.");
            	}
            }
    	}catch(InputMismatchException e){
    		System.out.println("Please enter the input in correct format.");
    	}
    	
    }
    
    private static void findRegNumFromColor(String string) {
    	
    	 ArrayList<String> ar =   tickets.findRegistrationNumber("White");
    	 
    	 String res = String.join(",",ar);
    	 System.out.println(res);

	}

	private static void findSlotFromRegNum(String string) {
    	
    	 int res =  tickets.findSlotNumberGivenRegistrationNumber(string);
    	 if(res == 0) {
    		 System.out.println("Not Found");
    	 }else {
        	 System.out.println(res);
    	 }
	}

	private static void findSlotFromColor(String string) {
		
        ArrayList<Integer> ar =  tickets.findSlotNumberGivenColor(string);
        
        String joinedList = ar.stream().map(String::valueOf).collect(Collectors.joining(","));
        System.out.println(joinedList);
       
	
	}

	private static void leaveCar(int n) {
		
    	int sl = tickets.leaveSlotTicket(n);
    	
    	if(sl == 1) {
        	System.out.println("Slot number "+n+" is free");
    	}else {
    		System.out.println("Cannot delete slot "+n);
    	}
	}

	static void createParkinglot(int slotNumber) {
    	s = new Slot(slotNumber);
    	tickets = new ParkingLot(slotNumber,s);
    	System.out.println("Created a parking lot with "+slotNumber+" slots");
    }
    
    
}
