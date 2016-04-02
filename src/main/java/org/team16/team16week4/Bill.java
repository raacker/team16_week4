package org.team16.team16week4;
import java.util.Scanner;

public class Bill {
	private User userObject;
	private DetailedCost detailedCostObject;

	public Bill(){
		Plan plan;
		Scanner sc = new Scanner(System.in);
		System.out.print("Plan : ");
		String inputPlan = sc.nextLine();
		System.out.print("총사용시간 : ");
		int usedMinutes = sc.nextInt();
		System.out.print("사용회선 : ");
		int numberOfLines = sc.nextInt();
		
		if(inputPlan.equals("Gold"))
			plan = new Gold();
		else
			plan = new Silver();
		
		this.userObject = new User(plan, numberOfLines, usedMinutes);
		this.detailedCostObject = new DetailedCost(userObject);
	}
	
	public void drawBill(){
		System.out.println("금액 : " + this.detailedCostObject.getTotalCost());
	}
}
