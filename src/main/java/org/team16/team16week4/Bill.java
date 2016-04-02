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
		//System.out.print("Plan : ");
		logger.log(Level.FINE, "Plan : ");
		String inputPlan = sc.nextLine();
		//System.out.print("총사용시간 : ");
		logger.log(Level.FINE, "Total Usage Time : ");
		int usedMinutes = sc.nextInt();
		//System.out.print("사용회선 : ");
		logger.log(Level.FINE, "Using Lines : ");
		int numberOfLines = sc.nextInt();
		
		if("Gold".equals(inputPlan))
			plan = new Gold();
		else
			plan = new Silver();
		
		this.userObject = new User(plan, numberOfLines, usedMinutes);
		this.detailedCostObject = new DetailedCost(userObject);

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
		catch(IOException IOE)
		{
			logger.log(Level.SEVERE, null, IOE);
		}
		catch(SecurityException SECE)
		{
			logger.log(Level.SEVERE, null, SECE);
		}
		logger.addHandler(fileHandler);
	}
}
