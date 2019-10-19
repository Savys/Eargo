package com.savitha;
import java.util.Scanner;

public class BuySellStock {

	public static void main(String[] args) {			
		//int[] price = { 3, 8, 8, 55, 38, 1, 7, 42, 54, 53 };
		System.out.println("Please enter the no of days of stock prices:");
		Scanner in = new Scanner(System.in); 
		int count = in.nextInt(); 
		System.out.println("Please enter stock prices:");
		int[] price = new int[count]; 
		Scanner numScanner = new Scanner(System.in);
		for (int i = 0; i < count; i++) { 
			if (numScanner.hasNextInt()) {
				price[i] = numScanner.nextInt(); 
			} 
			else {
				System.out.println("Not enough data entered"); 
				break; 
			} 
		}

		BuySellStock priceEngine = new BuySellStock();
		Stock output=priceEngine.findBestDay(price);
		System.out.println(output);
		in.close();
		numScanner.close();
	}

	private Stock findBestDay(int[] price) {
		int profit = 0;
		int maxProfit = 0;
		Stock stock = new Stock();
		for (int x = 0; x < price.length - 1; x++) {
			for (int y = x + 1; y < price.length; y++) {
				profit = price[y] - price[x];
				if (profit > maxProfit) {
					maxProfit = profit;
					stock.setBuyDay(x + 1);
					stock.setSellDay(y + 1);
					stock.setMaxprofit(maxProfit);		
				}
			}
		}
		return stock;
	}

	public class Stock { 
		  private int buyDay;
		  private int sellDay;
		  private int maxProfit;
		  
		  @Override
		  public String toString() {
		    return "Buying Day=" +"Day "+ buyDay + ", Selling Day=" +"Day " +sellDay + ", Total gain=" + "$"+maxProfit  + "";
		  }
		  public int getBuyDay() {
		    return buyDay;
		  }
		  public int getMaxprofit() {
		    return maxProfit;
		  }
		  public void setBuyDay(int buyDay) {
		    this.buyDay = buyDay;
		  }
		  public void setSellDay(int sellDay) {
		    this.sellDay = sellDay;
		  }
		  public void setMaxprofit(int maxprofit) {
		    this.maxProfit = maxprofit;
		  }

		}

}
