package org.team16.team16week4;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bill {
	private Plan plan;
	private User userObject;
	private DetailedCost detailedCostObject;
	private PrintExpectedBill printExpectedBill;
	private static final Logger billLogger = Logger.getLogger(Bill.class.getName());
	private FileHandler fileHandler;
	
	public Bill(String planName, int usedMinutes, int numberOfLines){
		initBill(planName, usedMinutes, numberOfLines);
		addFileHandler(billLogger);
	}
	
	public DetailedCost getDetailedCostObject()
	{
		return this.detailedCostObject;
	}
	public User getUserObject()
	{
		return this.userObject;
	}
	
	private void initBill(String planName, int usedMinutes, int numberOfLines)
	{
		if (numberOfLines < 0)
		{
			billLogger.log(Level.INFO, "Negative number cannot be used for line number\n");
		}
		else
		{
			billLogger.log(Level.INFO, "Plan : " + planName + "\nTotal Usage Time : " 
						+ usedMinutes + "\nUsing Lines : " + numberOfLines + "\n");
			if("Gold".equals(planName))
				plan = new Gold();
			else
				plan = new Silver();
		
			this.userObject = new User(plan, numberOfLines, usedMinutes);
			this.detailedCostObject = new DetailedCost(userObject);
			this.printExpectedBill = new PrintExpectedBill(this.detailedCostObject);
		}
	}

	public void drawBill(){
		billLogger.log(Level.INFO, "TotalCost : " 
					+ this.printExpectedBill.printTotalCostEvaluation()+ "\n"+"AdditionalCost : " 
					+ this.printExpectedBill.printAdditionalLineCostEvaluation()+"\n"+"OverExcessMinutesCost : "
					+ this.printExpectedBill.printOverExcessMinutesCostEvaluation() + "\n");
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
