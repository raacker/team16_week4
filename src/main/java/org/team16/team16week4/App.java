package org.team16.team16week4;

/**
 * Hello world!
 *
 */
public class App 
{
	private App(){
	}
	
    public static void main( String[] args )
    {
    	/*
    	 * This is Only Test Data
    	 */
    	String gold = "Gold";
    	Bill bill = new Bill(gold, 1123, 1);
    	bill.drawBill();
    }
}
