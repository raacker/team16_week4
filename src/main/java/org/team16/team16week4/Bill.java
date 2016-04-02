package org.team16.team16week4;
import java.io.IOException;
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
		if (numberOfLines < 0)
		{
			logger.log(Level.INFO, "Negative number cannot be used for line number\n");
		}
		else
		{
			logger.log(Level.INFO, "Plan : " + planName + "\nTotal Usage Time : " 
						+ usedMinutes + "\nUsing Lines : " + numberOfLines + "\n");
			if("Gold".equals(planName))
				plan = new Gold();
			else
				plan = new Silver();
		
			this.userObject = new User(plan, numberOfLines, usedMinutes);
			this.detailedCostObject = new DetailedCost(userObject);
		}

	}
	public double drawBill(){
		logger.log(Level.INFO, "Cost : " + this.detailedCostObject.getTotalCost()+ "\n");
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
