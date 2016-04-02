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
    	String gold = "Gold";
    	Bill bill = new Bill(gold, 878, 4);
    	bill.drawBill();
    }
}
