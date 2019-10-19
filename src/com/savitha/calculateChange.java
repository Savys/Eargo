package com.savitha;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class calculateChange {
	final static int	QUARTER	= 25;
	final static int	DIME		= 10;
	final static int	NICKEL	= 5;
	final static int	PENNIES	= 1;

	public static void main(String[] args) {
		calculateChange change = new calculateChange();
		System.out.println("Enter the amount:");
		Scanner in = new Scanner(System.in);
		int input = in.nextInt();
		List<Denomination> output=change.calculateDenomination(input);
		for(Denomination d : output) {
			System.out.print(d.toString() +" ");
		}
		in.close();
	}

	private  List<Denomination>  calculateDenomination(int input) {
		List<Denomination> denomiationList = new ArrayList<Denomination>();
		if (input == 0 || input < 0) {
			throw new IllegalArgumentException("Invalid input");
		} 
		int result = input / QUARTER;
		int remainder = input % QUARTER;
		if(result > 0) {
			Denomination q = new Denomination("QUARTER",input / QUARTER);
			denomiationList.add(q);
		}
		if (remainder >= DIME) {
			result = remainder / DIME;
			remainder = input % DIME;
			if(result > 0) {
				Denomination d = new Denomination("DIME",result);
				denomiationList.add(d);
			}
		} 
		if (remainder >= NICKEL) {
			result = remainder / NICKEL;
			remainder = remainder % NICKEL;
			if(result > 0) {
				Denomination d = new Denomination("NICKEL",result);
				denomiationList.add(d);
			}
		}
		if (remainder >= PENNIES) {
			Denomination d = new Denomination("PENNIES",remainder);
			denomiationList.add(d);
		}
		return denomiationList;
	}

	public class Denomination {
		String currency;
		int count;
		
		Denomination(String currency, int count) {
			this.currency = currency;
			this.count = count;
		}
		
		@Override
		public String toString() {
			return currency + "(" + count + ")";
		}
	}

}
