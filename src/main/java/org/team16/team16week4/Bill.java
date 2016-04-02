package org.team16.team16week4;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bill {
	private Plan plan;
	private User userObject;
	private DetailedCost detailedCostObject;
	private static final Logger logger = Logger.getLogger(Bill.class.getName());
	private FileHandler fileHandler;
	
	public Bill(){
		initBill();
		addFileHandler(logger);
	}
	
	private void initBill()
	{
		Scanner sc = new Scanner(System.in);
		logger.log(Level.FINE, "Plan : ");
		String inputPlan = sc.nextLine();
		logger.log(Level.FINE, "Total Usage Time : ");
		int usedMinutes = sc.nextInt();
		logger.log(Level.FINE, "Using Lines : ");
		int numberOfLines = sc.nextInt();
		
		if (numberOfLines < 0)
		{
			logger.log(Level.SEVERE, "Negative number cannot be used for line number");
		}
		else
		{
			if("Gold".equals(inputPlan))
				plan = new Gold();
			else
				plan = new Silver();
		
			this.userObject = new User(plan, numberOfLines, usedMinutes);
			this.detailedCostObject = new DetailedCost(userObject);
		}

		sc.close();
	}
	public void drawBill(){
		logger.log(Level.FINE, "Cost : " + this.detailedCostObject.getTotalCost());
	}
	
	private void addFileHandler(Logger logger)
	{
		try
		{
			fileHandler = new FileHandler(Bill.class.getName() + ".log");
		}
		catch(IOException ioe)
		{
			logger.log(Level.SEVERE, null, ioe);
		}
		catch(SecurityException sece)
		{
			logger.log(Level.SEVERE, null, sece);
		}
		logger.addHandler(fileHandler);
	}
}
