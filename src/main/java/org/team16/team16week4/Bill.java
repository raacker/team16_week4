package org.team16.team16week4;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
	public Bill(String planName, int usedMinutes, int numberOfLines){
		initBill(planName, usedMinutes, numberOfLines);
		addFileHandler(logger);
	}
	
	private void initBill(String planName, int usedMinutes, int numberOfLines)
	{
		logger.log(Level.FINE, "Plan : " + planName);
		//String inputPlan = sc.next();
		logger.log(Level.FINE, "Total Usage Time : " + usedMinutes);
		//int usedMinutes = sc.nextInt();
		logger.log(Level.FINE, "Using Lines : " + numberOfLines);
		//int numberOfLines = sc.nextInt();
		
		if (numberOfLines < 0)
		{
			logger.log(Level.SEVERE, "Negative number cannot be used for line number");
		}
		else
		{
			if("Gold".equals(planName))
				plan = new Gold();
			else
				plan = new Silver();
		
			this.userObject = new User(plan, numberOfLines, usedMinutes);
			this.detailedCostObject = new DetailedCost(userObject);
		}

	}
	public double drawBill(){
		logger.log(Level.FINE, "Cost : " + this.detailedCostObject.getTotalCost());
		return new Double(this.detailedCostObject.getTotalCost());
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
