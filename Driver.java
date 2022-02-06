package com.construction.driver;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Driver {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("enter the total no of floors in the building");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		ArrayList<Integer> floorSize = new ArrayList<>();
		
		for(int i = 0; i<a; i++) {
			int j = i+1;
			System.out.println("enter the floor size given on day : "+j);
			//dataSet.put(sc.nextInt(), sc.nextInt());
			floorSize.add(sc.nextInt());
		}
		
		System.out.println("The order of construction is as follows");
		floorPlan(a,floorSize);
		
		

	}

	private static void floorPlan(int noOfDays, ArrayList<Integer> floorSize) {
		// TODO Auto-generated method stub
		
		Stack<Integer> sk = new Stack<Integer>();
		
		
		for(int i =0; i<floorSize.size(); i++) {
			
			if(floorSize.get(i) !=null ) {
				if(floorSize.get(i) == noOfDays)  {
					int j = i+1;
					System.out.println("Day: "+j);
					
					if(sk.size() == 0) {
						System.out.println(floorSize.get(i));
					}
					else {
						System.out.println(floorSize.get(i));
						int ref1 = floorSize.get(i);
						int ref2 = sk.lastElement();
						if(ref1-ref2 == 1) {
							for (int v=0; v<=sk.size();v++) {
								System.out.println(sk.pop());
								if(sk.size()!=0) {
								int ref3 = sk.lastElement();
								int ref4 = sk.lastElement()-1;
								if(ref3 - ref4 == 1) {
									v++;
								}
								}
								
						}
						
						}
					}
					
				}
				else if(floorSize.get(i) != noOfDays){
					int j = i+1;
					System.out.println("Day: "+j);
					sk.push(floorSize.get(i));
					//System.out.println("size : "+sk.size());
					if(j == noOfDays) {
						for (int v=0; v<=sk.size()+1; v++) {
							System.out.println(sk.pop());
						}
					}
					else {
						System.out.println();
					}
				}
			}
			
		}
		
	}

}
